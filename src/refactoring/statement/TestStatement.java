package refactoring.statement;

import refactoring.dto.Customer;
import refactoring.dto.Rental;

public class TestStatement extends Statement {
	
	@Override
	protected String footerString(Customer customer) {
		return String.format("누적대여료: %s%n적립포인트 : %s%n", customer.getTotalCharge(), customer.getFrequentRenterPoints());		
	}
	@Override
	protected String eachRentalString(Rental each) {
		return String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge());		
	}
	@Override
	protected String headerString(String cutomerName) {
		return cutomerName + "고객님의 대여기록\n";
	}
}
