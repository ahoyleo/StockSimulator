package trader;

import order.DefaultStockOrder;
import order.OrderBuilder;
import stock.Stock;

public abstract class Trader {
	
	protected double fund;
	
	//only single stock portfolio for now
	//ramp up later
	protected Stock portfolio;
	
	protected Personality personality;
	
	protected OrderBuilder orderBuilder;
	
	public abstract void trade();
	
	public abstract void poll(Stock s);
	
	public abstract void buy(DefaultStockOrder o);
	
	public abstract void sell(DefaultStockOrder o);
}
