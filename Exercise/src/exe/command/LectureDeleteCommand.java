package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;
import exe.entity.TeacherEntity;

public class LectureDeleteCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		TeacherEntity teacher = (TeacherEntity)session.getAttribute("teacher");
					
		if(teacher == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
			
		} else {
			String lecNum = request.getParameter("lecNum");
			LectureDAO dao = new LectureDAO();
			boolean result = dao.cancelLecture(lecNum);
			
			String code = "41";
			if (result == true) {
				code = "40";
			}
			request.setAttribute("code", code);
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
