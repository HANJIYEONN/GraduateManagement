package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.SubjectDAO;
import exe.entity.SubjectEntity;
import exe.entity.TeacherEntity;

public class SubjectDetailCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		TeacherEntity teacher = (TeacherEntity)session.getAttribute("teacher");
		
		
		ActionForward action = new ActionForward();
		
		if(teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
			
		} else {
			SubjectDAO dao = new SubjectDAO();
			String subId = request.getParameter("subId");
			SubjectEntity subject = dao.searchSubjectById(subId);
			request.setAttribute("subject", subject);
			
			action.setPath("WEB-INF/subjectDetail.jsp");
			action.setSend(false);
		}
			
		return action;
	}

}
