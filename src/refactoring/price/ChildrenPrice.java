package refactoring.price;

import refactoring.dto.Movie;

public class ChildrenPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public double getCharge(int daysRented) {
		double result = 1500;
		if(daysRented>3){
			result +=(daysRented-3)*1500;
		}
		return result;
	}

}
