package com.boot.scenario1.data.rest.model;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);

	/* We can use JpaRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById()… without implementing these
	 * methods.
	 */

}
