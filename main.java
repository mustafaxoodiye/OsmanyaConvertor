import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String txt="mustafaa abshir xoodiyee";        
        
        Convert toOsmanya= new Convert(txt);
        String convertedText= toOsmanya.stringToChars();

        writeUsingFileWriter(convertedText);
        System.out.println("Your text is converted to " + convertedText);
    }

    private static void writeUsingFileWriter(String convertedText) {
        File file = new File("C:/Users/User/Desktop/Java/OsmanyaConvertor/output.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, false);
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