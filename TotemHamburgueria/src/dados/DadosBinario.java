package dados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DadosBinario extends BancoDeDados
{
    private String nomeArquivo;

    public DadosBinario(String nomeArquivoBinario)
    {
        nomeArquivo = nomeArquivoBinario;
    }

    // gera um arquivo de serialização dos dados gerados pela 'DadosHardcoded'
    public static void gerarArquivoDefault() throws FileNotFoundException, IOException
    {
        DadosApp dados = new DadosHardcoded().obterDadosApp();

        var outputStream = new ObjectOutputStream(new FileOutputStream("dadosapp_default_binario"));

        outputStream.writeObject(dados);
        outputStream.flush();

        outputStream.close();
    }

    @Override
    public DadosApp obterDadosApp() throws ProblemaLeituraBancoException {

        DadosApp dados;
        ObjectInputStream inputStream;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));
            dados = (DadosApp) inputStream.readObject();
            inputStream.close();
        }
        catch (ClassNotFoundException | IOException e) {
            throw new ProblemaLeituraBancoException("DadosBinario", e);
        }

        return dados;
    }

}
