package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.TeacherDAO;
import exe.entity.TeacherEntity;

public class LoginCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		
		TeacherEntity teacher = new TeacherEntity();
		teacher.setTeacherId(request.getParameter("id"));
		teacher.setTeacherPass(request.getParameter("pw"));
		
		TeacherDAO dao = new TeacherDAO();
		TeacherEntity newTeacher = dao.login(teacher);
		
		ActionForward action = new ActionForward();
		
		if (newTeacher != null) {
			HttpSession session = request.getSession();
			session.setAttribute("teacher", newTeacher);
			
			action.setPath("main.do");
			action.setSend(true);
			
		} else {
			request.setAttribute("code", "00");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
		
	}

}
