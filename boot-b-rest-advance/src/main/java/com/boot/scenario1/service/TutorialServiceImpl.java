package com.boot.scenario1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.scenario1.data.rest.model.Tutorial;
import com.boot.scenario1.data.rest.model.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	TutorialRepository tutorialRepository;

	/**
	 * Fetch all tutorials if title in null else return all tutorials which
	 * contains title.
	 */
	@Override
	public Optional<List<Tutorial>> getAllTutorials(String title) {
		Optional<List<Tutorial>> tutorials = null;
		if (null == title) {
			tutorials = Optional.ofNullable(tutorialRepository.findAll());
		} else {
			tutorials = Optional.ofNullable(tutorialRepository.findByTitleContaining(title));
		}
		return tutorials;
	}

	@Override
	public Optional<Tutorial> getTutorial(long id) {
		return tutorialRepository.findById(id);
	}

	@Override
	public Optional<Tutorial> addTutorial(Tutorial tutorial) {
		return Optional.ofNullable(tutorialRepository.save(tutorial));
	}

	@Override
	public Optional<Tutorial> updateTutorial(long id, Tutorial tutorial) {
		Optional<Tutorial> tutorialEntity = tutorialRepository.findById(id);
		Tutorial _tutorial = null;
		if (tutorialEntity.isPresent()) {
			_tutorial = tutorialEntity.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			return Optional.ofNullable(tutorialRepository.save(_tutorial));
		}
		return Optional.ofNullable(null);
	}

	@Override
	public void deleteTutorial(long id) {
		tutorialRepository.deleteById(id);
	}

	@Override
	public void deleteAllTutorials(){
		tutorialRepository.deleteAll();
	}
	
	@Override
	public Optional<List<Tutorial>> fetchByPublished(boolean isPublished) {
		return Optional.ofNullable(tutorialRepository.findByPublished(isPublished));
	}

}
