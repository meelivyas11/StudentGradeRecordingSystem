package sgrs.Service;

import sgrs.Domain.User;

public interface AccountService {
	
	public User Login (String userName, String password);

	public boolean isUserProfessor(int loggedInUserId);
}
