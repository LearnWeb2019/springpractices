package com.app.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@Autowired
	private BooksServices bookServices;
	
	/*
	 * Home page get all book list
	 */
	@RequestMapping("/")
	public List<Books> home() {
		return bookServices.getAll();
	}
	
	/*
	 * Error Page
	 */
	@RequestMapping("/*")
	public String error() {
		return "No page found 404";
	}
	
	/*
	 * get specific book
	 */
	@RequestMapping("/book/{id}")
	public Optional<Books> getBook(@PathVariable String id) {
		return bookServices.get(id);
	}
	
	/*
	 * Add Book
	 */
	@RequestMapping(method=RequestMethod.POST, value="/book")
	public void addBook(@RequestBody Books book) {
		bookServices.add(book);
	}
	
	
	/*
	 * Update Book
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/book/{id}")
	public void updateBook(@RequestBody Books book, @PathVariable String id)
	{
		bookServices.update(book, id);
	}
	
	
	/*
	 * delete book
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/book/{id}")
	public void deleteBook(@PathVariable String id)
	{
		bookServices.delete(id);
	}
}


