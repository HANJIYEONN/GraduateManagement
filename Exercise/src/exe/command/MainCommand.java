package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.entity.TeacherEntity;

public class MainCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		TeacherEntity teacher = (TeacherEntity)session.getAttribute("teacher");

		if (teacher == null) {
			action.setPath("login.do");
			action.setSend(true);
			
		} else {
			request.setAttribute("teacher", teacher);
			action.setPath("WEB-INF/main.jsp");
			action.setSend(false);
			
		}
		
		return action;
		
	}

}
