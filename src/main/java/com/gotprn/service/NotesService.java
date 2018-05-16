package com.gotprn.service;

import java.util.List;

import com.gotprn.exception.GenericCustomException;
import com.gotprn.models.Notes;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:45:29 AM
*/

public interface NotesService {

	public void saveNotes(Long userId,Notes notes) throws GenericCustomException;
	public Notes getNotesByUserIdAndNotesId(Long userId,Long notesId) throws GenericCustomException;
	public List<Notes> getNotesByUserId(Long userId) throws GenericCustomException;
	public void updateNotes(Long userId, Long notesId, Notes notes) throws GenericCustomException;
	public void deleteByUserIdAndNotesId(Long userId, Long notesId) throws GenericCustomException;
	public void deleteAllNotesByUserId(Long userId) throws GenericCustomException;
}
