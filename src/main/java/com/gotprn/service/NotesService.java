package com.gotprn.service;

import java.util.List;

import com.gotprn.models.Notes;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:45:29 AM
*/

public interface NotesService {

	public void saveNotes(Long userId,Notes notes);
	public Notes getNotesByUserIdAndNotesId(Long userId,Long notesId);
	public List<Notes> getNotesByUserId(Long userId);
	public void updateNotes(Long userId, Long notesId, Notes notes);
	public void deleteByUserIdAndNotesId(Long userId, Long notesId);
	public void deleteAllNotesByUserId(Long userId);
}
