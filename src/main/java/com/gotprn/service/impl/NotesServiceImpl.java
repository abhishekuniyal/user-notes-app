package com.gotprn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprn.dao.NotesDao;
import com.gotprn.models.Notes;
import com.gotprn.service.NotesService;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:53:21 AM
*/

@Service
public class NotesServiceImpl implements NotesService{
	
	Logger LOGGER=LoggerFactory.getLogger(NotesServiceImpl.class);
	
	@Autowired
	private NotesDao notesDao;

	@Override
	public void saveNotes(Long userId, Notes notes) {
		LOGGER.info("userId:"+userId);
		notesDao.saveNotes(userId, notes);
	}

	@Override
	public Notes getNotesByUserIdAndNotesId(Long userId, Long notesId) {
		LOGGER.info("userId:"+userId+":notesId:"+notesId);
		return notesDao.getNotesByUserIdAndNotesId(userId, notesId);
	}

	@Override
	public List<Notes> getNotesByUserId(Long userId) {
		LOGGER.info("userId:"+userId);
		return notesDao.getNotesByUserId(userId);
	}

	@Override
	public void updateNotes(Long userId, Long notesId, Notes notes) {
		LOGGER.info("userId:"+userId+":notesId:"+notesId);
		notesDao.updateNotes(userId, notesId, notes);
	}

	@Override
	public void deleteByUserIdAndNotesId(Long userId, Long notesId) {
		LOGGER.info("userId:"+userId+":notesId:"+notesId);
		notesDao.deleteByUserIdAndNotesId(userId, notesId);
	}

	@Override
	public void deleteAllNotesByUserId(Long userId) {
		LOGGER.info("userId:"+userId);
		notesDao.deleteAllNotesByUserId(userId);
	}

}
