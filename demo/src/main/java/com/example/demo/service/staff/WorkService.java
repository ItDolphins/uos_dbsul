package com.example.demo.service.staff;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.example.demo.model.Work;

public interface WorkService {

	List<Work> getWorkList(int staff_no );
	Work getWork(int staff_no , Timestamp work_start_time);
	void updateWork(Work work,Timestamp ex_work_start_time);
	void insertWork(Work work);
}
