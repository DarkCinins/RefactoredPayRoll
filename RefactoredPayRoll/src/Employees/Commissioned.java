package Employees;

import Exceptions.ExceptionsAndGetString;

public class Commissioned extends EmployeeDecorator
{
    private double commissionPercentage;
    private double salesAmount;

    public Commissioned(Employee employee)
    {
        super(employee);
        this.salesAmount = 0;
        setCommissionPercentage();
    }

    public void setCommissionPercentage()
    {
        System.out.println("Porcentagem de Comissão por Venda:");
        this.commissionPercentage = ExceptionsAndGetString.tryingCatchDouble(0,100);
    }

    public void setSalesAmount(double value)
    {
        this.salesAmount += value;
    }

    public void resetSalesAmount()
    {
        this.salesAmount = 0;
    }

    public double getCommissionPercentage()
    {
        return commissionPercentage;
    }

    public double getSalesAmount()
    {
        return salesAmount;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + "Porcentagem de Comissão - " + this.commissionPercentage + "%\n"
                + "Valor Total de Vendas Desde o Último Pagamento - R$" + this.salesAmount + "\n";
    }
}