package sgrs.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgrs.ServiceFactory;
import sgrs.Domain.User;
import sgrs.Service.AccountService;

@Controller
@RequestMapping(value = "/AccountController")
public class AccountController {

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String Login(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) {

		AccountService accountService = ServiceFactory.getAccountService();
		User u = accountService.Login(userName, password);

		HttpSession session = request.getSession();
		session.setAttribute("UserRole", u.getRole());
		session.setAttribute("UserName", userName);
		session.setAttribute("UserId", u.getUserId());
		session.setAttribute("FirstName", u.getFirstName());
		session.setAttribute("LastName", u.getLastName());

		if (u.getRole() != null && u.getRole().equals("Student")) {
			return "redirect:/StudentController/Home";
		} else if (u.getRole() != null && u.getRole().equals("Professor")) {
			return "redirect:/ProfessorController/Home";
		} else {
			return "redirect:/AccountController/LoginView?err=true";
		}
	}

	@RequestMapping(value = "/LoginView", method = RequestMethod.GET)
	public String home(@RequestParam(value = "false", required = false) String err, Model model) {
		if (err != null && err.equals("true"))
			model.addAttribute("errorMsg", "Incorrect Credentials");
		return "Login";
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.POST)
	public String Logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/AccountController/LoginView";
	}

}