package refactoring.dto;

import refactoring.price.ChildrenPrice;
import refactoring.price.NeWReleasePrice;
import refactoring.price.Price;
import refactoring.price.RegularPrice;

public class Movie {
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;
	public static final int CHILDRENS = 3;

	private String title;
	private Price price;

	public Movie(String title, int priceCode) throws IllegalAccessException {
		this.title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) throws IllegalAccessException {
		switch (priceCode) {
		case Movie.CHILDRENS:
			price = new ChildrenPrice();
			break;
		case Movie.REGULAR:
			price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			price = new NeWReleasePrice();
			break;
		default:
			throw new IllegalAccessException("가격 코드가 잘못 입력됨");
		}
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public int getFrequentRentalPoints(int aDaysRented) {
		return price.getFrequentRentalPoints(aDaysRented);
	}

}
