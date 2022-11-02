package com.example.coindesk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coindesk.model.CodeApi;
import com.example.coindesk.repository.CodeApiRepository;

@Service
public class CodeService {
	private final CodeApiRepository codeApiRepository;

	@Autowired
	public CodeService(final CodeApiRepository codeApiRepository) {
		this.codeApiRepository = codeApiRepository;
	}

	public CodeApi addNewAccount(CodeApi codeApi) {
		Date date = new Date();
		codeApi.setUp_time(date);
		codeApi.setCreate_time(date);
		return codeApiRepository.save(codeApi);
	}

	public CodeApi deleAccount(CodeApi codeApi) {
		codeApiRepository.delete(codeApi);
		return codeApi;
	}

	public CodeApi updateAccount(CodeApi codeApi) {
		if (codeApi != null && !codeApi.getCode().isEmpty()) {
			CodeApi updateCodeApi = codeApiRepository.queryCodeApiCode(codeApi.getCode());
			Date date = new Date();
			updateCodeApi.setUp_time(date);
			updateCodeApi.setCode_name(codeApi.getCode_name());
			return codeApiRepository.save(updateCodeApi);
		}
		Date date = new Date();
		codeApi.setUp_time(date);
		codeApi.setCreate_time(date);
		return codeApiRepository.save(codeApi);
	}

	public CodeApi queryAccount(String codeApi) {
		return codeApiRepository.queryCodeApiCode(codeApi);
	}

	public List<CodeApi> listAllAccounts() {
		return codeApiRepository.findAll();
	}

}
