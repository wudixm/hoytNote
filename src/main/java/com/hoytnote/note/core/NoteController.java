package com.hoytnote.note.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/note")
public class NoteController {

    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping(path = "getNote")
    public List<Note> getNoteByID(@RequestParam(name = "nId") long noteId) {
        return service.getNoteByID(noteId);
    }
    @PostMapping(path = "putNote")
    public String createNote(@RequestParam(name = "name") String name,
                             @RequestParam(name = "content") String content) {
        return service.createNote(name, content);
    }
}
