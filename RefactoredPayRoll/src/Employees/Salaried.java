package Employees;

import Exceptions.ExceptionsAndGetString;

public class Salaried extends EmployeeDecorator
{
    private double salary;

    public Salaried(Employee employee)
    {
        super(employee);
        setSalary();
    }

    public void setSalary()
    {
        System.out.println("Salário Mensal:");
        this.salary = ExceptionsAndGetString.tryingCatchDouble(900,9000);
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + "Salário - R$" + this.salary + "\n";
    }
}
