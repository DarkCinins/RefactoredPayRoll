package Exceptions;

public class Slavery extends Exception
{
    public Slavery()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "Trabalhar mais de 10h por dia é escravidão. Digite outra carga horária.";
    }
}
