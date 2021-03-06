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

import com.example.demo.dto.DiscountStock;
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
	

public class StockListMapper implements RowMapper<Stock>{
		
		public Stock mapRow(ResultSet rs, int rowNum) throws SQLException{
			Stock stock = new Stock();
					
			stock.setExpdate(rs.getDate("expdate"));
			stock.setProd_no(rs.getInt("prod_no"));
			stock.setStock_qnt(rs.getInt("stock_qnt"));
			stock.setStore_no(rs.getInt("store_no"));
			stock.setProd_name(rs.getString("prod_name"));
			stock.setProd_price(rs.getInt("prod_price"));

			return stock;
		}
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

public class DiscountStockMapper implements RowMapper<DiscountStock>{
	
	public DiscountStock mapRow(ResultSet rs, int rowNum) throws SQLException{
		DiscountStock stock = new DiscountStock();
				
		stock.setExpdate(rs.getDate("expdate"));
		stock.setProd_no(rs.getInt("prod_no"));
		stock.setStock_qnt(rs.getInt("stock_qnt"));
		stock.setStore_no(rs.getInt("store_no"));
		stock.setProd_name(rs.getString("prod_name"));
		stock.setProd_price(rs.getInt("prod_price"));
		stock.setDc_rate(rs.getInt("dc_rate"));

		return stock;
	}
}
	
	@Override
	public List<Stock> getStockList(int acnt_store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name, p.prod_price from"
				+ " stock s, prod p where s.store_no = ? and s.prod_no = p.prod_no and p.prod_code = ? and p.event_code = ?";
		List<Stock> stock = getJdbcTemplate().query(sql, new Object[] {acnt_store_no,"Y","없음"},new StockListMapper());
		
		return stock;
	}

	@Override
	public Stock getStock(int prod_no, Date expdate, int store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name  from stock s, prod p " +
				"where s.prod_no = ? and s.expdate = ? and s.store_no = ? and s.prod_no = p.prod_no";
		Stock stock = getJdbcTemplate().queryForObject(sql, new Object[]{prod_no, expdate, store_no}, new StockMapper());

		return stock;
	}

	@Override
	public List<Stock> findStock(int prod_no, Date expdate, int store_no) {
		String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name  from stock s, prod p " +
				"where s.prod_no = ? and s.expdate = ? and s.store_no = ? and s.prod_no = p.prod_no";
		List<Stock> stockList;
		try {
			stockList = getJdbcTemplate().query(sql, new Object[]{prod_no, expdate, store_no}, new StockMapper());
		}
		catch (NullPointerException e){
			return null;
		}
		return stockList;
	}

	@Override
	public void updateStock(Stock stock,int changed_amount) {
		String sql = "update stock set stock_qnt=? where prod_no=? and expdate=trunc(?) and store_no=?";
		getJdbcTemplate().update(sql, changed_amount,stock.getProd_no(),stock.getExpdate(),stock.getStore_no());
		
	}
	@Override
	public  void insertStock(Stock stock) {
		String sql = "insert into stock (store_no, prod_no, expdate, stock_qnt) " +
				"values(?,?,trunc(?),?)";
		getJdbcTemplate().update(sql, stock.getStore_no(), stock.getProd_no(),
				stock.getExpdate(), stock.getStock_qnt());
	}

	@Override
	public  void deleteStock(Stock stock) {
		String sql = "delete stock where store_no =? and  prod_no=? and expdate=trunc(?) ";
		getJdbcTemplate().update(sql, stock.getStore_no(), stock.getProd_no(),
				stock.getExpdate());
	}


		@Override
	public int getStock_qnt(int prod_no, Date expdate, int store_no) {
		String sql = "select stock_qnt from stock where prod_no = ? and expdate = ? and store_no = ?";
		int stock_qnt = getJdbcTemplate().queryForObject(sql, new Object[] {prod_no,expdate,store_no},int.class);
		return stock_qnt;
	}

		@Override
		public List<DiscountStock> getDiscountStockList(int acnt_store_no) {
			String sql = "select s.store_no, s.prod_no, s.expdate, s.stock_qnt, p.prod_name, p.prod_price, d.dc_rate from"
					+ " stock s, prod p,dc d where s.store_no = ? and s.prod_no = p.prod_no and p.prod_code = ? and p.event_code = ? and d.event_prod = p.prod_no";
			List<DiscountStock> discountStock = getJdbcTemplate().query(sql, new Object[] {acnt_store_no,"Y","할인"},new DiscountStockMapper());
			
			return discountStock;
		}

}