package refactoring.price;

public abstract class Price {
   public abstract int getPriceCode();
   
   public abstract double getCharge(int daysRented);
   
   public int getFrequentRentalPoints(int aDaysRented) {
      return 1;
   }
}
