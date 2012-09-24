package order;

public class MarketOrderBuilder extends OrderBuilder {

	@Override
	public void createNewOrder() {
		order = new MarketOrder();
	}

}
