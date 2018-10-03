package Exceptions;

import java.util.*;

public class ExceptionsAndGetString
{
    public static String getString()
    {
        String word;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            try
            {
                word = input.nextLine();
                if(word.length() == 0) throw new EmptyInput();
                return word;
            }
            catch(EmptyInput e)
            {
                System.out.printf("Por favor, preencha este campo.%n%n");
            }
        }
    }

    public static int tryingCatchInt()
    {
        int option;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            try
            {
                option = input.nextInt();
                return option;
            }
            catch(InputMismatchException e)
            {
                System.out.printf("Digite apenas inteiros.%n%n");
                input.nextLine();
            }
        }
    }

    public static int tryingCatchInt(int min, int max)
    {
        int option;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            try
            {
                option = input.nextInt();
                if(option < min || option > max)
                {
                    if(max == 31) throw new Month();
                    else throw new InvalidOption();
                }
                return option;
            }
            catch(InputMismatchException | InvalidOption | Month e)
            {
                if(e instanceof InputMismatchException) System.out.printf("Digite apenas inteiros.%n%n");
                else System.out.println(e);
                input.nextLine();
            }
        }
    }

    public static Double tryingCatchDouble(int min, int max)
    {
        double option;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            try
            {
                option = input.nextDouble();
                if(option <= min)
                {
                    if(min == 900 || min == 5) throw new MinimumWage();
                    if(min == 0 && max == 100) throw new Percentage();
                    if(min == 0) throw new NegativeNumber();
                }
                if(option > max)
                {
                    if(max == 20) throw new UnionFee();
                    if(max == 100) throw new Percentage();
                    if(max == 9000 || max == 50) throw new SalaryCap();
                    if(max == 10) throw new Slavery();
                    if(max == 150) throw new SyndicateServiceCharge();
                }
                return option;
            }
            catch(InputMismatchException | UnionFee | MinimumWage | SalaryCap | Percentage | Slavery | NegativeNumber | SyndicateServiceCharge e)
            {
                if(e instanceof InputMismatchException) System.out.printf("Digite apenas Numeros.%n%n");
                else System.out.println(e);
                input.nextLine();
            }
        }
    }
}
