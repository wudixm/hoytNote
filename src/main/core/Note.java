package com.hoytnote.note.core;

import java.util.Date;

public record Note(Long id, Long userId, Long categoryId, String title, String content, String properties,
                   Date createdAt, Date updatedAt) {

}