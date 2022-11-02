package com.example.coindesk.res;

import java.util.LinkedHashMap;

import com.example.coindesk.instance.BpiInstance;

public class CurrencyRes {
	private String updated;
	private LinkedHashMap<String, BpiInstance> bpi;

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public LinkedHashMap<String, BpiInstance> getBpi() {
		return bpi;
	}

	public void setBpi(LinkedHashMap<String, BpiInstance> bpi) {
		this.bpi = bpi;
	}


}
