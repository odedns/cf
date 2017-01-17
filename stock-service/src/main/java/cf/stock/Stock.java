package cf.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String symbol;
	private String name;
	private double lastTradeValue;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLastTradeValue() {
		return lastTradeValue;
	}
	public void setLastTradeValue(double lastTradeValue) {
		this.lastTradeValue = lastTradeValue;
	}
	
}
