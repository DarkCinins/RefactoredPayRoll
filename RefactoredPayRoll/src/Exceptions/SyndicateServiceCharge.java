package Exceptions;

public class SyndicateServiceCharge extends Exception
{
    public SyndicateServiceCharge()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "Por lei o sindicato não pode cobrar taxas superiores a R$150,00";
    }
}
