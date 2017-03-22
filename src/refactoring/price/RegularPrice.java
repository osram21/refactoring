package refactoring.price;

import refactoring.dto.Movie;

public class RegularPrice extends Price{

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		double result = 0;
		result = 2000;
		if(daysRented>2){
			result += (daysRented -2)*1500;
		}
		return result;
	}

}
