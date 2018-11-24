package com.engi.webgabinet.repositories;

import java.util.List;

import com.engi.webgabinet.domain.Rx;

public interface RxDAO {
	List<Rx> findByDoctorId(int doctorId);
	
	List<Rx> findByUserId(int userId);
	
	Rx save(Rx rx);
}
