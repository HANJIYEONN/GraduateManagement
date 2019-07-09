package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;
import exe.entity.LectureEntity;
import exe.entity.TeacherEntity;

public class LectureListCommand implements Command {

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
			LectureDAO dao = new LectureDAO();
			ArrayList<LectureEntity> lectureList = dao.searchLecture(teacher.getTeacherId());
			request.setAttribute("lectureList", lectureList);
		
			
			action.setPath("WEB-INF/lectureList.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
