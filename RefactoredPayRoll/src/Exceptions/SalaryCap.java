package Exceptions;

public class SalaryCap extends Exception
{
    public SalaryCap()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "Por lei o salário de cada funcionário não deve ser superior a:" + "\n"
                + "R$9.000,00 por mês para empregados assalariados" + "\n"
                + "R$50,00 por hora para empregados horistas.";
    }
}
