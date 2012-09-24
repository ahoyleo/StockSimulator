package order;

public class LimitOrderBuilder extends OrderBuilder {

	@Override
	public void createNewOrder() {
		order = new LimitOrder();
	}

}
