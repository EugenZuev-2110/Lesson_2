package Book;

public class Book {
	private String title;
    private int year;
    private int pages;

    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getPages() { return pages; }
}
