package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;

public class LogoutCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		ActionForward action = new ActionForward();
		action.setPath("loginForm.do");
		action.setSend(true);
		
		return action;	
	}

}
