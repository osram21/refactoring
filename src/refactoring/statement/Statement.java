package refactoring.statement;

import java.util.List;

import refactoring.dto.Customer;
import refactoring.dto.Rental;

public abstract class Statement {
	public String value(Customer customer){
		StringBuilder sb = new StringBuilder();
		//헤더 출력
		sb.append(headerString(customer.getName()));
		
		List<Rental> rentals = customer.getRentals();
		
		for (Rental each : rentals) {
			//본문 출력
			sb.append(eachRentalString(each));
		} // for loop
		//푸터 출력
		sb.append(footerString(customer));
		return sb.toString();
	}
	
	protected abstract String footerString(Customer customer); 

	protected abstract String eachRentalString(Rental each); 

	protected abstract String headerString(String cutomerName); 
}
