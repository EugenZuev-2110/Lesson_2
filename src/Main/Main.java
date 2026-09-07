package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Book.Book;
import Student.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = "src/students.txt"; 

        List<Student> students = loadStudents(filePath);

        students.stream()
            .peek(Student::PrintStudentInfo)
            .flatMap(student -> student.getBooks().stream())
            .distinct()
            .filter(book -> book.getYear() > 2000)
            .sorted(Comparator.comparingInt(Book::getPages))
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .ifPresentOrElse(
                year -> System.out.println("Найден год выпуска книги: " + year),
                () -> System.out.println("Такая книга отсутствует")
            );
	}

	public static List<Student> loadStudents(String path) {
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
