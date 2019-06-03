package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
		
	@ResponseBody
	@RequestMapping("/board/update")
	public String update(
			//String name
			//@RequestParam String name
			
			//추천하는 것
			@RequestParam("name") String name
			) {
		System.out.println("----" + name);
		return "BoardController:update()";
	}
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write(
			@RequestParam(value="n", required=true, defaultValue = "") String name,
			@RequestParam(value="a", required=true, defaultValue = "0") int age //넘어올때는 String으로 넘어오지만 자동으로 type casting 해준다.
			) {
		System.out.println("---" + name+"---"+age);
		return "BoardController:write()";
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable(value="no") Long no) {
		return "BoardController:view("+no+")";
	}
	
}
