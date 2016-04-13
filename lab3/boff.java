import java.io.*;
import java.util.Scanner;


public class boff{
	public static void main(String[] args){

		Scanner inputData = new Scanner(System.in);
		Integer	counter, index;

		while( inputData.hasNext() ){
			counter = 0;
			Integer boffNumber = Integer.parseInt( inputData.next() );
			Integer startNumber = Integer.parseInt( inputData.next() );
			Integer endNumber = Integer.parseInt( inputData.next() );
			String boffString = String.valueOf( boffNumber );


			for(Integer i = startNumber; i <= endNumber; i++ ){
				String converted = String.valueOf( i );
				if(converted.length() < boffString.length()){
					index = 1;
				}
				else{
					index = boffString.length();
				}

				Integer lastDigits = Integer.parseInt( converted.substring(converted.length()-index) );
				
				if(i%boffNumber == 0){
					counter++;
				}
				else if(lastDigits == boffNumber){
					counter++;
				}
			}
			System.out.println(counter);
		}
	}
}