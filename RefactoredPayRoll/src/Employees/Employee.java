package Employees;

import java.util.ArrayList;

public interface Employee
{
    String getName();
    int getCode();
    String getFunction();
    boolean isSyndicate();
    void setServiceCharge(double value);
    void setServiceDescription(String description);
    void setName(String name);
    void setPayDay(int days);
    void setFunction();
    void setPaymentMethod();
    void setSyndicate();
    void setStreet();
    void setNeighborhood();
    void setCep();
    void setHouseNumber();
    ArrayList<Integer> getPayDay();
    ArrayList<Double> getServiceCharge();
    ArrayList<String> getServiceDescription();
    double getSyndicateValue();
    void setNewPayDay(int days);
}
