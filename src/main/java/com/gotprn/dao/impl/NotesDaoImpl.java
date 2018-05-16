package com.gotprn.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gotprn.dao.NotesDao;
import com.gotprn.exception.GenericCustomException;
import com.gotprn.models.Notes;
import com.gotprn.repository.NotesRepository;
import com.gotprn.repository.UserRepository;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 12:00:51 PM
*/

@Repository
public class NotesDaoImpl implements NotesDao{

	Logger LOGGER=LoggerFactory.getLogger(NotesDaoImpl.class);
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveNotes(Long userId, Notes notes) {
		LOGGER.debug("NotesDaoImpl::userId:"+userId);
		notesRepository.save(notes);
	}

	@Override
	public Notes getNotesByUserIdAndNotesId(Long userId, Long notesId) throws GenericCustomException {
		LOGGER.debug("NotesDaoImpl::userId:"+userId+":notesId:"+notesId);
		if(!userRepository.existsById(userId))
			throw new GenericCustomException("User Id doesn't exist");
		if(!notesRepository.existsById(notesId))
			throw new GenericCustomException("Notes Id doesn't exist");
		
		return userRepository.findById(userId).map(user->{
			return notesRepository.findByIdAndUserId(notesId,userId);
		}).orElseThrow(()->new GenericCustomException("User doesn't Own this Notes"));
	}

	@Override
	public List<Notes> getNotesByUserId(Long userId) throws GenericCustomException {
		LOGGER.debug("NotesDaoImpl::userId:"+userId);
		if(!userRepository.existsById(userId))
			throw new GenericCustomException("Notes Id doesn't exist");
		
		return notesRepository.findByUserId(userId);
	}

	@Override
	public void updateNotes(Long userId, Long notesId, Notes notes) throws GenericCustomException {
		LOGGER.debug("NotesDaoImpl::userId:"+userId+":notesId:"+notesId);
		
		if(!userRepository.existsById(userId))
			throw new GenericCustomException("USer Id doesn't exist");
		if(!notesRepository.existsById(notesId))
			throw new GenericCustomException("Notes Id doesn't exist");
		if(notesRepository.findByIdAndUserId(notesId, userId) == null)
			throw new GenericCustomException("User doesn't Own this Notes");
		
		notesRepository.findById(notesId).map(previousNotes->{
			previousNotes.setCreatedAt(notes.getCreatedAt());
			previousNotes.setNote(notes.getNote());
			previousNotes.setTitle(notes.getTitle());
			previousNotes.setUpdatedAt(notes.getUpdatedAt());
			
			return notesRepository.save(previousNotes);
		}).orElseThrow(()->new GenericCustomException("Notes Id Not valid"));
	}

	@Override
	public void deleteByUserIdAndNotesId(Long userId, Long notesId) throws GenericCustomException {
		LOGGER.debug("NotesDaoImpl::userId:"+userId+":notesId:"+notesId);
		
		if(!userRepository.existsById(userId))
			throw new GenericCustomException("USer Id doesn't exist");
		
		userRepository.findById(userId).map(user->{
			return notesRepository.deleteByIdAndUserId(notesId,userId);
		}).orElseThrow(()->new GenericCustomException("User doesn't Own this Notes"));
		
	}

	@Override
	public void deleteAllNotesByUserId(Long userId) throws GenericCustomException {
		LOGGER.debug("NotesDaoImpl::userId:"+userId);
		if(!userRepository.existsById(userId))
			throw new GenericCustomException("USer Id doesn't exist");
		
		notesRepository.deleteByUserId(userId);
	}

}
