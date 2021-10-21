package com.hoytnote.note.core;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/note")
public class NoteController {

    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping(path = "getNoteById")
    public List<Note> getNoteByID(@RequestParam(name = "nId") long noteId) {
        return service.getNoteByID(noteId);
    }
    @PostMapping(path = "putNote")
    public String createNote(@RequestParam(name = "name") String name,
                             @RequestParam(name = "content") String content) {
        try {
            return service.createNote(name, content);
        } catch (IOException e) {
            e.printStackTrace();
            return "出错了，请稍候重试";
        }
    }
    @GetMapping(path = "searchNote")
    public String searchNote(@RequestParam(name = "name") String keyword) {
        try {
            return service.searchNote(keyword);
        } catch (IOException e) {
            e.printStackTrace();
            return "出错了，请稍候重试";
        } catch (ParseException e) {
            e.printStackTrace();
            return "parse 出错，请稍候再试";
        }
    }
}
