package refactoring.dto;

public class Movie {
	public static final int ReGULAR = 1;
	public static final int NEW_RELEASE = 2;
	public static final int CHLDRENS = 3;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		double result = 0;
		// 비디오물당 대여료 1. 일반물 (2일) 2000원, 일일초과 1500원 , 적립1
		// 2. 아동물 (3일) 1500원, 일일초과 1500원, 적립1
		// 3. 최신물 (1일) 3000원, 일일초과 3000원, 적립1

		switch (priceCode) {
		case Movie.ReGULAR:
			result = 2000;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1500;
			}
			break;
		case Movie.NEW_RELEASE:
			result = (daysRented * 3000);
			break;
		case Movie.CHLDRENS:
			result = 1500;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1500;
			}
			break;
		}
		return result;
	}

	public int getfrequentRenterPoints(int aDaysRented) {
		if (priceCode == Movie.NEW_RELEASE && aDaysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
