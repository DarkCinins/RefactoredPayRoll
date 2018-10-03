package Exceptions;

public class NegativeNumber extends Exception
{
    public NegativeNumber()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "Digite um valor maior que 0.";
    }
}
