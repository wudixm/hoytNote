package com.hoytnote.note.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value = "userCategory", method = RequestMethod.DELETE)
	public void delete( @RequestParam Long id) {
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
