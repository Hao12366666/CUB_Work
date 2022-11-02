package com.example.coindesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.coindesk.model.CodeApi;

@Repository
public interface CodeApiRepository extends JpaRepository<CodeApi, String> {
	
	@Query("from CodeApi where code = ?1")
	CodeApi queryCodeApiCode(String code);
	
	@Modifying
	@Query("update CodeApi set code_name =?1 where code =?2")
	int updateUser(String code_name,String code);

}
