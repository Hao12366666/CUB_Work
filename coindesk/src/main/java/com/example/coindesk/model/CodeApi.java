package com.example.coindesk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "current_price")
public class CodeApi {

	@Id
	@Column(name = "code", nullable = false, unique = true,length = 3)
	private String code;

	@Column(name = "code_name", nullable = false, unique = true ,length = 64)
	private String code_name;

	@Column(name = "create_time", nullable = false)
	private Date create_time;

	@Column(name = "up_time", nullable = false)
	private Date up_time;

}
