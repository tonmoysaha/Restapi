package com.spring.restcontroller;

public class StudentErrorResponse {
	private int status;
	private String massage;
	private long timestam;

	public StudentErrorResponse() {

	}

	public StudentErrorResponse(int status, String massage, long timestam) {
		this.status = status;
		this.massage = massage;
		this.timestam = timestam;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public long getTimestam() {
		return timestam;
	}

	public void setTimestam(long timestam) {
		this.timestam = timestam;
	}

}
