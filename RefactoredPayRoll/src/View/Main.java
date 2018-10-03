package View;

import Operations.EmployeeOperations;

public class Main
{
    public static void main(String args[])
    {
        int option;
        EmployeeOperations employeeOperations = new EmployeeOperations();

        do
        {
            option = UserInterface.mainMenu();
            switch(option)
            {
                case 1:
                    employeeOperations.addEmployee(UserInterface.addEmployeeMenu());
                    break;
                case 2:
                    employeeOperations.removeEmployee(UserInterface.employeeCodeMenu());
                    break;
                case 3:
                    employeeOperations.printEmployees();
                    break;
                case 4:
                    employeeOperations.setPointCard(UserInterface.employeeCodeMenu());
                    break;
                case 5:
                    employeeOperations.setSaleResult(UserInterface.employeeCodeMenu());
                    break;
                case 6:
                    employeeOperations.setServiceCharge(UserInterface.employeeCodeMenu());
                    break;
                case 7:
                    employeeOperations.chageData(UserInterface.changeDataMenu(),UserInterface.employeeCodeMenu());
                    break;
                case 8:
                    employeeOperations.setPayment(UserInterface.payDayMenu());
                    break;
                case 9:
                    employeeOperations.setNewPayDay(UserInterface.employeeCodeMenu());
                    break;
            }
        }while(option != 10);
    }
}
