package Exceptions;

public class UnionFee extends Exception
{
    public UnionFee()
    {
        super();
    }

    @Override
    public String toString() {
        return "Por lei o sindicato não pode cobrar mais de R$20,00 nem valores negativos, e obrigatoriamente algum valor deve ser cobrado.";
    }
}
