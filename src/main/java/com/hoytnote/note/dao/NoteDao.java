package com.hoytnote.note.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hoytnote.note.entity.Note;

@Repository
public interface NoteDao extends JpaRepository<Note, Long>{

}