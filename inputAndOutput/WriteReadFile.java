package buaphad.tanapad.exercises.inputAndOutput;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteReadFile {

    public static void main(String[] args) {

        String filename = args[0];
        String studentId = "673040622-5";
        String studentNameThai = "ธนพัฒน์ บัวผัด";

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            writer.write(studentId + " " + studentNameThai);
            System.out.println("Writing " + studentId + " " + studentNameThai + " to file " + filename);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Provide filename in the program argument");
        } catch (IOException ex) {
            System.err.println("Error in writing file");
            ex.printStackTrace(System.err);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            System.out.println("Reading " + line + " from file " + filename);
            System.out.println("The read data from the file is");
            System.out.println(line);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Provide filename in the program argument");
        } catch (IOException ex) {
            System.err.println("Error in reading file");
            ex.printStackTrace(System.err);
        }
    }
}