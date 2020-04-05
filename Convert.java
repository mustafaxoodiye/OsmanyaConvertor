
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Convert {

    String text;
    
    public Convert(String text)
    {
        this.text=text;
    }

    public String stringToChars() throws FileNotFoundException, IOException
    {
        String convertedText="";
        char[] ch = text.toCharArray(); 

        for (char c : ch) {             
            if(c != ' '){
                String convertedChar=convertToOsmanya(c);
                convertedText+=convertedChar;
            }
            else{
                convertedText+=" ";
            }
        } 

        convertedText=polishing(convertedText);
        return convertedText;
    }
    
    public String convertToOsmanya(char c) throws FileNotFoundException, IOException
    {
        String s=Character.toString(c);
        String convertedChar="";
        File f = new File("C:/Users/User/Desktop/Python/Java/data.txt");
        Scanner in = new Scanner(f);

        ArrayList<String> inLines = new ArrayList<>();
        String read;
        while (in.hasNextLine()){
            read = in.nextLine();
            inLines.add(read);
        }
        for(int i=0; i<inLines.size(); i++){

            String selectedLine = inLines.get(i);
            String[] inWords = selectedLine.split(" ");                 
            String letter=inWords[0];

            if(letter.equals(s)){
                int result=i+1;
                System.out.println("I found it in line " + result);           
                convertedChar=inWords[1];  
            } 
            // else{
            //     System.out.println("not equal, the char is " + letter + " and the s is " + s);
            // }
        }
        return convertedChar;
    }
    
    public String convertToLatin(char c) throws FileNotFoundException, IOException
    {
        String s=Character.toString(c);
        String convertedChar="";
        File f = new File("C:/Users/User/Desktop/Python/Java/data.txt");
        Scanner in = new Scanner(f);

        ArrayList<String> inLines = new ArrayList<>();
        String read;
        while (in.hasNextLine()){
            read = in.nextLine();
            inLines.add(read);
        }
        for(int i=0; i<inLines.size(); i++){

            String selectedLine = inLines.get(i);
            String[] inWords = selectedLine.split(" ");                 
            String letter=inWords[1];

            if(letter.equals(s)){
                int result=i+1;
                System.out.println("I found it in line " + result);           
                convertedChar=inWords[0];  
            } 
            else{
                System.out.println("not equal, the char is " + letter + " and the s is " + s);
            }
        }
        return convertedChar;
    }

    public String polishing(String convertedText)
    {
        if(convertedText.contains("ð’–ð’–")){ //aa
            convertedText= convertedText.replace("ð’–ð’–", "ð’›");
        }
        if(convertedText.contains("ð’—ð’—")){//ee
            convertedText= convertedText.replace("ð’—ð’—", "ð’œ");
        }
        if(convertedText.contains("ð’™ð’™")){//oo
            convertedText= convertedText.replace("ð’™ð’™", "ð’");
        }
        if(convertedText.contains("ð’ð’”")){//kh
            convertedText= convertedText.replace("ð’ð’”", "ð’…");
        }
        if(convertedText.contains("ð’†ð’”")){//dh
            convertedText= convertedText.replace("ð’†ð’”", "ð’Š");
        }
        if(convertedText.contains("ð’ˆð’”")){//sh
            convertedText= convertedText.replace("ð’ˆð’”", "ð’‰");
        }

        return convertedText;
    }

}