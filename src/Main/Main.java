package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Book.Book;
import Student.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Student> loadStudentsFromFile(String path) {
        List<Student> result = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(";");
                String name = parts[0];
                
                List<Book> books = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    String[] bookData = parts[i].split(",");
                    String title = bookData[0];
                    int year = Integer.parseInt(bookData[1].trim());
                    int pages = Integer.parseInt(bookData[2].trim());
                    books.add(new Book(title, year, pages));
                }
                result.add(new Student(name, books));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return result;
    }
}
