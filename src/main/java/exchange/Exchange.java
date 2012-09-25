package exchange;

import java.util.Map;
import java.util.PriorityQueue;

import order.DefaultStockOrder;
import stock.Ticker;

public class Exchange {
	protected String name;
//	protected Set <Stock> stocks;
	protected PriorityQueue <DefaultStockOrder> bidQueue = new PriorityQueue <DefaultStockOrder> ();
	protected PriorityQueue <DefaultStockOrder> askQueue = new PriorityQueue <DefaultStockOrder> ();
	protected PriorityQueue <DefaultStockOrder> marketOrderQueue = new PriorityQueue <DefaultStockOrder> ();
	
	Exchange(String name) {
		this.name = name;
	}
	
	static protected Map <String, Exchange> map; 
	public static Exchange getExchange(String name) {
		if (map.containsKey(name))
			return map.get(name);
		else {
			Exchange exchange = new Exchange(name);
			map.put(name, exchange);
			return exchange;
		}
	}
	
	public Quote getQuote(Ticker ticker) {
		Quote quote = new Quote();
		return quote;
	}
	
	protected void executeOrdersAtomic() {
		DefaultStockOrder highestBid = bidQueue.peek();
		DefaultStockOrder lowestAsk = askQueue.peek();
		if (highestBid.getPrice() >= lowestAsk.getPrice()) {
			int bidQuantity = highestBid.getQuantity();
			int askQuantity = lowestAsk.getQuantity();
			if (bidQuantity < askQuantity) {
				highestBid.fill(); 
				bidQueue.remove();
			}
			else {
				lowestAsk.fill();
				askQueue.remove();
			}
			executeOrdersAtomic();
		}
	}
}
