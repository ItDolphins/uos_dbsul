package com.example.demo.repository.Busireq;

import com.example.demo.dto.WrhsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class  WrhsInfoDao extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class WrhsInfoMapper implements RowMapper<WrhsInfo> {

		public WrhsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			WrhsInfo wrhsInfo = new WrhsInfo();

			wrhsInfo.setWrhs_no(rs.getInt("wrhs_no"));
			wrhsInfo.setReq_no(rs.getInt("req_no"));
			wrhsInfo.setOrder_no(rs.getInt("order_no"));
			wrhsInfo.setWrhs_date(rs.getDate("wrhs_date"));
			wrhsInfo.setExpdate(rs.getDate("expdate"));
			wrhsInfo.setProd_no(rs.getInt("prod_no"));
			wrhsInfo.setProd_name(rs.getString("prod_name"));
			wrhsInfo.setReq_qnt(rs.getInt("req_qnt"));
			wrhsInfo.setStore_no(rs.getInt("store_no"));

			return wrhsInfo;
		}
	}


	public List<WrhsInfo> findByStore_no(int store_no){
		String sql = "select wrhs_no, b.req_no, o.order_no, wrhs_date, expdate, p.prod_no, p.prod_name, b.req_qnt, o.store_no   " +
				"from wrhs w, busireq b, torder o, prod p  " +
				"where o.store_no = ? and w.req_no = b.req_no and b.order_no = o.order_no  and b.prod_no = p.prod_no ";
		List<WrhsInfo> wrhsInfoList = (List<WrhsInfo>) getJdbcTemplate().query(sql, new Object[]{store_no}, new WrhsInfoMapper());
		return wrhsInfoList;
	}
}
