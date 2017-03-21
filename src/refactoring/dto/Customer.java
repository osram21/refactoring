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

	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String statement() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");

		for (Rental each : rentals) {
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge()));
		} // for loop

		sb.append(String.format("누적대여료: %s%n적립포인트 : %s%n", getTotalCharge(), getFrequentRenterPoints()));
		return sb.toString();
	}

	public String htmlstatement() {
		StringBuilder sb = new StringBuilder();
		sb.append("<h1><em>" + getName() + "고객님의 대여기록</em></h1><p>\n");

		for (Rental each : rentals) {
			sb.append(String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>%n", each.getMovie().getTitle(), each.getCharge()));
		} // for loop

		sb.append(
				String.format("<p>누적대여료: <em>%n<p>적립포인트 : <em>%s</em>%n", getTotalCharge(), getFrequentRenterPoints()));
		return sb.toString();
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;// 적립포인트
		for (Rental each : rentals) {
			frequentRenterPoints += each.getfrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private double getTotalCharge() {
		double result = 0.0;// 대여료
		for (Rental each : rentals) {
			result += each.getCharge();
		}
		return result;
	}
}