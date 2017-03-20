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
	
	
}
