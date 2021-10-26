package com.hoytnote.note.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.hoytnote.note.tools.BeanTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.hoytnote.note.dao.UserCategoryDao;
import com.hoytnote.note.entity.UserCategory;
import com.hoytnote.note.service.UserCategoryService;
import com.hoytnote.note.vo.UserCategoryVo;

@Slf4j
@Service
public class UserCategoryServiceImpl implements UserCategoryService {

	@Autowired
	UserCategoryDao userCategoryDao;

	@Override
	@Transactional
	public void save(UserCategoryVo userCategoryVo) {	
		Long id = userCategoryVo.getId();
		Optional<List<UserCategory>> userCategoryByName = userCategoryDao.findUserCategoryByName(userCategoryVo.getUserId(), userCategoryVo.getName());
		if (userCategoryByName.isPresent()) {
			log.info("is Present");
			List<UserCategory> userCategories = userCategoryByName.get();
			log.info("is Present size is " + userCategories.size());
			if (userCategories.size() > 0) {
				throw new EntityExistsException("重复的分类名字");
			}
			UserCategory userCategory = new UserCategory();
			BeanTools.myCopyProperties(userCategoryVo, userCategory);
			userCategoryDao.save(userCategory);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@Override
	@Transactional
	public void update(UserCategoryVo userCategoryVo) {
		Long id = userCategoryVo.getId();
		Boolean objectExists=userCategoryDao.existsById(id);
		if(objectExists) {
			UserCategory userCategory = new UserCategory();
			BeanUtils.copyProperties(userCategoryVo, userCategory);
			userCategoryDao.save(userCategory);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Boolean objectExists=userCategoryDao.existsById(id);
		if(objectExists) {
			userCategoryDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public UserCategoryVo get(Long id) {
		Optional<UserCategory> userCategoryOptional = userCategoryDao.findById(id);
		UserCategoryVo userCategoryVo=null;
		if(userCategoryOptional.isPresent()) {
			userCategoryVo = new UserCategoryVo();
			BeanUtils.copyProperties(userCategoryOptional.get(), userCategoryVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return userCategoryVo;
	}

	@Override
	@Transactional
	public List<UserCategoryVo> getAll() {
		List<UserCategory> userCategoryList = userCategoryDao.findAll();
		List<UserCategoryVo> userCategoryVoList = new ArrayList<>();
		if (userCategoryList != null && !userCategoryList.isEmpty()) {
			for (UserCategory userCategory : userCategoryList) {
				UserCategoryVo userCategoryVo = new UserCategoryVo();
				BeanUtils.copyProperties(userCategory, userCategoryVo);
				userCategoryVoList.add(userCategoryVo);
			}
		}
		return userCategoryVoList;
	}

	@Override
	@Transactional
	public List<UserCategoryVo> getUsersAll(Long userId) {
		Optional<List<UserCategory>> userCategoryListOptional = userCategoryDao.findUserCategoryByUserID(userId);
		List<UserCategoryVo> userCategoryVoList = new ArrayList<>();

		if(userCategoryListOptional.isPresent()) {
			List<UserCategory> userCategoryList = userCategoryListOptional.get();
			if (userCategoryList != null && !userCategoryList.isEmpty()) {
				for (UserCategory userCategory : userCategoryList) {
					UserCategoryVo userCategoryVo = new UserCategoryVo();
					BeanUtils.copyProperties(userCategory, userCategoryVo);
					userCategoryVoList.add(userCategoryVo);
				}
			}
		}else {
			throw new EntityNotFoundException();
		}
		return userCategoryVoList;
	}

}

