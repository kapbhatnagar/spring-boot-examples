package com.boot.scenario1.service;

import java.util.List;
import java.util.Optional;

import com.boot.scenario1.data.rest.model.Tutorial;

public interface TutorialService {

	Optional<List<Tutorial>> getAllTutorials(String title);
	
	Optional<Tutorial> getTutorial(long id);

	Optional<Tutorial> addTutorial(Tutorial tutorial);
	
	Optional<Tutorial> updateTutorial(long id, Tutorial tutorial);

	void deleteTutorial(long id);
	
	void deleteAllTutorials();
	
	Optional<List<Tutorial>> fetchByPublished(boolean isPublished);

}
