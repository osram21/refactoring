package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.ThreadPolicyOperations;

public class Customer {
	private String name;
	private List<Rental> rentals;
	
	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental aRental){
		this.rentals.add(aRental);
	}
	
	public String statement(){
		double totalAmount = 0;//대여료
		int frequentRenterPoints = 0;//적립포인트
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+"고객님의 대여기록\n");
		
		for(Rental each : rentals){
			
			
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >1){
				frequentRenterPoints++;
			}
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge()));
			
			totalAmount += each.getCharge();
			//for loop
		}
		sb.append(String.format("누적대여료: %s%n적립포인트 : %s%n", totalAmount, frequentRenterPoints));
		return sb.toString();
	}
	
	
}
