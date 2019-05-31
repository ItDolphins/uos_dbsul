package com.example.demo.repository.release;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Stock;

@Transactional
@Service
public class ReleaseDaoImpl extends JdbcDaoSupport implements ReleaseDao{

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public class StockMapper implements RowMapper<Stock>{
		
		public Stock mapRow(ResultSet rs, int rowNum) throws SQLException{
			Stock stock = new Stock();
			
			stock.setExpdate(rs.getDate("expdate"));
			stock.setProd_name(rs.getString("prod_name"));
			stock.setProd_no(rs.getInt("prod_no"));
			stock.setStock_qnt(rs.getInt("stock_qnt"));
			
			return stock;
		}
	}
	
	@Override
	public List<Stock> getStockList(int acnt_store_no) {
		String sql = "select s.prod_no, s.expdate, s.stock_qnt,p.prod_name from"
				+ " stock s, prod p where s.store_no = ? and s.prod_no = p.prod_no";
		List<Stock> stock = (List<Stock>)getJdbcTemplate().query(sql, new Object[] {acnt_store_no},new StockMapper());
		
		return stock;
	}

}
