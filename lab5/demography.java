import java.io.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class demography{
	public static void main(String[] args){

		Scanner inputData = new Scanner(System.in);
		
		while( inputData.hasNext() ){
			// creating array to store country objects.
			ArrayList<Country> countries = new ArrayList<Country>();

			// getting amount of countries
			Integer countryAmount = inputData.nextInt();

			for( Integer c = 0; c < countryAmount; c++ ){
				// instantiating country with name and population and adds it to the array.
				Country country = new Country(inputData.next(), inputData.nextInt());
				countries.add(country);
			}

			// getting amount if population updates
			Integer populationUpdates = inputData.nextInt();

			for( Integer p = 0; p < populationUpdates; p++ ){
				// getting name and change of update
				String countryName = inputData.next();
				Integer countryPop = inputData.nextInt();

				for(Integer j = 0; j < countryAmount; j++){
					// if name of update equals country name, update population and break this loop, continuing to the next update.
					if( countryName.equals(countries.get(j).name) ){
						countries.get(j).updatePopulation(countryPop);
						break;
					}
				}
			}

			// sort the array with overridden compareTo method in helper class.
			Collections.sort(countries);

			for( Integer i = countries.size()-1; i >= 0; i--  ){
				// print the updates in reverse order, highest population first.
				System.out.println(countries.get(i).getName() + " " + countries.get(i).getPop());
			}
		}
	}

	public static class Country implements Comparable<Country> {
		private String name;
		private Integer population;

		public Country (String _name, Integer _population){
			name = _name;
			population = _population;
		}

		public String getName(){
			return this.name;
		}

		public Integer getPop(){
			return this.population;
		}

		public void updatePopulation(Integer _newPop){
			this.population += _newPop;
		}

		@Override
		public int compareTo(Country other) {
			if ( this.population == other.getPop() ){						//this population equals other
				if( this.name.compareTo(other.getName()) == -1 ){		//if country < other
					return 1;
				}
				else {														//if country > other
					return -1;
				}
			}
			else if( this.population > other.getPop() ) { 					// this populaton greater than other
				return 1;
			}
			else { 															//this population less than other
				return -1;
			}
		}
	}
}