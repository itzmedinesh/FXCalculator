package io.fx.calculator.input;

public class Input {
	private String fromCurrency;
	private String toCurrency;
	private Double fromCurrencyAmount;

	public Input(String fromCurrency, String toCurrency, Double fromCurrencyAmount) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.fromCurrencyAmount = fromCurrencyAmount;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getFromCurrencyAmount() {
		return fromCurrencyAmount;
	}

	public void setFromCurrencyAmount(Double fromCurrencyAmount) {
		this.fromCurrencyAmount = fromCurrencyAmount;
	}

}
