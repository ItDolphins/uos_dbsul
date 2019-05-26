package com.example.demo.service.staff;

import java.util.List;

import com.example.demo.model.Work;

public interface WorkService {

	List<Work> getWorkList(String staff_no );
	Work getWork(String work_no);
	void updateWork(Work work);
	void insertWork(Work work);
}
