package com.example.demo.repository.order;

import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class OrderDaoImpl extends  JdbcDaoSupport implements  OrderDao{


	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class OrderMapper implements RowMapper<Order> {

		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();

			order.setOrder_no(rs.getInt("order_no"));
			order.setStore_no(rs.getInt("store_no"));
			order.setOrder_date(rs.getDate("order_date"));
			order.setOrder_state(rs.getString("order_state"));

			return order;
		}
	}

	@Override
	public  List<Order> findByStore_no(int store_no){
		String sql  = "select *  from torder where store_no = ?";
		List<Order> orderList = (List<Order>) getJdbcTemplate().query(sql, new Object[] {store_no}, new OrderMapper());
		return orderList;
	}
	@Override
	public  Order getByOrder_no(int order_no ){
		String sql = "select * from torder where order_no = ?";
		Order order = (Order) getJdbcTemplate().queryForObject(sql, new Object[] {order_no},new OrderMapper());
		return order;
	}


}
