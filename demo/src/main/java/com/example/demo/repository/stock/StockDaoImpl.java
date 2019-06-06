package com.example.demo.repository.stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class StockDaoImpl extends JdbcDaoSupport implements StockDao{

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
			stock.setProd_no(rs.getInt("prod_no"));
			stock.setStock_qnt(rs.getInt("stock_qnt"));
			stock.setStore_no(rs.getInt("store_no"));
			stock.setProd_name(rs.getString("prod_name"));

			return stock;
		}
	}
	
	@Override
	public List<Stock> getStockList(int acnt_store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name from"
				+ " stock s, prod p where s.store_no = ? and s.prod_no = p.prod_no";
		List<Stock> stock = (List<Stock>)getJdbcTemplate().query(sql, new Object[] {acnt_store_no},new StockMapper());
		
		return stock;
	}

	@Override
	public Stock getStock(int prod_no, Date expdate, int store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name  from stock s, prod p " +
				"where s.prod_no = ? and s.expdate = ? and s.store_no = ? and s.prod_no = p.prod_no";
		Stock stock = (Stock) getJdbcTemplate().queryForObject(sql, new Object[]{prod_no, expdate, store_no}, new StockMapper());

		return stock;
	}

	@Override
	public List<Stock> findStock(int prod_no, Date expdate, int store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name  from stock s, prod p " +
				"where s.prod_no = ? and s.expdate = ? and s.store_no = ? and s.prod_no = p.prod_no";
		List<Stock> stockList;
		try {
			stockList = (List<Stock>) getJdbcTemplate().query(sql, new Object[]{prod_no, expdate, store_no}, new StockMapper());
		}
		catch (NullPointerException e){
			return null;
		}
		return stockList;
	}

	@Override
	public void updateStock(Stock stock,int changed_amount) {
		String sql = "update stock set stock_qnt=? where prod_no=? and expdate=? and store_no=?";
		getJdbcTemplate().update(sql, new Object[] {changed_amount,stock.getProd_no(),stock.getExpdate(),stock.getStore_no()});
		
	}
	@Override
	public  void insertStock(Stock stock) {
		String sql = "insert into stock (store_no, prod_no, expdate, stock_qnt) " +
				"values(?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {stock.getStore_no(), stock.getProd_no(),
		stock.getExpdate(), stock.getStock_qnt()});
	}

		@Override
	public int getStock_qnt(int prod_no, Date expdate, int store_no) {
		String sql = "select stock_qnt from stock where prod_no = ? and expdate = ? and store_no = ?";
		int stock_qnt = getJdbcTemplate().queryForObject(sql, new Object[] {prod_no,expdate,store_no},int.class);
		return stock_qnt;
	}

}