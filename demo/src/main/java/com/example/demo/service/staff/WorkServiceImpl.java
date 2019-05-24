package com.example.demo.service.staff;

import com.example.demo.model.Work;
import com.example.demo.repository.staff.WorkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkDao  workDao;

	@Override
	public List<Work> getWorkList(String staff_no){
		List<Work> workList = workDao.findWorkByStaff_no(staff_no);
		return workList;
	}

}
