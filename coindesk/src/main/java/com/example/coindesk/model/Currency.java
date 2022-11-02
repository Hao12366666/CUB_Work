package com.example.coindesk.model;

import java.util.LinkedHashMap;

public class Currency {
	private Time time;
	private String disclaimer;
	private String chartName;
	private LinkedHashMap<String, Bpi> bpi;

	public LinkedHashMap<String, Bpi> getBpi() {
		return bpi;
	}

	public void setBpi(LinkedHashMap<String, Bpi> bpi) {
		this.bpi = bpi;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public class Time {
		private String updated;
		private String updatedISO;
		private String updateduk;

		public String getUpdated() {
			return updated;
		}

		public void setUpdated(String updated) {
			this.updated = updated;
		}

		public String getUpdatedISO() {
			return updatedISO;
		}

		public void setUpdatedISO(String updatedISO) {
			this.updatedISO = updatedISO;
		}

		public String getUpdateduk() {
			return updateduk;
		}

		public void setUpdateduk(String updateduk) {
			this.updateduk = updateduk;
		}

	}

	public class Bpi {
		private String code;
		private String symbol;
		private String rate;
		private String description;
		private String rate_float;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getRate_float() {
			return rate_float;
		}

		public void setRate_float(String rate_float) {
			this.rate_float = rate_float;
		}

	}

}
