package com.hoytnote.note.dao;

import com.hoytnote.note.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hoytnote.note.entity.Note;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteDao extends JpaRepository<Note, Long>{
    @Query("select a from Note a where a.userId = ?1 and a.categoryId = ?2")
    List<Note> findByUserIDCategoryId(Long userId, Long categoryId);

}