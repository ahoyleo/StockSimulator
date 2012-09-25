package order;

public abstract class OrderBuilder {
	protected DefaultStockOrder order;

	public DefaultStockOrder getOrder() {
		return order;
	}
	
	public abstract void createNewOrder();
	
	
}
