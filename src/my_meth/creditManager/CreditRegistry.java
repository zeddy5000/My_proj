package my_meth.creditManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditRegistry {
    private final static CreditScores[] choices = CreditScores.values();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CreditScores accountType = getRequest(input);

        while (accountType != CreditScores.END){
            switch (accountType){
                case ZERO_BALANCE-> System.out.printf("%n Accounts with zero balance are:%n");
                case CREDIT_BALANCE -> System.out.printf("%n Accounts with credit balance are:%n");
                case DEBIT_BALANCE -> System.out.printf("%n Accounts with debit balance are:%N");
            }
            readRecords(accountType);
            System.out.println();
            getRequest(input);

        }
    }

    private static void readRecords(CreditScores accountType) {
        try(Scanner input = new Scanner(Paths.get("zed.txt"))) {

            while (input.hasNext()) {
                int acctNumber = input.nextInt();
                String firstName = input.next();
                String lastName = input.next();
                double balance = input.nextDouble();

                if (shouldDisplay(accountType,balance)) {
                    System.out.printf("%-12d%-12s%-12s%10.2f",acctNumber,firstName,lastName,balance);;
                }
                else {
                    input.nextLine();
                }
            }


        }
        catch (SecurityException | IOException e){
            System.err.println("Error processing file. Terminating");
            System.exit(1);
        }

    }

    private static boolean shouldDisplay(CreditScores option, double balance) {
        if((option == CreditScores.CREDIT_BALANCE) && (balance < 0)){
            return true;
        }
        else  if((option == CreditScores.DEBIT_BALANCE) && (balance > 0)){
            return true;
        }
        else  if((option == CreditScores.ZERO_BALANCE) && (balance == 0)){
            return true;
        }
        return false;
    }

    private static CreditScores getRequest(Scanner input) {
        int request = 4;
        System.out.println(prompt);

        try {
            do {
                System.out.printf("%n?");
                request = input.nextInt();
            }
            while (request < 1 || request > 4);
        }
        catch(NoSuchElementException e ){
            System.err.println("No such element, Terminating");
        }
        return choices[request-1];

            }
    private static String prompt = """
            Enter Request
            1. List accounts with zero balances
            2. List accounts with credit balances
            3. List accounts with debit balances
            4. Terminate program
            """;
        



}

