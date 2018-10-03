package View;

import Exceptions.ExceptionsAndGetString;

public class UserInterface
{
    public static int mainMenu()
    {
        System.out.println("1 - Contratar Empregado");
        System.out.println("2 - Demitir Empregado");
        System.out.println("3 - Visualizar Informações dos Empregados");
        System.out.println("4 - Lançar Cartão de Ponto");
        System.out.println("5 - Lançar Resultado de Venda");
        System.out.println("6 - Lançar Taxa de Serviço");
        System.out.println("7 - Alterar Informações de um Empregado");
        System.out.println("8 - Efetuar Pagamento");
        System.out.println("9 - Criar Nova Agenda de Pagamento");
        System.out.println("10 - Sair");
        return ExceptionsAndGetString.tryingCatchInt(1,10);
    }

    public static int addEmployeeMenu()
    {
        System.out.println("Tipo de empregado a ser adicionado:");
        System.out.println("1 - Horista");
        System.out.println("2 - Assalariado");
        System.out.println("3 - Assalariado Comissionado");
        return ExceptionsAndGetString.tryingCatchInt(1,3);
    }

    public static int setPayDayMenu()
    {
        System.out.println("Agenda de Pagamento:");
        System.out.println("1 - Mensal");
        System.out.println("2 - Quinzenal");
        System.out.println("3 - Semanal");
        return ExceptionsAndGetString.tryingCatchInt(1,3);
    }

    public static int paymentMethodMenu()
    {
        System.out.println("Defina um método de pagamento:");
        System.out.println("1 - Cheque pelos correios");
        System.out.println("2 - Cheque em mãos");
        System.out.println("3 - Depósito");
        return ExceptionsAndGetString.tryingCatchInt(1,3);
    }

    public static int setSyndicateMenu()
    {
        System.out.println("O funcionário é membro do sindicato?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        return ExceptionsAndGetString.tryingCatchInt(1,2);
    }

    public static int employeeCodeMenu()
    {
        System.out.println("Código do funcionário:");
        return ExceptionsAndGetString.tryingCatchInt();
    }

    public static double addTimeWorkedMenu()
    {
        System.out.println("Horas trabalhadas:");
        return ExceptionsAndGetString.tryingCatchDouble(0,10);
    }

    public static double addSaleResultMenu()
    {
        System.out.println("Valor total das vendas de hoje:");
        return ExceptionsAndGetString.tryingCatchDouble(0,999);
    }

    public static double serviceChargeMenu()
    {
        System.out.println("Valor da da taxa de serviço:");
        return ExceptionsAndGetString.tryingCatchDouble(0,150);
    }

    public static String serviceDescriptionMenu()
    {
        System.out.println("Descrição da taxa cobrada:");
        return ExceptionsAndGetString.getString();
    }

    public static int changeDataMenu()
    {
        System.out.println("Qual informação deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Função");
        System.out.println("3 - Rua");
        System.out.println("4 - Bairro");
        System.out.println("5 - Número da Casa");
        System.out.println("6 - CEP");
        System.out.println("7 - Data de Pagamento");
        System.out.println("8 - Método de Pagamento");
        System.out.println("9 - Particição Sindical");
        System.out.println("10 - Porcentagem de Lucro");
        System.out.println("11 - Salário por Hora");
        System.out.println("12 - Salário Mensal");
        return ExceptionsAndGetString.tryingCatchInt(1,11);
    }

    public static int payDayMenu()
    {
        System.out.println("Que dia é hoje?");
        return ExceptionsAndGetString.tryingCatchInt(1,31);
    }

    public static int setNewPayDayMenu()
    {
        System.out.println("Em quantos dias por mês o funcionário irá receber seu salário?");
        return ExceptionsAndGetString.tryingCatchInt(1,31);
    }

    public static boolean undo()
    {
        System.out.println("Ação realizada com sucesso. Deseja desfazer?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = ExceptionsAndGetString.tryingCatchInt(1,2);
        if(option == 1) return redo();
        else return false;
    }

    public static boolean undoPayment(int day)
    {
        System.out.println("Pagamento efetuado para funcionários que recebem dia " + day);
        System.out.println("1 - Desfazer");
        System.out.println("2 - Mostrar Folhas de Pagamento.");
        int option = ExceptionsAndGetString.tryingCatchInt(1,2);
        if(option == 1) return redo();
        else return false;
    }

    public static boolean redo()
    {
        System.out.println("Ação desfeita com sucesso. Deseja refazer?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = ExceptionsAndGetString.tryingCatchInt(1,2);
        if(option == 1) return undo();
        else return true;
    }
}
