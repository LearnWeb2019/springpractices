package com.app.books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServices {
	
	@Autowired
	private BooksRepository bookRepository;
	
	private List<Books> books = new ArrayList<>(Arrays.asList(
			new Books("T001", "JAVA Gita", 300),
			new Books("T002", "Spring For All", 499),
			new Books("T003", "Hibernates", 269),
			new Books("T111", "Craking Coding", 457),
			new Books("T201", "Code Hackers", 699),
			new Books("T143", "Hello World!..", 199)
			));
	
		
	/*
	 * Get All
	 */
	public List<Books> getAll() {
		//return books; /* Returns hard coding values */
		
		bookRepository.saveAll(books);
		
		List<Books> books = new ArrayList<>();
		bookRepository.findAll()
		.forEach(books::add);
		return books;
		
		
	}
	
	/*
	 * get book
	 */
	public Optional<Books> get(String id) {
		
		//return books.stream().filter(b -> b.getBid().equals(id)).findFirst().get();
		return bookRepository.findById(id);
	}
	
	/*
	 * add book
	 */
	public void add(Books book) {
		//books.add(book);
		bookRepository.save(book);
	}
	
	
	/*
	 * update book
	 */
	public void update(Books book, String id)
	{
		/*for(int i=0; i<books.size(); i++)
		{
			Books b = books.get(i);
			if(b.getBid().equals(id))
			{
				books.set(i, book);
			}
		}*/
		
		bookRepository.save(book);
		
	}
	
	/*
	 * delete book
	 */
	public void delete(String id)
	{
		//books.removeIf(b-> b.getBid().equals(id));
		bookRepository.deleteById(id);
	}

}
