package com.hoytnote.note.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoytnote.note.dao.NoteDao;
import com.hoytnote.note.entity.Note;
import com.hoytnote.note.service.NoteService;
import com.hoytnote.note.vo.NoteVo;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDao noteDao;

	@Override
	@Transactional
	public void save(NoteVo noteVo) {	
		Long id = noteVo.getId();
		Boolean objectAlreadyExists=noteDao.existsById(id);
		if(!objectAlreadyExists) {
			Note note = new Note();
			BeanUtils.copyProperties(noteVo, note);
			noteDao.save(note);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(NoteVo noteVo) {
		Long id = noteVo.getId();
		Boolean objectExists=noteDao.existsById(id);
		if(objectExists) {
			Note note = new Note();
			BeanUtils.copyProperties(noteVo, note);
			noteDao.save(note);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Boolean objectExists=noteDao.existsById(id);
		if(objectExists) {
			noteDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public NoteVo get(Long id) {
		Optional<Note> noteOptional = noteDao.findById(id);
		NoteVo noteVo=null;
		if(noteOptional.isPresent()) {
			noteVo = new NoteVo();
			BeanUtils.copyProperties(noteOptional.get(), noteVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return noteVo;
	}

	@Override
	@Transactional
	public List<NoteVo> getAll() {
		List<Note> noteList = noteDao.findAll();
		List<NoteVo> noteVoList = new ArrayList<>();
		if (noteList != null && !noteList.isEmpty()) {
			for (Note note : noteList) {
				NoteVo noteVo = new NoteVo();
				BeanUtils.copyProperties(note, noteVo);
				noteVoList.add(noteVo);
			}
		}
		return noteVoList;
	}

}

