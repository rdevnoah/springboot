package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		model.addAttribute("list", list);
		return "/guestbook/list";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo vo) {
		guestbookService.writeContents(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable(value="no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/guestbook/delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		guestbookService.deleteContents(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/timeline")
	public String timeline(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		model.addAttribute("list", list);
		return "/guestbook/index-timeline";
	}
	
}
