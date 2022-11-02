package com.example.coindesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coindesk.service.CoindeskService;

@RestController
public class CoindeskController {
	private final CoindeskService coindeskService;

	@Autowired
	public CoindeskController(final CoindeskService coindeskService) {
		this.coindeskService = coindeskService;
	}

	@RequestMapping(value = "/getCoindesk", method = RequestMethod.GET)
	public String getCoindesk() {
		return coindeskService.getCoindesk();
	}

	@RequestMapping(value = "/reCoindeskTime", method = RequestMethod.POST)
	public String reCoindeskTime() {
		return coindeskService.reCoindeskTime();
	}

}
