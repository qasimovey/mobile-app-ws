package org.qasimovey.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	private long prev_vall=0;
	public long generateID() {
		return prev_vall++;
	}
}
