package order;

public interface StockOrder
{
  /**
   * Fill an order. The order can be partially filled. 
   * Implementations should keep track of all individual fillings.
   * @param price The price to fill the order
   * @param quantity The quantity to be filled at the price
   * @param timestamp The time the order is filled
   */
  public void fill(double price, int quantity, int timestamp);
  
  /**
   * Cancel an order.
   * The order can be partially filled before canceled.
   */
  public void cancel();
  
  /**
   * Get the current status of the order
   * @return
   */
  public StockOrderContext getStockOrderContext();
  
//public void fillPartial(int Quantity);

}
