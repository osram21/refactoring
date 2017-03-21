package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

import refactoring.statement.HtmlStatement;
import refactoring.statement.Statement;
import refactoring.statement.TestStatement;

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

	public List<Rental> getRentals() {
		return rentals;
	}

	public String statement() {
		Statement stmt = new TestStatement();
		return stmt.value(this);
	}

	public String htmlstatement() {
		Statement stmt = new HtmlStatement();
		return stmt.value(this);
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;// 적립포인트
		for (Rental each : rentals) {
			frequentRenterPoints += each.getfrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public double getTotalCharge() {
		double result = 0.0;// 대여료
		for (Rental each : rentals) {
			result += each.getCharge();
		}
		return result;
	}
}