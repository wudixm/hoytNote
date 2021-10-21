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

import com.hoytnote.note.service.NoteService;
import com.hoytnote.note.vo.NoteVo;

@RestController
public class NoteController {

	@Autowired
	NoteService noteService;

	@PostMapping("note")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(NoteVo noteVo) {
		noteService.save(noteVo);
	}

	@GetMapping("note/{id}")
	public NoteVo get( @PathVariable Long id) {
		return noteService.get(id);
	}

	@GetMapping("note")
	public List<NoteVo>  getAll() {
		return noteService.getAll();
	}
	
	@PutMapping("note")
	public void update(NoteVo noteVo) {
		noteService.update(noteVo);
	}
	
	@DeleteMapping("note/{id}")
	public void delete( @PathVariable Long id) {
		noteService.delete(id);
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
