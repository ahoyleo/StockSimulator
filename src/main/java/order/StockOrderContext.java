package order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import stock.Stock;
import trader.Trader;

public class StockOrderContext
{

  /**
   * The trader who issues the order
   */
  protected Trader               trader;

  /**
   * The stock the order is targeted to trade
   */
  protected Stock                stock;

  /**
   * Limited orders should be filled at the specified price; Market orders' price will be
   * set after being filled.
   */
  protected double               price;

  /**
   * The intended quantity of the stock to be traded at {@link price}.
   */
  protected int                  quantity;

  /**
   * Unfilled quantity of the order.
   */
  protected int                  unfilledQuantity;

  /**
   * A map of price --> quantity to keep track of all individual fillings of the order.
   * The map is instantialized as a LinkedHashMap to maintain insertion order in order to
   * match the time stamp in ActiomTimestamps.
   */
  protected Map<Double, Integer> filledParts       = new LinkedHashMap<Double, Integer>();

  /**
   * First element is the order creation time, followed by each filling time, and ended
   * with the cancel time if there is one.
   */
  protected List<Integer>        actionTimestamps  = new ArrayList<Integer>();

  protected boolean              isPartiallyFilled = false;
  protected boolean              isCanceled        = false;
  protected boolean              isFilled          = false;

  public StockOrderContext(Trader trader,
                           Stock stock,
                           double price,
                           int quantity,
                           int timestamp)
  {
    this.trader = trader;
    this.stock = stock;
    this.price = price;
    this.quantity = quantity;
    this.unfilledQuantity = quantity;
    actionTimestamps.add(timestamp);
  }

  public void addFilling(double price, int quantity, int timestamp)
  {
    if (quantity > this.unfilledQuantity)
      throw new IllegalArgumentException();

    filledParts.put(price, quantity);
    actionTimestamps.add(timestamp);
    updateUnfilledQuantity();
    isPartiallyFilled = true;
  }

  public Map<Double, Integer> getFilledParts()
  {
    return filledParts;
  }

  public List<Integer> getActionTimestamps()
  {
    return actionTimestamps;
  }

  public int getUnfilledQuantity()
  {
    return unfilledQuantity;
  }

  public Trader getTrader()
  {
    return trader;
  }

  public void setTrader(Trader trader)
  {
    this.trader = trader;
  }

  public Stock getStock()
  {
    return stock;
  }

  public void setStock(Stock stock)
  {
    this.stock = stock;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public Map<Double, Integer> getFilledPrice()
  {
    return filledParts;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public boolean isPartiallyFilled()
  {
    return isPartiallyFilled;
  }

  public void setPartiallyFilled(boolean isPartiallyFilled)
  {
    this.isPartiallyFilled = isPartiallyFilled;
  }

  public boolean isCanceled()
  {
    return isCanceled;
  }

  public void setCanceled(boolean isCanceled)
  {
    this.isCanceled = isCanceled;
  }

  public boolean isFilled()
  {
    return isFilled;
  }

  public void setFilled(boolean isFilled)
  {
    this.isFilled = isFilled;
  }

  private void updateUnfilledQuantity()
  {
    if (filledParts == null)
      return;
    else
    {
      int totalFilledQuantity = 0;
      for (int filledQuantity : filledParts.values())
        totalFilledQuantity += filledQuantity;
      unfilledQuantity = quantity - totalFilledQuantity;
    }
  }
}
