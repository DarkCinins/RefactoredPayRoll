package Informations;

import Exceptions.ExceptionsAndGetString;

public class AddressBuilder
{
    private String street;
    private String neighborhood;
    private int houseNumber;
    private String cep;

    public AddressBuilder()
    {
        setStreet();
        setNeighborhood();
        setCep();
        setHouseNumber();
    }

    private void setStreet()
    {
        System.out.println("Rua:");
        this.street = ExceptionsAndGetString.getString();
    }

    private void setNeighborhood()
    {
        System.out.println("Bairro:");
        this.neighborhood = ExceptionsAndGetString.getString();
    }

    private void setCep()
    {
        System.out.println("CEP:");
        this.cep = ExceptionsAndGetString.getString();
    }

    private void setHouseNumber()
    {
        System.out.println("Número da casa:");
        this.houseNumber = ExceptionsAndGetString.tryingCatchInt();
    }

    public String getStreet()
    {
        return street;
    }

    public String getNeighborhood()
    {
        return neighborhood;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public String getCep()
    {
        return cep;
    }
}
