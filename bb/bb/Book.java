public class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
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

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book '" + title + "' has been issued.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    // Issue a book without printing a message (for file loading)
    public void issueBookWithoutMessage() {
        isIssued = true;
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book '" + title + "' has been returned.");
        } else {
            System.out.println("This book was not issued.");
        }
    }
}
