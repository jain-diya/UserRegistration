package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import springMVC.model.User;
import springMVC.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header", "Learn Spring Boot");
		m.addAttribute("Desc", "Home for programmer");
	}

	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		System.out.println(user);

		// redirect prefix
		if (user.getUserName().isBlank()) {
			return "redirect:/contact";
		}

		int createdUser = this.userService.createUser(user);
		model.addAttribute("msg", " user created with id " + createdUser);
		return "success";
	}

}

/*
 * using @requestparam and creating object or setting the values with the help
 * of add attribute function========>>>>>>>>>>>>>.
 * 
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
 * String handleForm(
 * 
 * @RequestParam("email") String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String userPassword, Model model) {
 * 
 * System.out.println("user email"+userEmail);
 * System.out.println("user name"+userName);
 * System.out.println("user password"+userPassword);
 * 
 * 
 * 
 * creating object========>>>>>>>> User user=new User();
 * user.setEmail(userEmail); user.setUserName(userName);
 * user.setPassword(userPassword);
 * 
 * 
 * System.out.println(user);
 * 
 * //process model.addAttribute("name", userName); model.addAttribute("email",
 * userEmail); model.addAttribute("password",userPassword);
 * 
 * 
 * model.addAttribute("user", user);
 * 
 * 
 * return "success";
 * 
 * }
 */

/*
 * using model attribute annotation in method=========>>>>>>>>>>>>>>>
 * 
 * 
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
 * String handleForm(@ModelAttribute User user, Model model) {
 * System.out.println(user); // model.addAttribute("user", user); return
 * "success"; }
 * 
 * 
 */
