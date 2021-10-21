package com.hoytnote.note.core;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteDAO noteDAO;

    public List<Note> getNoteByID(long noteId) {
//        return Arrays.asList(new Note(1L, 1L, "test_name", "content"), new Note(2L, 2L, "test_name2", "content2"));
        return null;
    }

    public String createNote(String name, String content) throws IOException {
        System.out.println("name = " + name);
        System.out.println("content = " + content);
//        return noteDAO.createNote(new Note(null, 1L, name, content));

        return "";
    }

    public String searchNote(String keyword) throws IOException, ParseException {
        return noteDAO.searchNote(keyword);
    }
}
