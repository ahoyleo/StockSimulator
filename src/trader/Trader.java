package trader;

import order.Order;
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
	
	public abstract void buy(Order o);
	
	public abstract void sell(Order o);
}
