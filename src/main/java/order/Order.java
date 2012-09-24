package order;

import stock.Stock;
import trader.Trader;

public abstract class Order {
	protected Trader trader;
	protected Stock stock;
	//limited order should be filled at the price
	//market order's price will be set after being filled
	protected double price;
	protected int quantity;
	protected int filledQuantity;
	protected OrderCondition condition;
	protected OrderTimeLimit limit;
	protected boolean isCancled;
	protected boolean isFilled;
	
	public Order() {
		
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isCanceled () {
		return isCancled;
	}
	
	public void cancel() {
		isCancled = true;
	}

	public abstract void fill();

}
