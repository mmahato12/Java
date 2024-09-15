import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Java program to implement a  City class 

// Defining a city class 
class City { 

	// Initializing the properties 
	// of the city class 
	private String name; 
	private double temperature; 

	// Parameterized constructor to 
	// initialize the city class 
	public City(String name, double temperature) 
	{ 
		this.name = name; 
		this.temperature = temperature; 
	} 

	// Getters to get the name and 
	// temperature 
	public String getName() 
	{ 
		return name; 
	} 

	public Double getTemperature() 
	{ 
		return temperature; 
	} 

	// Overriding the toString method 
	// to return the name and temperature 
	@Override
	public String toString() 
	{ 
		return name + " --> " + temperature; 
	} 
	
	
	
	// Java program to create a list 
	// of cities with name and 
	// temperature 

	// Function to create a list of 
	// cities with name and temperature 
	public static List<City> prepareTemperature() 
	{ 
		List<City> cities = new ArrayList<>(); 
		cities.add(new City("New Delhi", 33.5)); 
		cities.add(new City("Mexico", 14)); 
		cities.add(new City("New York", 13)); 
		cities.add(new City("Dubai", 43)); 
		cities.add(new City("London", 15)); 
		cities.add(new City("Alaska", 1)); 
		cities.add(new City("Kolkata", 30)); 
		cities.add(new City("Sydney", 11)); 
		cities.add(new City("Mexico", 14)); 
		cities.add(new City("Dubai", 43)); 
		return cities; 
	} 

} 



public class Problem
{
	public static void main(String[] args)
	{
		System.out.println(City.prepareTemperature()
					.stream()
					.filter(city -> city.getTemperature() > 15)
					.map(city -> city.getName())
					.collect(Collectors.toList())
					);
		
		System.out.println(City.prepareTemperature()
					.stream()
					.filter(city -> city.getTemperature() > 15)
					.map(city -> city.getName())
					.collect(Collectors.toCollection(ArrayList::new))
					);
		
		System.out.println(City.prepareTemperature()
					.stream()
					.filter(city -> city.getTemperature() > 15)
					.collect(Collectors.toMap(City::getName, 
											  City::getTemperature,
											  (key, identicalKey) -> key)));
		
		Map<String, List<City>> group1 = City.prepareTemperature()
					.stream()
					.filter(city -> city.getTemperature() > 15)
					.collect(Collectors.groupingBy(City::getName));

		System.out.println("\nCollectors.groupingBy : \n" + group1);
		
		Map<String, Integer> group2 = City.prepareTemperature()
					.stream()
					.collect(Collectors.groupingBy(
												City::getName,
												Collectors.collectingAndThen(Collectors.counting(),
																			c -> c.intValue())));
		System.out.println("\nCollectors.Counting : \n" + group2);
		
		
		String cityList1 = City.prepareTemperature()
					.stream()
					.filter(city -> city.getTemperature() > 10)
					.map(x -> x.getName())
					.collect(Collectors.joining(","));
		
		System.out.println("\nCities in String :\n" + cityList1);
		
		String cityList2 = City.prepareTemperature()
				.stream()
				.filter(city -> city.getTemperature() > 10)
				.map(x -> x.getName())
				.collect(Collectors.joining(",", "Prefix : ", "; Suffix"));
	
		System.out.println("\nCities in String :\n" + cityList2);
		
		
		Map<String, List<Double>> group3 = City.prepareTemperature()
				.stream()
				.collect(Collectors.groupingBy(
											City::getName,
											Collectors.mapping(
												City::getTemperature,
												Collectors.toList())));

		System.out.println(group3);
		
		Map <Boolean, List<City>> group4 = City.prepareTemperature()
						.stream()
						.collect(Collectors.partitioningBy(city -> city.getTemperature() > 15));
		System.out.println("\nPartition By : \n" + group4);
	}
}
