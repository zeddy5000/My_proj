package my_meth;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileAndDiectoryInfo {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //System.out.println("Enter the name of your desired file");
        Path path = Paths.get("/home/zeddy/Desktop/zeddicus");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

        if(Files.exists(path)){
            System.out.printf("%n%s exists%n",path.getFileName());
            System.out.printf("%s a directory",Files.isDirectory(path) ? "Is":"Is not");
        }
        if(Files.isDirectory(path)){
            for(Path p : directoryStream) System.out.println(p);
        }
        else{
            System.out.printf("%s does not exist",path);
        }
    }
}
