package com.example.demo.service.staff;

import com.example.demo.model.Work;
import com.example.demo.repository.staff.WorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Work getWork(int work_no){

		Work work =  workDao.getWorkByWork_no(work_no);
		return work;
	}
	@Override
	public void updateWork(Work work){
		workDao.updateWork(work);
	}

	@Override
	public void insertWork(Work work){
		workDao.insertWork(work);
	}


}
