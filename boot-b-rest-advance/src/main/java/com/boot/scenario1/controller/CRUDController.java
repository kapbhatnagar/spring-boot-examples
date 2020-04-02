package com.boot.scenario1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.scenario1.data.rest.model.Tutorial;
import com.boot.scenario1.service.TutorialService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CRUDController {

	// NOTE- It is better to return bad request 400, instead displaying
	// narrowdown error such as conflict(means data already exists). So, that
	// hackers can't understand pb.

	@Autowired
	TutorialService tutorialService;

	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		System.out.println("Fethcing tutorials for title= " + title);
		Optional<List<Tutorial>> tutorials = tutorialService.getAllTutorials(title);
		try {
			if (tutorials.isPresent() && !tutorials.get().isEmpty()) {
				return new ResponseEntity<>(tutorials.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorial(@PathVariable long id) {
		System.out.println("Fethcing tutorial for id= " + id);
		Optional<Tutorial> tutorial = tutorialService.getTutorial(id);
		if (tutorial.isPresent()) {
			return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> addTutorial(@Valid @RequestBody Tutorial tutorialFrmRequest) {
		System.out.println("Adding tutorial whose title= " + tutorialFrmRequest.getTitle());
		Optional<Tutorial> tutorial = tutorialService.addTutorial(tutorialFrmRequest);
		try {
			if (tutorial.isPresent()) {
				return new ResponseEntity<>(tutorial.get(), HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

		// return new ResponseEntity<>(HttpStatus.CONFLICT);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id,
			@Valid @RequestBody Tutorial tutorialFrmRequest) {
		System.out.println("Updating tutorial whose id= " + id);
		Optional<Tutorial> tutorial = tutorialService.updateTutorial(id, tutorialFrmRequest);
		try {
			if (tutorial.isPresent()) {
				return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> deleteById(@PathVariable("id") long id) {
		System.out.println("Deleting tutorial whose id= " + id);
		try {
			tutorialService.deleteTutorial(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		System.out.println("Delete all tutorials");
		try {
			tutorialService.deleteAllTutorials();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		try {
			Optional<List<Tutorial>> tutorials = tutorialService.fetchByPublished(true);

			if (tutorials.isPresent() || tutorials.get().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
