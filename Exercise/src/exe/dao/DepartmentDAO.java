package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exe.entity.DepartmentEntity;

public class DepartmentDAO extends CommonDAO {

	public ArrayList<DepartmentEntity> getDepartmentList() {
		ArrayList<DepartmentEntity> departmentList = new ArrayList<DepartmentEntity>();
//지금 여기는 학과의 모든것을 받을려고 하고 있어영
		String sql = "		select 	* " 
					+ "		from	tbl_department ";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();
			
		while(rs.next()) {
			DepartmentEntity dept = new DepartmentEntity();
			dept.setDeptCode(rs.getString("dept_code"));
			dept.setDeptName(rs.getString("dept_name"));
			
			departmentList.add(dept);
		}
			
		} catch (Exception e) {
				e.printStackTrace();
				
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
		return departmentList;
	}

}
