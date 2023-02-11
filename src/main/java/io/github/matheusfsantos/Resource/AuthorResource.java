package io.github.matheusfsantos.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.matheusfsantos.Entity.Author;
import io.github.matheusfsantos.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorResource {
	
	@Autowired
	private AuthorService authorService;

	//post get get put delete

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> post(@RequestBody Author author){
		author = authorService.post(author);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(author.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> get(){
		return ResponseEntity.ok().body(authorService.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Author> get(Integer id){
		return ResponseEntity.ok().body(authorService.get(id));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> put(@RequestBody Author author, @PathVariable Integer id){
		author.setId(id);
		author = authorService.put(author);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		authorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}