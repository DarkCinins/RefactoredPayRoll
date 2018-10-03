package Exceptions;

public class MinimumWage extends Exception
{
    public MinimumWage()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "Por lei o salário de cada funcionário não deve ser inferior a:" + "\n"
                + "R$900,00 por mês para empregados assalariados" + "\n"
                + "R$5,00 por hora para empregados horistas.";
    }
}
