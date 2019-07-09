package exe.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.TeacherDAO;
import exe.entity.TeacherEntity;

public class TeacherInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
		
		TeacherEntity teacher = new TeacherEntity();
		teacher.setTeacherId(request.getParameter("id"));
		teacher.setTeacherPass(request.getParameter("pw"));
		teacher.setTeacherName(request.getParameter("name"));
		teacher.setDepartment(request.getParameter("code"));
		teacher.setTeacherAddr(request.getParameter("addr"));
		
		TeacherDAO dao = new TeacherDAO();
		boolean result = dao.addTeacher(teacher);
		
		
		ActionForward action= new ActionForward();
		if (result) {
			request.setAttribute("code", "10");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
			
		} else {
			request.setAttribute("code", "11");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
