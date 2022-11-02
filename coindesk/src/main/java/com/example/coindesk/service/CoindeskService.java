package com.example.coindesk.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coindesk.instance.BpiInstance;
import com.example.coindesk.model.CodeApi;
import com.example.coindesk.model.Currency;
import com.example.coindesk.repository.CodeApiRepository;
import com.example.coindesk.res.CurrencyRes;
import com.example.coindesk.util.DateUtils;
import com.google.gson.Gson;

@Service
public class CoindeskService {
	private final CodeApiRepository codeApiRepository;
	@Autowired
	public CoindeskService(CodeApiRepository codeApiRepository) {
		this.codeApiRepository = codeApiRepository;
	}

	public String getCoindesk() {
		String message = "";
		try {
			InputStream inputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader bufferedReader = null;
			URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
			inputStream = url.openStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((message = bufferedReader.readLine()) != null) {
				return message.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	public String reCoindeskTime() {
		String message = "";
		try {
			InputStream inputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader bufferedReader = null;
			CurrencyRes currencyRes = new CurrencyRes();
			LinkedHashMap<String, BpiInstance> currencyResMap = new LinkedHashMap<String, BpiInstance>();
			URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
			inputStream = url.openStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((message = bufferedReader.readLine()) != null) {
				Currency currency = new Gson().fromJson(message, Currency.class);
				currencyRes.setUpdated(DateUtils.getUpdated());
				LinkedHashMap<String, Currency.Bpi> currencyMap = new LinkedHashMap<String, Currency.Bpi>();
				currencyMap = currency.getBpi();
				for (Map.Entry<String, Currency.Bpi> entry : currencyMap.entrySet()) {
					Currency.Bpi bpi = entry.getValue();
					BpiInstance bpiRes = new BpiInstance();
					CodeApi codeApi = codeApiRepository.queryCodeApiCode(bpi.getCode());
					bpiRes.setCode(bpi.getCode());
					bpiRes.setCode_zh(codeApi.getCode_name());
					bpiRes.setRate(bpi.getRate());
					bpiRes.setRate_float(bpi.getRate_float());
					currencyResMap.put(entry.getKey(), bpiRes);
				}
				currencyRes.setBpi(currencyResMap);
				String resJson = new Gson().toJson(currencyRes);
				return resJson;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

}
