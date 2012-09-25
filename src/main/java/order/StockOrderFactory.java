package order;

import java.util.HashMap;
import java.util.Map;

public class StockOrderFactory
{
  protected Map <StockOrderSpec, DefaultStockOrder> orders = new HashMap <StockOrderSpec, DefaultStockOrder> ();
  
  public DefaultStockOrder getDefaultStockOrder(StockOrderSpec spec)
  {
    DefaultStockOrder order = orders.get(spec);
    if (order == null)
    {
      order = new DefaultStockOrder(spec);
      orders.put(spec, order);
    }
    return order;
  }
  
  
}
