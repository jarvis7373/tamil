package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Tamilselvan T Date : 28-12-18
 *
 */

@Entity
@Table(name="USER_DETAILS")
public class Login {

	@Column(name="USER_NAME")
	@NotNull
	private String userName;
	
	@Column(name="PASSWORD")
	@NotNull
	private String password;

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
