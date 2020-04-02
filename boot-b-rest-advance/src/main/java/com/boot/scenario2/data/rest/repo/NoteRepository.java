package com.boot.scenario2.data.rest.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "notes", collectionResourceRel = "notes")
public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {//Use JpaRepository which extends PagingAndSortingRepository
	List<Note> findByTitle(@Param("title") String title);
	// http://localhost:8080/notes/search/findByTitle?title=title2
	
	List<Note> findByTitleIgnoreCaseContaining(@Param("title") String title);
	// http://localhost:8080/notes/search/findByTitleIgnoreCaseContaining?title=t (Uses like query)
	
	@RestResource(path="fetchByContent")
	List<Note> findByContent(@Param("content") String content);
	// http://localhost:8080/notes/search/fetchByContent?content=content4
	
	// Sort http://localhost:8080/notes?sort=content or http://localhost:8080/notes?sort=title,desc (title in desc order) 
	// or http://localhost:8080/notes?sort=content,desc&sort=title (first sorting content in desc and then title asc sort)
}