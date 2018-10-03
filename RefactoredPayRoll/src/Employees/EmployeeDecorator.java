package Employees;

import java.util.ArrayList;

public class EmployeeDecorator implements Employee
{
    private Employee employee;

    public EmployeeDecorator(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    @Override
    public String getName()
    {
        return this.employee.getName();
    }

    @Override
    public int getCode()
    {
        return this.employee.getCode();
    }

    @Override
    public String getFunction()
    {
        return this.employee.getFunction();
    }

    @Override
    public boolean isSyndicate()
    {
        return this.employee.isSyndicate();
    }

    @Override
    public void setServiceCharge(double value)
    {
        this.employee.setServiceCharge(value);
    }

    @Override
    public void setServiceDescription(String description)
    {
        this.employee.setServiceDescription(description);
    }

    @Override
    public void setName(String name)
    {
        this.employee.setName(name);
    }

    @Override
    public void setPayDay(int days)
    {
        this.employee.setPayDay(days);
    }

    @Override
    public void setFunction()
    {
        this.employee.setFunction();
    }

    @Override
    public void setPaymentMethod()
    {
        this.employee.setPaymentMethod();
    }

    @Override
    public void setSyndicate()
    {
        this.employee.setSyndicate();
    }

    @Override
    public void setStreet()
    {
        this.employee.setStreet();
    }

    @Override
    public void setNeighborhood()
    {
        this.employee.setNeighborhood();
    }

    @Override
    public void setCep()
    {
        this.employee.setCep();
    }

    @Override
    public void setHouseNumber()
    {
        this.employee.setHouseNumber();
    }

    @Override
    public ArrayList<Integer> getPayDay()
    {
        return this.employee.getPayDay();
    }

    @Override
    public ArrayList<Double> getServiceCharge()
    {
        return this.employee.getServiceCharge();
    }

    @Override
    public ArrayList<String> getServiceDescription()
    {
        return this.employee.getServiceDescription();
    }

    @Override
    public double getSyndicateValue()
    {
        return this.employee.getSyndicateValue();
    }

    @Override
    public void setNewPayDay(int days)
    {
        this.employee.setNewPayDay(days);
    }

    @Override
    public String toString()
    {
        return this.employee.toString();
    }
}
