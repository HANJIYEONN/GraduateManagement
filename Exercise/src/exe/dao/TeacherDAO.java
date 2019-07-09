package exe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exe.entity.TeacherEntity;

public class TeacherDAO extends CommonDAO {
	
	public TeacherEntity login(TeacherEntity teacher) {
		TeacherEntity newTeacher = null;
		
		String sql = "	select	* "
				+ "		from 	tbl_teacher "
				+ "		where 	t_id = ?"
				+ "		and		t_pass = ? ";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();

		
			stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacherId());
			stmt.setString(2, teacher.getTeacherPass());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				newTeacher = new TeacherEntity();
				newTeacher.setTeacherId(rs.getString("t_id"));
				newTeacher.setTeacherPass(rs.getString("t_pass"));
				newTeacher.setTeacherName(rs.getString("t_name"));
				newTeacher.setDepartment(rs.getString("dept_code"));
				newTeacher.setTeacherAddr(rs.getString("t_addr"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}

		return newTeacher;
	}
	
	public boolean addTeacher(TeacherEntity teacher) {
		boolean result = false;
		
		String sql =
				" INSERT INTO TBL_TEACHER "
				+ " VALUES( ?, ?, ?, ?, ? ) ";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			System.out.println(teacher.getDepartment());
			stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacherId());
			stmt.setString(2, teacher.getTeacherPass());
			stmt.setString(3, teacher.getTeacherName());
			stmt.setString(4, teacher.getDepartment());
			stmt.setString(5, teacher.getTeacherAddr());
			
			int count = stmt.executeUpdate();

			if (count >= 1) {
				result = true;
				con.commit();
				
			} else {
				con.rollback();
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		}
		
		return result;
	}
			
	
	public boolean updateTeacher(TeacherEntity teacher) {
		boolean result = false;
		
		String sql = "	update 	tbl_teacher "
				+ "		set		t_pass = ? "
				+ "				,t_name = ? "
				+ "				,dept_code = ? "
				+ "				,t_addr = ? "
				+ " where t_id = ? " ;
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, teacher.getTeacherPass());
			stmt.setString(2, teacher.getTeacherName());
			stmt.setString(3, teacher.getDepartment());
			stmt.setString(4, teacher.getTeacherAddr());
			stmt.setString(5, teacher.getTeacherId());
			
			int count = stmt.executeUpdate();

			if (count >= 1) {
				result = true;
				con.commit();

			} else {
				con.rollback();

			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}

		return result;
	}

}
