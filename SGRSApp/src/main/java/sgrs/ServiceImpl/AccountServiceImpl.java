package sgrs.ServiceImpl;

import sgrs.DataProvider.AccountDataProvider;
import sgrs.Domain.User;
import sgrs.Service.AccountService;

public class AccountServiceImpl implements AccountService {

	public User Login(String userName, String password) {
		User user = AccountDataProvider.getRoleFromUserNamePassword(userName, password);
		return user;
	}

	public boolean isUserProfessor(int userId) {
		String userRole = AccountDataProvider.getRoleFromUserId(userId);
		if(userRole.equals("Professor"))
			return true;
		else
			return false;
	}

}
