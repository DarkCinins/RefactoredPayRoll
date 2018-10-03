package Employees;

import Exceptions.*;

public class Hourly extends EmployeeDecorator
{
    private double hourlyWage;
    private double timeWorked;
    private double overTime;

    public Hourly(Employee employee)
    {
        super(employee);
        setHourlyWage();
        this.timeWorked = 0;
        this.overTime = 0;
    }

    public void setHourlyWage()
    {
        System.out.println("Salário por hora:");
        this.hourlyWage = ExceptionsAndGetString.tryingCatchDouble(5,50);
    }

    public void resetTime()
    {
        this.overTime = 0;
        this.timeWorked = 0;
    }

    public double getHourlyWage()
    {
        return hourlyWage;
    }

    public double getTimeWorked()
    {
        return timeWorked;
    }

    public double getOverTime()
    {
        return overTime;
    }

    public void addTimeWorked(double time)
    {
        if(time > 8)
        {
            this.timeWorked += 8;
            this.overTime += time-8;
        }
        else this.timeWorked += time;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + "Salário por Hora - R$" + this.hourlyWage + "\n"
                + "Horas Trabalhadas Desde o Último Pagamento - " + (this.timeWorked+this.overTime) + "h\n";
    }
}