package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {

	@RequestMapping("/one")
	public RedirectView one() {
		System.out.println("this is one handler");
		//redirect view,  create object of redirect view
		RedirectView redirectView=new RedirectView();
		//set the url
		redirectView.setUrl("enjoy");
		return redirectView;
				
		
		
		//redirect prefix
		//return "redirect:/enjoy";
	}

	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("this is second handler");
		return "contact";
	}
}
