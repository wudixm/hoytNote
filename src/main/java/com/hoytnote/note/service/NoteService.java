package com.hoytnote.note.service;

import java.util.List;

import com.hoytnote.note.vo.NoteVo;

public interface NoteService {

	void save(NoteVo noteVo) ;
	void update(NoteVo noteVo) ;
	void delete(Long id);
	NoteVo get(Long id);
	List<NoteVo> getAll();

}

