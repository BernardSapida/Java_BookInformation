import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public int index = 0;
    public ArrayList<String[]> books = new ArrayList<String[]>();
    public String[] bookInformation = new String[5];
    public Book book = new Book("Dictionary for Library and Information Science", 9781591, "Joan M. Reitz", "Libraries Unlimited", "March 27, 2004");

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.startProgram();
    }

    public void startProgram() {
        readBookInformation();
        System.out.println("\n========================================================================\n");

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose an action:\n[1] Display all books...\n[2] Display book after year of...\n[3] Display author's book\n[4] Add new book\n[5] Exit program\nEnter your choice: ");
            String choice = sc.nextLine();
            
            switch(choice) {
                case "1":
                    displayAllBooks();
                    break;
                case "2":
                    displayBooksAfterYear(queryBookAfterYear());
                    break;
                case "3":
                    displayAuthorBook(queryAuthorName());
                    break;
                case "4":
                    queryNewBook();
                    break;
                case "5":
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Your input is invalid! Please try again.");
                    System.out.println("\n========================================================================\n");
                    break;
            }
        }
    }

    public void readBookInformation() {
        try {
            File myObj = new File("BookInformation.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(index <= 4) bookInformation[index] = data;

                if(index == 4) {
                    if(myReader.hasNextLine()) data = myReader.nextLine();
                    books.add(bookInformation);
                    bookInformation = new String[5];
                    index = 0;
                }
                else index++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void displayAllBooks() {
        System.out.println("\n========================================================================");
        System.out.println("=                             LIST OF BOOKS                            =");
        System.out.println("========================================================================\n");

        for (int i = 0; i < books.size(); i++) {
            if(i != 0) System.out.println("\n========================================================================\n");
            System.out.println(books.get(i)[0]);
            System.out.println(books.get(i)[1]);
            System.out.println(books.get(i)[2]);
            System.out.println(books.get(i)[3]);
            System.out.println(books.get(i)[4]);
        }
        System.out.println("\n========================================================================\n");
    }

    public void displayBooksAfterYear(int year) {
        boolean isFound = false;

        System.out.println("\n========================================================================");
        System.out.println("=                        LIST OF BOOKS YEAR " + year + "                       =");
        System.out.println("========================================================================\n");

        for (int i = 0; i < books.size(); i++) {
            if(Integer.parseInt(books.get(i)[4].split(" ")[2]) > year) {
                if(i != 0) System.out.println("\n========================================================================\n");
                System.out.println(books.get(i)[0]);
                System.out.println(books.get(i)[1]);
                System.out.println(books.get(i)[2]);
                System.out.println(books.get(i)[3]);
                System.out.println(books.get(i)[4]);

                isFound = true;
            }
        }

        if(!isFound) {
            System.out.println("\n========================================================================\n");
            System.out.println("No books found after year " + year);
            System.out.println("\n========================================================================\n");
        } else System.out.println("\n========================================================================\n");
    }

    public void displayAuthorBook(String author) {
        boolean isFound = false;

        System.out.println("\n========================================================================");
        System.out.println("=                          LIST OF AUTHOR BOOK                         =");
        System.out.println("========================================================================\n");

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i)[2].equals(author)) {
                if(i != 0) System.out.println("\n========================================================================\n");
                System.out.println(books.get(i)[0]);
                System.out.println(books.get(i)[1]);
                System.out.println(books.get(i)[2]);
                System.out.println(books.get(i)[3]);
                System.out.println(books.get(i)[4]);

                isFound = true;
            }
        }

        if(!isFound) {
            System.out.println("\n========================================================================\n");
            System.out.println("The author didn't exist!");
            System.out.println("\n========================================================================\n");
        } else System.out.println("\n========================================================================\n");
    }

    public void addNewBook(String title, int isbn, String author, String publisher, String date) {
        bookInformation = new String[5];
        bookInformation[0] = title;
        bookInformation[1] = String.valueOf(isbn);
        bookInformation[2] = author;
        bookInformation[3] = publisher;
        bookInformation[4] = date;
        books.add(bookInformation);

        try {
            FileWriter myWriter = new FileWriter("BookInformation.txt");
            for (int i = 0; i < books.size(); i++) {
                myWriter.write(books.get(i)[0] + "\n" + books.get(i)[1] + "\n" + books.get(i)[2] + "\n" + books.get(i)[3] + "\n" + books.get(i)[4] + "\n\n");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int queryBookAfterYear() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter year: ");
            int year = sc.nextInt();
            return year;
        } catch(Exception e) {
            System.out.println("The year is invalid!");
            System.out.println("\n========================================================================\n");
        }

        return queryBookAfterYear();
    }

    public String queryAuthorName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter author's name: ");
        String authorName = sc.nextLine();
        return authorName;
    }

    public void queryNewBook() {
        System.out.println("\n========================================================================\n");

        addNewBook(book.getBook_Name(), book.getISBN(), book.getAuthor(), book.getPublisher(), book.getDate());
        System.out.println("\n========================================================================\n");
        System.out.println("New book successfully added!");
        System.out.println("\n========================================================================\n");
    }
}