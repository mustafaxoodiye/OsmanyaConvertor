import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String txt="baax'i abti ee enegadaa oo ogolaw kh dh sh";        
        
        Convert toOsmanya= new Convert(txt);
        String convertedText= toOsmanya.stringToChars();

        writeUsingFileWriter(convertedText);
        System.out.println("letter a was converted to " + convertedText);
    }

    private static void writeUsingFileWriter(String convertedText) {
        File file = new File("C:/Users/User/Desktop/Python/Java/output.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(convertedText);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}