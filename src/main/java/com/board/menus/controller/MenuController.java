package com.board.menus.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;
@RequestMapping("/Menus")
@Controller
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	// 메뉴 목록 조회
	@RequestMapping("/List") // / menus/List
	public String list(Model model) {
		List<MenuVo> menuList =  menuMapper.getMenuList();
	// 조회 결과를 넘겨준다(model)
		model.addAttribute("menuList",menuList);
		//System.out.println("MenuController list menuList:" + menuList);
		return "menus/list";
	}
	
	
	// /Menus/WriteForm
	//@RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")
	public   String   writeForm() {
		return "menus/write";  // /WEB-INF/views/ + menus/write + .jsp
	}
	
	
	@RequestMapping("/Write")
	//Menus/WriteW?menu_id=menu02&menu_name=JSP&menu_seq=2
	public String write(MenuVo menuVo, Model model) {
		//넘어온 데이터를 저장하고 
		menuMapper.insertMenu(menuVo);
		//List<MenuVo> menuList = menuMapper.getMenuList();
		//model.addAttribute("menuList",menuList);
		//return "menus/list"; // menus/list.jsp
		return "redirect:/Menus/List";
	}
	
	@RequestMapping("/WriteForm2")
	public String writeform2() {
		
		return "menus/write2";
	}
	@RequestMapping("/Write2")
	public String write2(MenuVo menuVo) {
		//저장
		menuMapper.insertMenuByName(menuVo);
		//조회로 이동
		return "redirect:/Menus/List";
	}
	// 메뉴삭제 /Menus/Delete
	@RequestMapping("/Delete")
	@ResponseBody
	public String delete(MenuVo menuVo) {
		menuMapper.deletemenu(menuVo);
		String html = "<script>";
		html += "alert('삭제되었습니다.');";
		html += "location.href='/Menus/List'";
		html += "</script>";
		return html;
	}
	
	
	
	/*
	// 메뉴삭제 /Menus/Delete
	@RequestMapping("/Delete")
	public String delete (MenuVo menuVo, Model model) {
		// MENU03 을 삭제
		menuMapper.deletemenu(menuVo);
		//다시조회해서 model에 담는다
		//List<MenuVo> menuList = menuMapper.getMenuList();
		//model.addAttribute("menuList", menuList);
		//이동할 파일
		//return "menus/list";
		return "redirect:/Menus/List";
	}
	*/
}	






