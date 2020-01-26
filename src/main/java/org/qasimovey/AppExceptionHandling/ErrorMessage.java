package org.qasimovey.AppExceptionHandling;

import java.util.Date;

public class ErrorMessage {
	private Date timestamp;
	private String description;
	
	public ErrorMessage(Date timestamp, String description) {
		this.timestamp = timestamp;
		this.description = description;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
