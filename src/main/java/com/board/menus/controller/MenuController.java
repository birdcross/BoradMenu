package com.board.menus.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println("MenuController list menuList:" + menuList);
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
	public String write(MenuVo menuVo) {
		//넘어온 데이터를 저장하고 
		menuMapper.insertMenu(menuVo);
		return "menus/list"; // menus/list.jsp
	}
	
}






