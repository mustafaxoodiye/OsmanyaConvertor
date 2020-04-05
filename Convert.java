
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
        File f = new File("C:/Users/User/Desktop/Java/OsmanyaConvertor/data.txt");
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
                System.out.println("I found the letter " + letter + " in line " + result);           
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
        File f = new File("C:/Users/User/Desktop/Java/OsmanyaConvertor/data.txt");
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
        if(convertedText.contains("𐒖𐒖")){ //aa
            convertedText= convertedText.replace("𐒖𐒖", "𐒛");
        }
        if(convertedText.contains("𐒗𐒗")){//ee
            convertedText= convertedText.replace("𐒗𐒗", "𐒜");
        }
        if(convertedText.contains("𐒙𐒙")){//oo
            convertedText= convertedText.replace("𐒙𐒙", "𐒝");
        }
        if(convertedText.contains("𐒏𐒔")){//kh
            convertedText= convertedText.replace("𐒏𐒔", "𐒅");
        }
        if(convertedText.contains("𐒆𐒔")){//dh
            convertedText= convertedText.replace("𐒆𐒔", "𐒊");
        }
        if(convertedText.contains("𐒈𐒔")){//sh
            convertedText= convertedText.replace("𐒈𐒔", "𐒉");
        }

        return convertedText;
    }

}