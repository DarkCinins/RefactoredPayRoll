package Exceptions;

public class InvalidOption extends Exception
{
    public InvalidOption()
    {
        super();
    }

    @Override
    public String toString() {
        return "Opção Inválida.";
    }
}
