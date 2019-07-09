package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.LectureDAO;
import exe.dao.SubjectDAO;
import exe.entity.LectureEntity;
import exe.entity.SubjectEntity;
import exe.entity.TeacherEntity;

public class LectureInsertCommand implements Command {

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
			String 		code 		= "32"; // default -- 강의가 중복된 경우
			String 		subjectId 	= request.getParameter("subId");
			LectureDAO 	dao 		= new LectureDAO();
			boolean 	lecture 	= dao.isDuplication(subjectId, teacher.getTeacherId());
			
			if (lecture != true) { // 강의가 중복되지 않음
				lecture = dao.addLecture(subjectId,teacher.getTeacherId()); 

				if (lecture == true ) 	{ code = "30"; }
				else 					{ code = "31"; }
				
			}
			
			request.setAttribute("code", code);
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
	