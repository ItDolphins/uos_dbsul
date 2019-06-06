package com.example.demo.service.staff;

import com.example.demo.dto.WorkSum;
import com.example.demo.model.Work;
import com.example.demo.repository.staff.WorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.List;

@Transactional
@Service
public class WorkService {

	@Autowired
	WorkDao workDao;

	public List<Work> getWorkList(int staff_no){
		List<Work> workList = workDao.findWorkByStaff_no(staff_no);
		return workList;
	}

	public Work getWork(int staff_no , Timestamp work_start_time){

		Work work =  workDao.getWorkByStaff_noAndWork_start_time(staff_no, work_start_time);
		return work;
	}
	public void updateWork(Work work,Timestamp ex_work_start_time){
		workDao.updateWork(work,ex_work_start_time);
	}

	public void insertWork(Work work){
		workDao.insertWork(work);
	}

	public WorkSum getWorkSum(int staff_no , String yrmn){
		WorkSum workSum = workDao.getTotalWorkSumByStaff_noAndYrmn(staff_no,yrmn);
		return  workSum;
	}

}