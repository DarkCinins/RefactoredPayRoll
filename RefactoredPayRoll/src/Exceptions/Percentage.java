package Exceptions;

public class Percentage extends Exception
{
    public Percentage()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "A porcentagem de comissão não deve ser menor que 0% ou maior que 100%";
    }
}
