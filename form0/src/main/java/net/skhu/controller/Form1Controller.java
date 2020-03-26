package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.model.ColorOption;
import net.skhu.model.Data;

@Controller
public class Form1Controller {
	// 첫 페이지
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	// edit1
	@RequestMapping(value = "/form1/edit1", method = RequestMethod.GET)
	public String edit1(Model model) {
		return "edit1";
	}

	@RequestMapping(value = "/form1/edit1", method = RequestMethod.POST)
	public String edit1(Model model, @RequestParam("title") String title, @RequestParam("color") int color) {
		model.addAttribute("title", title);
		model.addAttribute("color", color);
		System.out.printf("제목: %s. 색: %d\n", title, color);
		return "edit1";
	}

	// edit2
	@RequestMapping(value = "/form1/edit2", method = RequestMethod.GET)
	public String edit2(Model model) {
		model.addAttribute("data", new Data()); //이 줄을 삭제해도 에러가 발생하지 않는다.
		return "edit2";
	}

	@RequestMapping(value = "/form1/edit2", method = RequestMethod.POST)
	public String edit2(Model model, Data data) {
		System.out.printf("제목: %s, 색: %d\n", data.getTitle(), data.getColor());
		return "edit2";
	}
	
	// edit3
	@RequestMapping(value="/form1/edit3", method=RequestMethod.GET)
	public String edit3(Model model) {
		model.addAttribute("data", new Data());
		return "edit3";
	}

	@RequestMapping(value="/form1/edit3", method=RequestMethod.POST)
	 public String edit3(Model model, Data data) {
		System.out.printf("제목: %s. 색: %d\n", data.getTitle(), data.getColor());
		return "edit3";
	}
	
	
	
	static final ColorOption[] colorOptions = new ColorOption[] {
			new ColorOption(1,"빨강"), new ColorOption(2,"노랑"), new ColorOption(3,"파랑")};
	
	// edit4
	@RequestMapping(value="/form1/edit4", method=RequestMethod.GET)
	public String edit4(Model model) {
		model.addAttribute("data", new Data());
		model.addAttribute("colorOptions", colorOptions);
		return "edit4";
	}

	@RequestMapping(value="/form1/edit4", method=RequestMethod.POST)
	 public String edit4(Model model, Data data) {
		model.addAttribute("colorOptions", colorOptions);
		System.out.printf("제목: %s. 색: %d\n", data.getTitle(), data.getColor());
		return "edit4";
	}
}