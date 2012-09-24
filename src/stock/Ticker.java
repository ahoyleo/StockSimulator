package stock;

import exchange.Exchange;

public enum Ticker {
	STOCK0 ("stock0", Exchange.getExchange("exchange0"));
	
	private final String ticker;
	private final Exchange exchange;
	Ticker (String ticker, Exchange exchange) {
		this.ticker = ticker;
		this.exchange = exchange;
	}
	public String getTicker() {
		return ticker;
	}
	public Exchange getExchange() {
		return exchange;
	}
}
