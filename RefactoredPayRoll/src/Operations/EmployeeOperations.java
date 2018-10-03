package Operations;

import Employees.*;
import Exceptions.ExceptionsAndGetString;
import View.UserInterface;
import java.util.*;

public class EmployeeOperations
{
    private int code;
    private ArrayList<Employee> employees;

    public EmployeeOperations()
    {
        this.code = 0;
        this.employees = new ArrayList<>();
    }

    private int findEmployee(int code)
    {
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getCode() == code) return i;
        System.out.println("Funcionário não encontrado.");
        return -1;
    }

    private String checkName()
    {
        System.out.println("*Não é possível adicionar funcionários com o mesmo nome.");
        System.out.println("Nome:");
        String name = ExceptionsAndGetString.getString();
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getName().equals(name)) return checkName();
        return name;
    }

    public void addEmployee(int type)
    {
        if(employees.size() == 10) System.out.println("Limite máximo de 10 funcionários atigido.");
        else
        {
            switch(type)
            {
                case 1:
                    employees.add(new Hourly(new EmployeeBase(code,checkName())));
                    break;
                case 2:
                    employees.add(new Salaried(new EmployeeBase(code,checkName())));
                    break;
                case 3:
                    employees.add(new Commissioned(new Salaried(new EmployeeBase(code,checkName()))));
                    break;
            }
            code++;
            System.out.println("Funcionário adicionado com sucesso.");
        }
        if(UserInterface.undo()) employees.remove(employees.size()-1);
    }

    public void removeEmployee(int code)
    {
        if(!UserInterface.undo())
        {
            int i = findEmployee(code);
            if(i != -1)
            {
                employees.remove(i);
                System.out.println("Funcionário demitido com sucesso.");
            }
        }
    }

    public void printEmployees()
    {
        for(int i = 0; i < employees.size(); i++)
            System.out.println(employees.get(i).toString());
    }

    public void setPointCard(int code)
    {
        if(!UserInterface.undo())
        {
            int i = findEmployee(code);
            if(i != -1)
            {
                if(employees.get(i) instanceof Hourly)
                {
                    double check = UserInterface.addTimeWorkedMenu();
                    if(!UserInterface.undo())((Hourly) employees.get(i)).addTimeWorked(check);
                }
                else System.out.println("Funcionário selecionado não é do tipo horista.");
            }
        }
    }

    public void setSaleResult(int code)
    {
        int i = findEmployee(code);
        if(i != -1)
        {
            if(employees.get(i) instanceof Commissioned)
            {
                double check = UserInterface.addSaleResultMenu();
                if(!UserInterface.undo())((Commissioned) employees.get(i)).setSalesAmount(check);
            }
            else System.out.println("Funcionário selecionado não é do tipo comissionado.");
        }
    }

    public void setServiceCharge(int code)
    {
        int i = findEmployee(code);
        if(i != -1)
        {
            if(employees.get(i).isSyndicate())
            {
                double charge = UserInterface.serviceChargeMenu();
                String description = UserInterface.serviceDescriptionMenu();
                if(!UserInterface.undo())
                {
                    employees.get(i).setServiceCharge(charge);
                    employees.get(i).setServiceDescription(description);
                }
            }
            else System.out.println("Funcionário selecionado não faz parte do sindicato.");
        }
    }

    public void chageData(int option, int code)
    {
        int i = findEmployee(code);
        if(i != -1)
        {
            switch(option)
            {
                case 1:
                    employees.get(i).setName(checkName());
                    break;
                case 2:
                    employees.get(i).setFunction();
                    break;
                case 3:
                    employees.get(i).setStreet();
                    break;
                case 4:
                    employees.get(i).setNeighborhood();
                    break;
                case 5:
                    employees.get(i).setHouseNumber();
                    break;
                case 6:
                    employees.get(i).setCep();
                    break;
                case 7:
                    employees.get(i).setPayDay(UserInterface.setPayDayMenu());
                    break;
                case 8:
                    employees.get(i).setPaymentMethod();
                    break;
                case 9:
                    employees.get(i).setSyndicate();
                    break;
                case 10:
                    if(employees.get(i) instanceof Commissioned) ((Commissioned) employees.get(i)).setCommissionPercentage();
                    else System.out.println("Funcionário escolhido não é do tipo comissionado.");
                    break;
                case 11:
                    if(employees.get(i) instanceof Hourly) ((Hourly) employees.get(i)).setHourlyWage();
                    else System.out.println("Funcionário escolhido não é do tipo horista.");
                    break;
                case 12:
                    if(employees.get(i) instanceof Salaried) ((Salaried) employees.get(i)).setSalary();
                    else System.out.println("Funcionário escolhido não é do tipo assalariado.");
                    break;
            }
        }
    }

    private boolean checkPayDay(int index, int day)
    {
        for(int i = 0; i < employees.get(index).getPayDay().size(); i++)
            if(employees.get(index).getPayDay().get(i) == day) return true;
        return false;
    }

    private double checkDiscounts(double total, int index)
    {
        for(int i = 0; i < employees.get(index).getServiceCharge().size(); i++)
        {
            if((total - employees.get(index).getServiceCharge().get(i)) > 0)
            {
                total -= employees.get(index).getServiceCharge().get(i);
                System.out.println("- R$" + employees.get(index).getServiceCharge().get(i) + "\tDescrição: " + employees.get(index).getServiceDescription().get(i));
                employees.get(index).getServiceCharge().remove(i);
                employees.get(index).getServiceDescription().remove(i);
                i--;
            }
            else
            {
                System.out.println("Demais cobranças serão feitas na próxima folha pois o salário do funcionário não pode ser negativo.");
                return total;
            }
        }
        return total;
    }

    public void setPayment(int day)
    {
        if(!UserInterface.undoPayment(day))
        {
            for(int i = 0; i < employees.size(); i++)
            {
                if(checkPayDay(i,day))
                {
                    double total;
                    System.out.println("Nome: " + employees.get(i).getName());
                    System.out.println("Função: " + employees.get(i).getFunction());
                    if(employees.get(i) instanceof Commissioned)
                    {
                        total = ((Salaried) ((Commissioned) employees.get(i)).getEmployee()).getSalary();
                        System.out.println("Salário Bruto: R$" + total);
                        double comission = ((Commissioned) employees.get(i)).getSalesAmount()*((Commissioned) employees.get(i)).getCommissionPercentage()/100;
                        total += comission;
                        System.out.println("+ R$" + comission + "\tDescrição: Comissão");
                        ((Commissioned) employees.get(i)).resetSalesAmount();
                        if(employees.get(i).isSyndicate())
                        {
                            System.out.println("- R$" + employees.get(i).getSyndicateValue() + "\tDescrição: Taxa Sindical");
                            total -= employees.get(i).getSyndicateValue();
                        }
                        total = checkDiscounts(total,i);
                        System.out.println("Salário Líquido: R$" + total);
                    }
                    else if(employees.get(i) instanceof Salaried)
                    {
                        total = ((Salaried) employees.get(i)).getSalary();
                        System.out.println("Salário Bruto: R$" + total);
                        if(employees.get(i).isSyndicate())
                        {
                            System.out.println("- R$" + employees.get(i).getSyndicateValue() + "\tDescrição: Taxa Sindical");
                            total -= employees.get(i).getSyndicateValue();
                        }
                        total = checkDiscounts(total,i);
                        System.out.println("Salário Líquido: R$" + total);
                    }
                    if(employees.get(i) instanceof Hourly)
                    {
                        double timeWorked = ((Hourly) employees.get(i)).getTimeWorked()*((Hourly) employees.get(i)).getHourlyWage();
                        double overtime = ((Hourly) employees.get(i)).getOverTime()*((Hourly) employees.get(i)).getHourlyWage()*1.5;
                        total = timeWorked + overtime;
                        System.out.println("+ R$" + timeWorked + "\tDescrição: Horas Trabalhadas");
                        System.out.println("+ R$" + overtime + "\tDescrição: Horas Extras");
                        ((Hourly) employees.get(i)).resetTime();
                        if(employees.get(i).isSyndicate())
                        {
                            System.out.println("- R$" + employees.get(i).getSyndicateValue() + "\tDescrição: Taxa Sindical");
                            total -= employees.get(i).getSyndicateValue();
                        }
                        total = checkDiscounts(total,i);
                        System.out.println("Salário Líquido: R$" + total);
                    }
                    System.out.println();
                }
            }
        }
    }

    public void setNewPayDay(int code)
    {
        code = findEmployee(code);
        if(code != -1) employees.get(code).setNewPayDay(UserInterface.setNewPayDayMenu());
    }
}
