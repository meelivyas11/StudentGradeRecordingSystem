package sgrs;

import sgrs.Service.AccountService;
import sgrs.Service.ProfessorService;
import sgrs.Service.StudentService;
import sgrs.ServiceImpl.AccountServiceImpl;
import sgrs.ServiceImpl.ProfessorServiceImpl;
import sgrs.ServiceImpl.StudentServiceImpl;

public class ServiceFactory {

	public static AccountService getAccountService() {
		return new AccountServiceImpl();
	}
	
	public static ProfessorService getProfessorService() {
		return new ProfessorServiceImpl();
	}
	
	public static StudentService getStudentService() {
		return new StudentServiceImpl();
	}
}
