package stock;

import exchange.Exchange;

public class Stock {
	public Stock(Ticker ticker, Exchange exchange, double price, int shares, int time) {
		this.ticker = ticker;
		this.exchange = exchange;
		this.price = price;
		this.shares = shares;
		this.time = time;
	}
	
	protected Ticker ticker;
	protected Exchange exchange;
	protected double price;
	protected int shares;
	protected int time;
	
}
