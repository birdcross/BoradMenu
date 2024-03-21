package com.board.menus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.menus.domain.MenuVo;

@Mapper
public interface MenuMapper {
	void insertMenu(MenuVo menuVo);

	List<MenuVo> getMenuList();

	void deletemenu(MenuVo menuVo);
	
}
