package com.hoytnote.note.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hoytnote.note.entity.UserCategory;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCategoryDao extends JpaRepository<UserCategory, Long>{

    @Query("select a from UserCategory a where a.userId = ?1")
    Optional<List<UserCategory>> findUserCategoryByUserID(Long id);

    @Query("select a from UserCategory a where a.userId = ?1 and name = ?2")
    Optional<List<UserCategory>> findUserCategoryByName(Long userId, String newCatName);
}