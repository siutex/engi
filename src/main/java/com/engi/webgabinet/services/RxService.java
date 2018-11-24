package com.engi.webgabinet.services;

import java.util.List;

import com.engi.webgabinet.domain.Rx;

public interface RxService {

	void save(Rx rx);
	
	List<Rx> findByDoctorId(int doctorId);
	
	List<Rx> findByPatientId(int userId);
}
