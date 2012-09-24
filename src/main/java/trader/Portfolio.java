package trader;

import java.util.HashMap;
import java.util.Map;

import stock.Ticker;

public class Portfolio {
	Map <Ticker, PositionInfo> map = new HashMap <Ticker, PositionInfo> ();

	protected double getMarketValue(Ticker ticker) {
		if (!map.containsKey(ticker))
			throw new IllegalArgumentException();
		else {
			double marketPrice = ticker.getExchange().getQuote(ticker).getSharePrice();
			int quantity = map.get(ticker).getQuantity();
			return marketPrice * quantity;
		}
	}
	
	protected double getTotalMarketValue() {
		double sumVal = 0.;
		for (Ticker ticker : map.keySet())
			sumVal += getMarketValue(ticker);
		return sumVal;
	}
	
	protected boolean hasPosition(Ticker ticker) {
		return map.containsKey(ticker);
	}

	protected void addPosition(Ticker ticker, double purchasePrice, int quantity) {
		if (hasPosition(ticker)) {
			double prevPrice = map.get(ticker).getPurchasePrice();
			int prevQuantity = map.get(ticker).getQuantity();
			double newPurchasePrice = weightedSum(purchasePrice, quantity, prevPrice, prevQuantity);
			int newQuantity = quantity + prevQuantity;
			map.put(ticker, (new PositionInfo(newPurchasePrice, newQuantity)));
		}
		else {
			map.put(ticker, new PositionInfo(purchasePrice, quantity));
		}
	}
	
	protected void removePosition(Ticker ticker) {
		if (map.containsKey(ticker))
			map.remove(ticker);
	}
	
	public static double weightedSum(double... args) {
		double res = 0.;
		double sumDenominator = 0;
		if (args.length % 2 != 0)
			throw new IllegalArgumentException();
		else {
			for (int i = 0; i < args.length; i++) {
				res += args[i] * args[i+1];
				sumDenominator += args[i+1];
				i++;
			}
			res /= sumDenominator;
		}
		return res;
	}
	
	class PositionInfo {
		protected double purchasePrice;
		protected int quantity;

		public double getPurchasePrice() {
			return purchasePrice;
		}

		public void setPurchasePrice(double purchasePrice) {
			this.purchasePrice = purchasePrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public PositionInfo(double purchasePrice, int quantity) {
			this.purchasePrice = purchasePrice;
			this.quantity = quantity;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			long temp;
			temp = Double.doubleToLongBits(purchasePrice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + quantity;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PositionInfo other = (PositionInfo) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Double.doubleToLongBits(purchasePrice) != Double
					.doubleToLongBits(other.purchasePrice))
				return false;
			if (quantity != other.quantity)
				return false;
			return true;
		}
		private Portfolio getOuterType() {
			return Portfolio.this;
		}
	}
}
