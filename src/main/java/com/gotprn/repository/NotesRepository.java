package com.gotprn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprn.models.Notes;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 12:02:12 PM
*/

public interface NotesRepository extends JpaRepository<Notes, Long>{

	Notes findByIdAndUserId(Long notesId, Long userId);

	List<Notes> findByUserId(Long userId);

	Object deleteByIdAndUserId(Long notesId, Long userId);

	void deleteByUserId(Long userId);
}
