import java.util.Vector;

class Member{
    private Vector<Book> bookListVector;  

    public Member (String userID, String userName, String password, String email, int userRole, String fName, String lName){
        this.userID = userID;
        this.userName = userName;
        this.password = password;     
        this.email = email;
        this.userRole = userRole;
        name = new Name(fName,lName);
    }

    private borrowBook (String, Vector<Book> bookListVector){

    }

    private Vector<Book> getMemberBorrowedBook(){
        return bookListVector;
    }

    private viewBorrowedBook (Vector<Customer>, Vector<Book> ){

    }

    private void displayBorrowedBook(Vector<Book> bookListVector, int num){
        num = 0;
        for (Book book: bookListVector){
            System.out.println((num+1) + ": " + book);
        }
    }

    protected static viewMenu (int){

    }

}