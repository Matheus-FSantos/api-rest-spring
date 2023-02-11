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

import io.github.matheusfsantos.Entity.Comment;
import io.github.matheusfsantos.Service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentResource {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> post(@RequestBody Comment comment){
		comment = commentService.post(comment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> get(){
		return ResponseEntity.ok().body(commentService.get()); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Comment> get(@PathVariable Integer id){
		return ResponseEntity.ok().body(commentService.get(id));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> put(@RequestBody Comment comment, @PathVariable Integer id){
		comment.setId(id);
		comment = commentService.put(comment);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		commentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}