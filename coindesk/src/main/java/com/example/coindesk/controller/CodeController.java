package com.example.coindesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coindesk.model.CodeApi;
import com.example.coindesk.service.CodeService;

@RestController
public class CodeController {
	private final CodeService codeService;

	@Autowired
    public CodeController(final CodeService codeService)
    {
        this.codeService = codeService;
    }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CodeApi add(@RequestBody CodeApi codeApi) {
		return codeService.addNewAccount(codeApi);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CodeApi delete(@RequestBody CodeApi codeApi) {
		return codeService.deleAccount(codeApi);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CodeApi update(@RequestBody CodeApi codeApi) {
		return codeService.updateAccount(codeApi);
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public CodeApi query(@RequestBody CodeApi codeApi) {
		return codeService.queryAccount(codeApi.getCode());
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<CodeApi> all() {
		return codeService.listAllAccounts();
	}
}
