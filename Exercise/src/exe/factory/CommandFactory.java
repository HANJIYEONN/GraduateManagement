package exe.factory;

import java.util.HashMap;

import exe.command.LectureDeleteCommand;
import exe.command.LectureInsertCommand;
import exe.command.LectureListCommand;
import exe.command.LoginCommand;
import exe.command.LoginFormCommand;
import exe.command.LogoutCommand;
import exe.command.MainCommand;
import exe.command.SubjectDetailCommand;
import exe.command.SubjectListCommand;
import exe.command.TeacherInsertCommand;
import exe.command.TeacherInsertFormCommand;
import exe.command.TeacherUpdateCommand;
import exe.command.TeacherUpdateFormCommand;
import exe.common.Command;

public class CommandFactory {
	private HashMap<String, Command> map = new HashMap<String, Command>();
	private static CommandFactory factory = new CommandFactory();
	
	private CommandFactory () {
		//회원가입 
		map.put("/exercise/teacherInsertForm.do", 	new TeacherInsertFormCommand());
		map.put("/exercise/teacherInsert.do", 		new TeacherInsertCommand());
		//로그인
		map.put("/exercise/loginForm.do", 			new LoginFormCommand());
		map.put("/exercise/login.do", 				new LoginCommand());
		map.put("/exercise/logout.do", 				new LogoutCommand());
		//메인
		map.put("/exercise/main.do", 				new MainCommand());
		//정보수정
		map.put("/exercise/teacherUpdateForm.do", 	new TeacherUpdateFormCommand());
		map.put("/exercise/teacherUpdate.do", 		new TeacherUpdateCommand());
		//내 강의
		map.put("/exercise/lectureList.do", 		new LectureListCommand());
		map.put("/exercise/lectureInsert.do", 		new LectureInsertCommand());
		map.put("/exercise/lectureDelete.do", 		new LectureDeleteCommand());
		//강의
		map.put("/exercise/subjectList.do", 		new SubjectListCommand());
		map.put("/exercise/subjectDetail.do", 		new SubjectDetailCommand());

	}
	
	public static CommandFactory getInstance() {
		return factory;
	}
	
	public Command getCommand(String url) {
		return map.get(url);
	}
}
