package com.hoytnote.note.service;

import java.util.List;

import com.hoytnote.note.vo.UserCategoryVo;

public interface UserCategoryService {

	void save(UserCategoryVo userCategoryVo) ;
	void update(UserCategoryVo userCategoryVo) ;
	void delete(Long id);
	UserCategoryVo get(Long id);
	List<UserCategoryVo> getAll();
	List<UserCategoryVo> getUsersAll(Long userId);

}

