package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exe.entity.SubjectEntity;

public class SubjectDAO extends CommonDAO {

	public ArrayList<SubjectEntity> searchSubjectByDepartment(String department) {
		ArrayList<SubjectEntity> subjectList = new ArrayList<SubjectEntity>();
		
		String sql = "	select *"
				+ "		from tbl_subject"
				+ "		join tbl_department using (dept_code) "
				+ "		where dept_code = ? ";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, department );

			rs = stmt.executeQuery();
			
		while(rs.next()) {
			SubjectEntity subject = new SubjectEntity();
			subject.setSubjectId(rs.getString("sub_id"));
			subject.setSubjectName(rs.getString("sub_name"));
			subject.setDeptName(rs.getString("dept_name"));
				subjectList.add(subject);
		}
			
		} catch (Exception e) {
				e.printStackTrace();
				
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return subjectList;
	}

	public SubjectEntity searchSubjectById(String subjectId) {
		SubjectEntity subject = new SubjectEntity();
		
		String sql = "	select	 *"
				+ "		from 	tbl_subject "
				+ "		join	tbl_department using (dept_code) "
				+ "		where	sub_id = ? "; 
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subjectId);

			rs = stmt.executeQuery();
			
		while(rs.next()) {
			subject.setSubjectId(rs.getString("sub_id"));
			subject.setSubjectName(rs.getString("sub_name"));
			subject.setDeptName(rs.getString("dept_name"));
			subject.setSubjectInfo(rs.getString("sub_info"));
			}
		
		
		} catch (Exception e) {
				e.printStackTrace();
				
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		

		return subject;
	}

}
