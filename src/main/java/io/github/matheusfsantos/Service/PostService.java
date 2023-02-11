package io.github.matheusfsantos.Service;

import java.util.List;
import java.util.Optional;

import io.github.matheusfsantos.Entity.Post;
import io.github.matheusfsantos.Repository.PostRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> get(){
		return postRepository.findAll();
	}
	
	public Post get(Integer id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElse(null);
	}
	
	public Post post(Post post) {
		return postRepository.save(post);
	}
	
	public void delete(Integer id) {
		if(get(id) != null)
			postRepository.deleteById(id);
		else
			throw new Error("Post not found");
	}
	
	public Post put(Post post) {
		Post newPost = get(post.getId());
		modify(newPost, post);
		return postRepository.save(newPost);
	}
	
	public void modify(Post newPost, Post post) {
		newPost.setAuthor(post.getAuthor());
		newPost.setComments(post.getComments());
		newPost.setText(post.getText());
		newPost.setTitle(post.getTitle());
	}
}