package refactoring.statement;

import refactoring.dto.Customer;
import refactoring.dto.Rental;

public class HtmlStatement extends Statement {
	
	@Override
	protected String footerString(Customer customer) {
		return String.format("<p>누적대여료: <em>%n<p>적립포인트 : <em>%s</em>%n", customer.getTotalCharge(), customer.getFrequentRenterPoints());		
	}
	@Override
	protected String eachRentalString(Rental each) {
		return String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>%n", each.getMovie().getTitle(), each.getCharge());		
	}
	@Override
	protected String headerString(String cutomerName) {
		return "<h1><em>" + cutomerName + "고객님의 대여기록</em></h1><p>\n";
	}
}
