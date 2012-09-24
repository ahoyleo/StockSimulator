package exchange;

import java.util.Map;
import java.util.PriorityQueue;

import order.Order;
import stock.Ticker;

public class Exchange {
	protected String name;
//	protected Set <Stock> stocks;
	protected PriorityQueue <Order> bidQueue = new PriorityQueue <Order> ();
	protected PriorityQueue <Order> askQueue = new PriorityQueue <Order> ();
	protected PriorityQueue <Order> marketOrderQueue = new PriorityQueue <Order> ();
	
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
		Order highestBid = bidQueue.peek();
		Order lowestAsk = askQueue.peek();
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
