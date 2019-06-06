package com.example.demo.repository.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Event;


@Transactional
@Repository
public class EventDaoImpl  extends JdbcDaoSupport implements EventDao {

	@Autowired
	DataSource dataSource;
	

	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	public class PrEventMapper implements RowMapper<Event>{
		public Event mapRow(ResultSet rs,int rowNum) throws SQLException{
			Event event=new Event();
			
			event.setPresent_no(rs.getInt("present_no"));
			event.setEvent_prod(rs.getString("event_prod"));
			event.setEvent_name(rs.getString("event_name"));
			event.setEvent_start_day(rs.getDate("event_start_day"));
			event.setEvent_end_day(rs.getDate("event_end_day"));
			event.setPresent_prod(rs.getString("present_prod"));
			
			return event;
		}
		
	}
	
	public class DcEventMapper implements RowMapper<Event>{
		public Event mapRow(ResultSet rs,int rowNum) throws SQLException{
			Event event=new Event();
	
			event.setDc_no(rs.getInt("dc_no"));
			event.setEvent_prod(rs.getString("event_prod"));
			event.setEvent_name(rs.getString("event_name"));
			event.setEvent_start_day(rs.getDate("event_start_day"));
			event.setEvent_end_day(rs.getDate("event_end_day"));
			event.setDc_rate(rs.getInt("dc_rate"));
			
			return event;

		}
		
	}
	
	
	
	
	@Override
	public ArrayList<Event> findAllPrEvent() {
		// TODO Auto-generated method stub
		String sql="select present_no, p.prod_name as event_prod, event_name, event_start_day, event_end_day, p2.prod_name as present_prod  from tpresent tp, prod p, prod p2 where tp.event_prod=p.prod_no and tp.present_prod=p2.prod_no";
		try {
			ArrayList<Event> result = (ArrayList<Event>)getJdbcTemplate().query(sql,new Object[] {},new PrEventMapper());
		return result;
		
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Event> findAllDcEvent() {
		// TODO Auto-generated method stub
		String sql="select dc_no, p.prod_name as event_prod , event_name, event_start_day, event_end_day, dc_rate  from dc dc, prod p where dc.event_prod=p.prod_no";
		try {
			ArrayList<Event> result = (ArrayList<Event>)getJdbcTemplate().query(sql,new Object[] {},new DcEventMapper());
		return result;
		
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insertPrEvent(Event event) {
		// TODO Auto-generated method stub
		String sql = "insert into tpresent ( present_no, event_prod, event_name, event_start_day, event_end_day, present_prod) values(SEQ_PRESENT.NEXTVAL,?,?, ?,?, ?)";
		getJdbcTemplate().update(sql,new Object[] {event.getEvent_prod_no(),event.getEvent_name(),event.getEvent_start_day(),event.getEvent_end_day(),event.getPresent_prod_no()});
	}

	@Override
	public void insertDcEvent(Event event) {
		// TODO Auto-generated method stub
		String sql = "insert into dc ( dc_no, event_prod, event_name, event_start_day, event_end_day, dc_rate) values(SEQ_DC.NEXTVAL,?,?, ?,?, ?)";
		getJdbcTemplate().update(sql,new Object[] {event.getEvent_prod_no(),event.getEvent_name(),event.getEvent_start_day(),event.getEvent_end_day(),event.getDc_rate()});
	}
	

}
