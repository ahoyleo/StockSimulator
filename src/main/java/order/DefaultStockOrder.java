package order;

public class DefaultStockOrder implements StockOrder
{

  protected StockOrderContext context;

  protected StockOrderSpec    spec;

  public DefaultStockOrder(StockOrderSpec spec)
  {
    this.spec = spec;
  }

  public StockOrderSpec getSpec()
  {
    return spec;
  }

  public void setSpec(StockOrderSpec spec)
  {
    this.spec = spec;
  }

  @Override
  public void fill(double price, int quantity, int timestamp)
  {
    context.addFilling(price, quantity, timestamp);
  }

  @Override
  public void cancel()
  {
    context.setCanceled(true);
  }

  @Override
  public StockOrderContext getStockOrderContext()
  {
    return context;
  }
  
  public void setStockOrderContext(StockOrderContext context)
  {
    this.context = context;
  }
}
