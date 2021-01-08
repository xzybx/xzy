package com.xzy.pojo;

public class Userone {
	private String account;
	private String password;

	public Userone() {
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userone(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userone [account=" + account + ", password=" + password + "]";
	}

}
