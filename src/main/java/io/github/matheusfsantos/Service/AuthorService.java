package io.github.matheusfsantos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.Entity.Author;
import io.github.matheusfsantos.Repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> get() {
		return authorRepository.findAll();
	}
	
	public Author get(Integer id) {
		Optional<Author> author = authorRepository.findById(id);
		return author.orElse(null);
	
	}
	
	public Author post(Author author) {
		return authorRepository.save(author);
	}
	
	public void delete(Integer id) {
		if(get(id) != null)
			authorRepository.deleteById(id);
		else 
			throw new Error("Author not found");
	}
	
	public Author put(Author author) {	
		Author newAuthor = get(author.getId());
		modify(newAuthor, author);
		return authorRepository.save(newAuthor);
	}
	
	private void modify(Author newAuthor, Author author) {
		newAuthor.setName(author.getName());
		newAuthor.setDescription(author.getDescription());
	}
}