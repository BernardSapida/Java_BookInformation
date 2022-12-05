public class Book {
    private String Book_Name;
    private int ISBN;
    private String Author;
    private String Publisher;
    private String Date;
    
    public Book(String book_Name, int iSBN, String author, String publisher, String date) {
        this.Book_Name = book_Name;
        this.ISBN = iSBN;
        this.Author = author;
        this.Publisher = publisher;
        this.Date = date;
    }
    
    @Override
    public String toString() {
        return "Book = [" + Book_Name + ", ISBN = " + ISBN + ", Author = " + Author + ", Publisher = " + Publisher
                + ", Date = " + Date + "]";
    }
    
    public String getBook_Name() {
        return Book_Name;
    }
    
    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }
    
    public int getISBN() {
        return ISBN;
    }
    
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }
    
    public String getAuthor() {
        return Author;
    }
    
    public void setAuthor(String author) {
        Author = author;
    }
    
    public String getPublisher() {
        return Publisher;
    }
    
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }
    
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}