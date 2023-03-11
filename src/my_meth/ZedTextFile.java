package my_meth;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ZedTextFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try(Formatter output = new Formatter("Kingzed.txt")){
            System.out.printf("%n%s%n%s? ","Enter account number,firstname,lastname and balance",
                    "enter end of file marker to exit");
            while (input.hasNext()){
                output.format("%-12d %-12s %-12s %10.2f",input.nextInt(),input.next(),input.next(),input.nextDouble());
            }
            System.out.println("? ");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
