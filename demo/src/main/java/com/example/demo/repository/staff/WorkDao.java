package com.example.demo.repository.staff;

import java.util.List;

import com.example.demo.model.Work;


public interface WorkDao {

	List<Work> findWorkByStaff_no(String staff_no);
	Work getWorkByWork_no(String work_no);
	void updateWork(Work work);
	void insertWork(Work work);
}
