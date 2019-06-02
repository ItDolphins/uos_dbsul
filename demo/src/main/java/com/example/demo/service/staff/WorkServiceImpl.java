package com.example.demo.service.staff;

import com.example.demo.model.Work;
import com.example.demo.repository.staff.WorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkDao  workDao;

	@Override
	public List<Work> getWorkList(int staff_no){
		List<Work> workList = workDao.findWorkByStaff_no(staff_no);
		return workList;
	}

	@Override
	public Work getWork(int staff_no , Timestamp work_start_time){

		Work work =  workDao.getWorkByStaff_noAndWork_start_time(staff_no, work_start_time);
		return work;
	}
	@Override
	public void updateWork(Work work,Timestamp ex_work_start_time){
		workDao.updateWork(work,ex_work_start_time);
	}

	@Override
	public void insertWork(Work work){
		workDao.insertWork(work);
	}


}