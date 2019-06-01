package com.example.demo.service.staff;

import java.util.List;

import com.example.demo.model.Work;

public interface WorkService {

	List<Work> getWorkList(int staff_no );
	Work getWork(int work_no);
	void updateWork(Work work);
	void insertWork(Work work);
}
