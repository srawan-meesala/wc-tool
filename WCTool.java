import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WCTool {

    public static long printFileSize(File file) {
        if (file.exists()) {
            return file.length();
        } else {
            return -1;
        }
    }

    public static long printFileLines(String filename) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            long lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();
            return lines;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    public static long printFileWords(File file) throws FileNotFoundException{
        try(Scanner sc = new Scanner(new FileInputStream(file))){
            long count=0;
            while(sc.hasNext()){
                sc.next();
                count++;
            }
            return count;
        }
    }

    public static long printFileChars(String filename) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            long chars = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                chars += line.length();
            }
            reader.close();
            return chars;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    public static void main(String[] args){
        System.out.println("Args Length:" + args.length);
        if(args.length == 2) {
            String filename = args[1];
            String option = args[0];
            System.out.println("Option: " + option + " filename: " + filename);
            switch (option) {
                case "-c":
                    long size = printFileSize(new File(filename));
                    if (size == -1) {
                        System.out.println("File does not exist " + filename);
                    } else {
                        System.out.println(size + " " + filename);
                    }
                    break;
                case "-l":
                    try {
                        long lines = printFileLines(filename);
                        if (lines == -1) {
                            System.out.println("File does not exist " + filename);
                        } else {
                            System.out.println(lines + " " + filename);
                        }
                    } catch (IOException e) {
                        System.out.println("File does not exist " + filename);
                    }
                    break;
                case "-w":
                    try {
                        long words = printFileWords(new File(filename));
                        if (words == -1) {
                            System.out.println("File does not exist " + filename);
                        } else {
                            System.out.println(words + " " + filename);
                        }
                    } catch (IOException e) {
                        System.out.println("File does not exist " + filename);
                    }
                    break;
                case "-m":
                    try {
                        long chars = printFileChars(filename);
                        if (chars == -1) {
                            System.out.println("File does not exist " + filename);
                        } else {
                            System.out.println(chars + " " + filename);
                        }
                    } catch (IOException e) {
                        System.out.println("File does not exist " + filename);
                    }
                    break;
                default:
                    System.out.println("No option");
                    break;
            }
        }
    }
}
