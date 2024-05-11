package springMVC.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	@RequestMapping(path="/home",method = RequestMethod.GET)
	public String home(Model model)
	{
		System.out.println("this is my home page");
		
		//add data in model
		model.addAttribute("name", "diya jain");
		
		model.addAttribute("id", 12345);
		
		List<String> friends=new ArrayList<String>();
		friends.add("diya");
		friends.add("disha");
		friends.add("abc");
		
		model.addAttribute("f",friends);
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String about()
	{
		System.out.println("this is my about page");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help()
	{
		System.out.println("this is help page");
		//creating the object
		ModelAndView modelAndView=new ModelAndView();
		
		//setting the data
		modelAndView.addObject("name", "Disha");
		modelAndView.addObject("rollnumber", 123456789);
		LocalDateTime now=LocalDateTime.now();
		modelAndView.addObject("time" ,now);
		
		//marks
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(1234);
		list.add(123456);
		list.add(123);
		
		modelAndView.addObject("marks",list);
		
		
		//setting the view name
		modelAndView.setViewName("help");
		
		return modelAndView;
		
	}
	
}
