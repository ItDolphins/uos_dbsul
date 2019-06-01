package com.example.demo.repository.staff;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.example.demo.model.Work;


public interface WorkDao {

	List<Work> findWorkByStaff_no(int staff_no);
	Work getWorkByStaff_noAndWork_start_time(int staff_no, Timestamp work_start_time);
	void updateWork(Work work, Timestamp ex_work_start_time);
	void insertWork(Work work);
}
