import java.util.ArrayList;
import java.util.Scanner;

class LibraryManagementSystem {
    // Book class
    static class Book {
        private String id;
        private String title;
        private String author;
        private boolean isIssued;

        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isIssued() {
            return isIssued;
        }

        public void setIssued(boolean isIssued) {
            this.isIssued = isIssued;
        }

        @Override
        public String toString() {
            return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
        }
    }

    // Member class
    static class Member {
        private String id;
        private String name;

        public Member(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Member ID: " + id + ", Name: " + name;
        }
    }

    // Main class for Library Management System
    static class Library {
        private ArrayList<Book> books;
        private ArrayList<Member> members;

        public Library() {
            books = new ArrayList<>();
            members = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: " + book);
        }

        public void addMember(Member member) {
            members.add(member);
            System.out.println("Member added: " + member);
        }

        public void issueBook(String bookId, String memberId) {
            Book book = findBook(bookId);
            if (book != null && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued to member ID: " + memberId);
            } else {
                System.out.println("Book not available or already issued.");
            }
        }

        public void returnBook(String bookId) {
            Book book = findBook(bookId);
            if (book != null && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned.");
            } else {
                System.out.println("Book not issued or invalid book ID.");
            }
        }

        public void displayBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        public void displayMembers() {
            for (Member member : members) {
                System.out.println(member);
            }
        }

        private Book findBook(String bookId) {
            for (Book book : books) {
                if (book.getId().equals(bookId)) {
                    return book;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    library.addBook(new Book(bookId, bookTitle, bookAuthor));
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(new Member(memberId, memberName));
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMemberId = scanner.nextLine();
                    library.issueBook(issueBookId, issueMemberId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    library.returnBook(returnBookId);
                    break;
                case 5:
                    System.out.println("Books in Library:");
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Library Members:");
                    library.displayMembers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
