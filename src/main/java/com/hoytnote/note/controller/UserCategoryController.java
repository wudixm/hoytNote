package com.hoytnote.note.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoytnote.note.service.UserCategoryService;
import com.hoytnote.note.vo.UserCategoryVo;

@RestController
public class UserCategoryController {

	@Autowired
	UserCategoryService userCategoryService;

	@PostMapping("userCategory")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(UserCategoryVo userCategoryVo) {
		userCategoryService.save(userCategoryVo);
	}

	@GetMapping("userCategory/{id}")
	public UserCategoryVo get( @PathVariable Long id) {
		return userCategoryService.get(id);
	}
	@GetMapping("userCategory/user/{id}")
	public List<UserCategoryVo>  getByUserId( @PathVariable Long id) {
		return userCategoryService.getUsersAll(id);
	}

	@GetMapping("userCategory")
	public List<UserCategoryVo>  getAll() {
		return userCategoryService.getAll();
	}
	
	@PutMapping("userCategory")
	public void update(UserCategoryVo userCategoryVo) {
		userCategoryService.update(userCategoryVo);
	}
	
	@DeleteMapping("userCategory/{id}")
	public void delete( @PathVariable Long id) {
		userCategoryService.delete(id);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleEntityExistsException(EntityExistsException e) {
	    return e.getMessage();
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
	    return e.getMessage();
	}
}
