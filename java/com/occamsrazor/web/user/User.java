package com.occamsrazor.web.user;

import lombok.Data;

@Data
public class User {
	private String name, userid, password, ssn, addr;
}