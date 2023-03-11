package my_meth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    public static void main(String[] args) {
        try(Formatter output = new Formatter("zed.txt")){
            Scanner input = new Scanner(System.in);
            System.out.printf("%s%n%s%n ? ","Enter Account number, Firstname, Lastname and balance",
                  "Enter end of file marker to exit");
            while (input.hasNext()){
                try{
                    output.format("%d %s %s %.2f%n",input.nextInt(),input.next(),input.next(),input.nextDouble());
                }
                catch (NoSuchElementException elementException){
                    System.err.println("Invalid input please try again");
                    input.nextLine();
                }
                System.out.print("?");

            }

        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }


    }
}
