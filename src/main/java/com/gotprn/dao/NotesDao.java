package com.gotprn.dao;

import java.util.List;

import com.gotprn.models.Notes;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:51:06 AM
*/

public interface NotesDao {

	public void saveNotes(Long userId,Notes notes);
	public Notes getNotesByUserIdAndNotesId(Long userId,Long notesId);
	public List<Notes> getNotesByUserId(Long userId);
	public void updateNotes(Long userId, Long notesId, Notes notes);
	public void deleteByUserIdAndNotesId(Long userId, Long notesId);
	public void deleteAllNotesByUserId(Long userId);
}
