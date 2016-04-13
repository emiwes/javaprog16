import java.io.*;
import java.util.Scanner;

public class decompression {
    public static String startParam = "(";
    public static String endParam = ")";
    public static String compressedText; // global variable for the string. 

    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);

        while(inputData.hasNext()){
            compressedText = inputData.next();
            System.out.println( decompress() );
        }
    }

    public static String decompress() {
        String returnString = "";

        if( compressedText.length() == 0 ){
            return "";
        }

        else if( Character.isLetter(compressedText.charAt(0)) ){ // IF LETTER
             returnString = compressedText.substring(0,1);
        }

        else if( Character.isDigit(compressedText.charAt(0)) ){ // IF NUMBER
            String counter = compressedText.substring(0,1);

            if( Character.isDigit(compressedText.charAt(1)) ){ // IF SECOND NUMBER
                counter += compressedText.substring(1,2);
            } 

            if( String.valueOf( compressedText.charAt(counter.length()) ).equals(startParam) ){ // IF '('
                
                if( Character.isLetter(compressedText.charAt(counter.length()+1)) ){ // IF '(a'
                    compressedText = compressedText.substring(counter.length()); // cutting the number from string
                    returnString += decompress();

                    returnString = getMultiple(returnString, Integer.parseInt(counter)); // multiply the content of the parenthesis
                    
                    if(compressedText.length() > 0){
                        compressedText = compressedText.substring(1);
                        returnString += decompress();
                    }
                    return returnString;
                }
                else{ // IF '(2'
                    compressedText = compressedText.substring(1); // cutting the parenthesis from string
                    returnString += decompress();
                    returnString = getMultiple(returnString, Integer.parseInt(counter)); // multiply the content of the parenthesis
                }
            }
            else{ // IF 'LETTER'
                returnString = getMultiple(compressedText.substring(counter.length(),counter.length()+1), Integer.parseInt(counter));
                compressedText = compressedText.substring(counter.length());
            }
        }
        else if( String.valueOf( compressedText.charAt(0) ).equals(endParam) ){ // IF ')'
            return "";
        }

        compressedText = compressedText.substring(1);
        return returnString + decompress();
    }

    // recursive function for multiplying a string
    public static String getMultiple(String str, int length) {
        if (length == 0) return "";

        return ""+str+getMultiple(str,length-1);
    }
}