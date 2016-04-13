import java.io.*;
import java.util.Scanner;


public class distance {
	public static void main(String[] args){
		Scanner inputData = new Scanner(System.in);
		Integer rows;
		Integer cols;
		String rowData = "";
		Integer rowValue;
		Integer colValue;
		Integer rowScalar;
		Integer colScalar;

		while( inputData.hasNext() ) {
			rows = Integer.parseInt(inputData.next());
			cols = Integer.parseInt(inputData.next());

			Integer midRow = (int) Math.ceil( (float)rows/2 ); // maximum distance to the edge for the rows
			Integer midCol = (int) Math.ceil( (float)cols/2 ); // maximum distance to the edge for the columns
			
			// Check if amount of rows are even, set a scalar to +1 to increase middlepoint.
			if(rows%2 == 0){
				rowScalar = 1;
			}
			else{
				rowScalar = 0;
			}

			// Check if amount of columns are even, set a scalar to +1 to increase middlepoint.
			if(cols%2 ==0){
				colScalar = 1;
			}
			else{
				colScalar = 0;
			}

			for( Integer row = 1; row <= rows; row++ ){

				if( row >= (midRow+rowScalar) ){
					// rowValue = (M/2) - ( row - ((M/2) + rowscalar) );
					rowValue = midRow-(row-(midRow+rowScalar));
				}
				else{
					rowValue = row;
				}
				
				for( Integer column = 1; column <= cols; column++ ){
					if( rowValue == 1 || rowValue == rows ){
						rowData += "1";
					}
					else{					
						
						if( column >= (midCol+colScalar) ){
							// colvalue = (N/2) - ( column - ((N/2) + colScalar) 
							colValue = midCol-(column-(midCol+colScalar));
						}
						else{
							colValue = column;
						}

						// if column value is greater the row number, set value to row number.
						if(colValue > rowValue){
							colValue = rowValue;
						}

						// if column value is greater than 9, change it to a '.'.
						if(colValue > 9){
							rowData += ".";
						}
						else{
							rowData += Integer.toString(colValue);
						}
					}

				}
				System.out.println(rowData);
				rowData = "";
			}
		}
	}
}