package controller;

import java.util.List;

import stock.Stock;
import trader.Trader;
import exchange.Exchange;

public class SimulationController {
	Exchange exchange;
	Stock stock;
	List <Trader> traders;
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			for (Trader trader : traders) {
				trader.trade();
			}
		}
	}
	
	public static void main(String [] args) {
		SimulationController con = new SimulationController();
		con.run();
	}
}
