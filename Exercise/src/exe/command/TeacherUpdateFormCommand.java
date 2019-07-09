package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.DepartmentDAO;
import exe.entity.DepartmentEntity;
import exe.entity.TeacherEntity;

public class TeacherUpdateFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		TeacherEntity teacher = (TeacherEntity)session.getAttribute("teacher");
		
		if (teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
			
		} else {
			DepartmentDAO dao = new DepartmentDAO();
			ArrayList<DepartmentEntity> result = dao.getDepartmentList();
			request.setAttribute("deptList", result );
			request.setAttribute("teacher", teacher);
			
			action.setPath("WEB-INF/teacherUpdateForm.jsp");
			action.setSend(false);
			
		}

		return action;
		
	}

}
