package io.github.matheusfsantos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.Entity.Comment;
import io.github.matheusfsantos.Repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	
	public List<Comment> get(){
		return commentRepository.findAll();
	}
	
	public Comment get(Integer id) {
		Optional<Comment> comment = commentRepository.findById(id);
		return comment.orElse(null);
	}
	
	public Comment post(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public void delete(Integer id) {
		if(get(id) != null)
			commentRepository.deleteById(id);
		else
			throw new Error("Comment not found");
	}
	
	public Comment put(Comment comment) {
		Comment newComment = get(comment.getId());
		modify(newComment, comment);
		return commentRepository.save(newComment);
	}

	private void modify(Comment newComment, Comment comment) {
		newComment.setAuthor(comment.getAuthor());
		newComment.setPost(comment.getPost());
		newComment.setText(comment.getText());
	}
}