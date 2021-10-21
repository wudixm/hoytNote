package com.hoytnote.note.category;

import java.util.Date;

public record UserCategory(long id, long userId, String name, String properties, Date createdAt, Date updatedAt) {
}
