package Employees;

import Exceptions.*;
import Informations.*;
import Informations.PaymentMethod.*;
import View.UserInterface;
import java.util.ArrayList;

public class EmployeeBase implements Employee
{
    private int code;
    private ArrayList<Integer> payDay;
    private String name;
    private String function;
    private Addresses address;
    private PaymentMethod paymentMethod;
    private boolean syndicate;
    private double syndicateValue;
    private ArrayList<Double> serviceCharge = new ArrayList<>();
    private ArrayList<String> serviceDescription = new ArrayList<>();

    public EmployeeBase(int code, String name)
    {
        this.code = code;
        payDay = new ArrayList<>();
        setPayDay(UserInterface.setPayDayMenu());
        setName(name);
        setFunction();
        address = new Addresses(new AddressBuilder());
        setPaymentMethod();
        setSyndicate();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPayDay(int days)
    {
        switch(days)
        {
            case 1:
                System.out.println("Dia de pagamento:");
                this.payDay.add(ExceptionsAndGetString.tryingCatchInt(1,31));
                break;
            case 2:
                System.out.println("O pagamento será realizado nos dias 01 e 15 de cada mês.");
                this.payDay.add(1);
                this.payDay.add(15);
                break;
            case 3:
                System.out.println("O pagamento será realizado nos dias 01, 07, 15 e 23 de cada mês.");
                this.payDay.add(1);
                this.payDay.add(7);
                this.payDay.add(15);
                this.payDay.add(23);
                break;
        }
    }

    public void setFunction()
    {
        System.out.println("Função:");
        this.function = ExceptionsAndGetString.getString();
    }

    public void setPaymentMethod()
    {
        int option = UserInterface.paymentMethodMenu();
        switch(option)
        {
            case 1:
                this.paymentMethod = new CheckByCurrier();
                break;
            case 2:
                this.paymentMethod = new CheckInHands();
                break;
            case 3:
                this.paymentMethod = new Deposit();
                break;
        }
    }

    public void setSyndicate()
    {
        if(UserInterface.setSyndicateMenu() == 1)
        {
            this.syndicate = true;
            System.out.println("Taxa sindical:");
            this.syndicateValue = ExceptionsAndGetString.tryingCatchDouble(0,20);
        }
        else
        {
            this.syndicate = false;
            this.syndicateValue = 0;
        }
    }

    public void setServiceCharge(double value)
    {
        this.serviceCharge.add(value);
    }

    public void setServiceDescription(String description)
    {
        this.serviceDescription.add(description);
    }

    public String getName()
    {
        return this.name;
    }

    public int getCode()
    {
        return this.code;
    }

    public ArrayList<Integer> getPayDay()
    {
        return payDay;
    }

    public ArrayList<Double> getServiceCharge()
    {
        return this.serviceCharge;
    }

    public ArrayList<String> getServiceDescription()
    {
        return this.serviceDescription;
    }

    public double getSyndicateValue()
    {
        return syndicateValue;
    }

    public String getFunction()
    {
        return function;
    }

    public boolean isSyndicate()
    {
        return syndicate;
    }

    public void setStreet()
    {
        address.setStreet();
    }

    public void setNeighborhood()
    {
        address.setNeighborhood();
    }

    public void setCep()
    {
        address.setCep();
    }

    public void setHouseNumber()
    {
        address.setHouseNumber();
    }

    public void setNewPayDay(int days)
    {
        System.out.println("Dias de pagamento:");
        int[] array = new int[30];
        for(int i = 0; i < days; i++)
            array[i] = ExceptionsAndGetString.tryingCatchInt(1,31);
        if(!UserInterface.undo())
        {
            payDay.clear();
            for(int i = 0; i < days; i++)
                this.payDay.add(array[i]);
        }
    }

    @Override
    public String toString()
    {
        return "Código - " + this.code + "\n"
                + "Funcionário - " + this.name + "\n"
                + "Função - " + this.function + "\n"
                + address.toString()
                + "Método de Pagamento - " + this.paymentMethod.toString() + "\n"
                + "Participação em Sindicato - " + this.syndicate + "\n"
                + "Contribuição Sindical - R$" + this.syndicateValue + "\n";
    }
}