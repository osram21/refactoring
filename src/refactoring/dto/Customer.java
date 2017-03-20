package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

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
			double thisAmount = 0;
			// 비디오물당 대여료 1. 일반물 (2일) 2000원, 일일초과 1500원 , 적립1
						//2. 아동물 (3일) 1500원, 일일초과 1500원, 적립1
						//3. 최신물 (1일) 3000원, 일일초과 3000원, 적립1
			Movie movie = each.getMovie();
			
			int pirceCode = movie.getPriceCode();
			int daysRented = each.getDaysRented(); //해당 비디오물의 대여기간
			switch(pirceCode){
			case Movie.ReGULAR:
				thisAmount = 2000;
				if (daysRented > 2) {
					thisAmount += (daysRented - 2) * 1500;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount = (daysRented * 3000);
				break;
			case Movie.CHLDRENS:
				thisAmount = 1500;
				if (daysRented > 3) {
					thisAmount += (daysRented - 3) * 1500;
				}
				break;
			}
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >1){
				frequentRenterPoints++;
			}
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), thisAmount));
			
			totalAmount += thisAmount;
			//for loop
		}
		sb.append(String.format("누적대여료: %s%n적립포인트 : %s%n", totalAmount, frequentRenterPoints));
		return sb.toString();
	}
}
