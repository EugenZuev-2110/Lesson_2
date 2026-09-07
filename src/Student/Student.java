package Student;

import java.util.List;

import Book.Book;

public class Student {
	private String name;
	private List<Book> books; 

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() { return name; }
    public List<Book> getBooks() { return books; }
    
    public void PrintStudentInfo() 
    {
        System.out.println("Студент: " + name + " (Количество книг: " + books.size() + ")");
    }
}
