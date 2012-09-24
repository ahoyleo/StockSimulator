package order;

public abstract class OrderBuilder {
	protected Order order;

	public Order getOrder() {
		return order;
	}
	
	public abstract void createNewOrder();
	
	
}
