package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.DepartmentDAO;
import exe.entity.DepartmentEntity;

public class TeacherInsertFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request)
			throws IOException, ServletException {
		
		ActionForward action = new ActionForward();
		
		DepartmentDAO dao = new DepartmentDAO();
		ArrayList<DepartmentEntity> result = dao.getDepartmentList();
		request.setAttribute("deptList", result );
		
		action.setPath("WEB-INF/teacherInsertForm.jsp");
		action.setSend(false);

		return action;
	}

}
