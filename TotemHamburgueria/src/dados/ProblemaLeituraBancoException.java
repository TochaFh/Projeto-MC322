package dados;

public class ProblemaLeituraBancoException extends Exception {

    public ProblemaLeituraBancoException()
    {
        super("Problema na leitura da base de dados!");
    }

    public ProblemaLeituraBancoException(String tipoBanco)
    {
        super("Problema na leitura da base de dados! - " + tipoBanco);
    }

    public ProblemaLeituraBancoException(String tipoBanco, Throwable causa)
    {
        super("Problema na leitura da base de dados! - " + tipoBanco, causa);
    }
}
