package com.example.demo.service.calc;

import com.example.demo.model.Calc;
import com.example.demo.repository.calc.CalcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CalcService {

	@Autowired
	CalcDao calcDao;

	public List<Calc> getCalcList(int store_no){
		List<Calc> calcList = calcDao.findByStore_no(store_no);
		return  calcList;
	}


}
