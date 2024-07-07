package dados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;


public class DadosJson extends BancoDeDados {

    private String nomeArquivo;

    public DadosJson(String nomeArquivoBinario)
    {
        nomeArquivo = nomeArquivoBinario;
    }

    // gera um arquivo json dos dados gerados pela 'DadosHardcoded'
    public static void gerarArquivoDefault() throws IOException
    {
        DadosApp dados = new DadosHardcoded().obterDadosApp();

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
        .allowIfSubType("com.baeldung.jackson.inheritance")
        .allowIfSubType("java.util.ArrayList")
        .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        String json = mapper.writeValueAsString(dados);

        Files.writeString(Paths.get("dadosapp_default.json"), json);
    }

    @Override
    public DadosApp obterDadosApp() throws ProblemaLeituraBancoException {

        String json;

        try {
            json = Files.readString(Paths.get(nomeArquivo));
        }
        catch (IOException e) {
            throw new ProblemaLeituraBancoException("DadosJson", e);
        }

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
        .allowIfSubType("com.baeldung.jackson.inheritance")
        .allowIfSubType("java.util.ArrayList")
        .build();
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        //mapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);

        DadosApp dados;

        try {
            dados = mapper.readValue(json, DadosApp.class);
        }
        catch (JsonProcessingException e) {
            throw new ProblemaLeituraBancoException("DadosJson", e);
        }

        return dados;
    }

}
