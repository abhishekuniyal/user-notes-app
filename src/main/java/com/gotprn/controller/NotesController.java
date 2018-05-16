package com.gotprn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotprn.exception.GenericCustomException;
import com.gotprn.models.Notes;
import com.gotprn.service.NotesService;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 12:33:27 PM
*/

@RestController
@RequestMapping("/notesService")
public class NotesController {

	@Autowired
	private NotesService notesService;
	
	@PostMapping(value="/user/{userId}/notes",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveNotes(@PathVariable Long userId, @RequestBody Notes notes) throws GenericCustomException{
		notesService.saveNotes(userId, notes);
	}
	
	@GetMapping(value="/user/{userId}/notes/{notesId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Notes getNotesByUserIdAndNotesId(@PathVariable Long userId, @PathVariable Long notesId) throws GenericCustomException{
		return notesService.getNotesByUserIdAndNotesId(userId, notesId);
	}
	
	@GetMapping(value="/user/{userId}/notes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Notes> getNotesByUserId(@PathVariable Long userId) throws GenericCustomException{
		return notesService.getNotesByUserId(userId);
	}
	@PutMapping(value="/user/{userId}/notes/{notesId}")
	public void updateNotes(@PathVariable Long userId, @PathVariable Long notesId,@RequestBody Notes notes) throws GenericCustomException{
		notesService.updateNotes(userId, notesId, notes);
	}
	
	@DeleteMapping(value="/user/{userId}/notes/{notesId}")
	public void deleteByUserIdAndNotesId(@PathVariable Long userId, @PathVariable Long notesId) throws GenericCustomException{
		notesService.deleteByUserIdAndNotesId(userId, notesId);
	}
	@DeleteMapping(value="/user/{userId}/notes")
	public void deleteAllNotesByUserId(Long userId) throws GenericCustomException{
		notesService.deleteAllNotesByUserId(userId);
	}
}
