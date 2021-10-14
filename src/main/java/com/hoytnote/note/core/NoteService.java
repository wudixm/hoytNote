package com.hoytnote.note.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    @Value("${indexPath}")
    private String indexPath;

    public List<Note> getNoteByID(long noteId) {
        return Arrays.asList(new Note(1L, "test_name", "content"), new Note(2L, "test_name2", "content2"));
    }

    public String createNote(String name, String content) {
        System.out.println("name = " + name);
        System.out.println("indexPath = " + indexPath);
        return "success";
    }

}
