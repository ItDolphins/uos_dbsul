package com.example.demo.service.calc;

import com.example.demo.model.Calc;
import com.example.demo.repository.calc.CalcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

	public boolean isCalcExist(int store_no , Date calc_yrmn){
		List<Calc> calcList = calcDao.findByStore_noAndCalc_yrmn(store_no , calc_yrmn);
		return calcList.size() != 0;
	}

	public Calc calculate_calc(Calc calc){
		calc = calcDao.getMon_sales_amtAndHead_charge(calc);
		return  calc;
	}

	public void insertCalc(Calc calc){
		calcDao.insertCalc(calc);
	}

	public  void updateCalc(Calc calc){
		calcDao.updateCalc(calc);
	}
}
