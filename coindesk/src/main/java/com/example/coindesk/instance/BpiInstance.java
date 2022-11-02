package com.example.coindesk.instance;

public class BpiInstance {
	private String code;
	private String code_zh;
	private String rate;
	private String rate_float;

	public String getCode_zh() {
		return code_zh;
	}

	public void setCode_zh(String code_zh) {
		this.code_zh = code_zh;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRate_float() {
		return rate_float;
	}

	public void setRate_float(String rate_float) {
		this.rate_float = rate_float;
	}
}
