import javax.swing.*;
import java.util.HashMap;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */
    private HashMap <String, Book> books;
    private HashMap <String , User> users;
    public Library()
    {
        books = new HashMap<>();
        users = new HashMap<>();
    }
    //book related functions
    public void addBook(){
       String name = JOptionPane.showInputDialog("Enter the book name");
       String author =JOptionPane.showInputDialog("Enter the book author");
       int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the book year (Write numerically)"));
       int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the book initial value (Write numerically)"));
       Book book = new Book(name , author , year ,num);
       books.put(name , book);
    }

    public void removeBook(){
        String name = JOptionPane.showInputDialog("Enter the book name");
        if(doesBookExist(name))
            books.remove(name);
        else
            JOptionPane.showMessageDialog(null,"this book doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void searchBook(){
        String name = JOptionPane.showInputDialog("Enter the book name");
        int num =0;
        if(doesBookExist(name))
            num = books.get(name).getNum();
        JOptionPane.showMessageDialog(null,"here are "+ num + name+" book in the library");
    }

    public void updateBook(){
        String name = JOptionPane.showInputDialog("Enter the book name");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the book year (Write numerically)"));
        if(doesBookExist(name))
            books.get(name).updateBook(year);
        else
            JOptionPane.showMessageDialog(null,"this book doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public boolean doesBookExist(String name){
        return books.containsKey(name);
    }

    public void increaseBook(){
        String name = JOptionPane.showInputDialog("Enter the book name");
        int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of books added (Write numerically)"));
        if(doesBookExist(name)) {
            books.get(name).increaseBook(num);
            JOptionPane.showMessageDialog(null, "done\nnow we have " + books.get(name).getNum() + name + "book in the library");
        }
        else
            JOptionPane.showMessageDialog(null,"this book doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void decreaseBook(){
        String name = JOptionPane.showInputDialog("Enter the book name");
        int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of books removed (Write numerically)"));
        if(doesBookExist(name)) {
            if(books.get(name).decreaseBook(num))
                JOptionPane.showMessageDialog(null, "done\nnow we have " + books.get(name).getNum() + name + "book in the library");
            else
                JOptionPane.showMessageDialog(null, "oops\nwe only have " + books.get(name).getNum() + name + "book in the library","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"this book doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    //user related functions

    public void addUser(){
        String name = JOptionPane.showInputDialog("Enter the your username");
        String password =JOptionPane.showInputDialog("Enter the your password");
        if(doesUserExist(name)) {
            JOptionPane.showMessageDialog(null, "this username already in use.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        User user = new User(name, password);
        users.put(name , user);
    }

    public void removeUser(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        if(doesUserExist(name))
            users.remove(name);
        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void searchUser(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        if(doesUserExist(name))
            users.get(name).getBooks();

        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void updateUser(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        String oldPassword = JOptionPane.showInputDialog("Enter the old password");
        String password = JOptionPane.showInputDialog("Enter the new password");
        if(doesUserExist(name)) {
            users.get(name).setPassword(password , oldPassword);
            JOptionPane.showMessageDialog(null, "done\nyour password changed.");
        }
        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public boolean doesUserExist(String name ){
        return users.containsKey(name);
    }

    //librarian related functions

    public void addLibrarian(){
        String name = JOptionPane.showInputDialog("Enter the your username");
        String password =JOptionPane.showInputDialog("Enter the your password");
        if(doesUserExist(name)) {
            JOptionPane.showMessageDialog(null, "this username already in use.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Librarian user = new Librarian (name, password);
        users.put(name , user);
    }

    public void removeLibrarian(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        if(doesUserExist(name))
            users.remove(name);
        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void searchLibrarian(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        if(doesUserExist(name))
            users.get(name).getBooks();
        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public void updateLibrarian(){
        String name = JOptionPane.showInputDialog("Enter the user name");
        String oldPassword = JOptionPane.showInputDialog("Enter the old password");
        String password = JOptionPane.showInputDialog("Enter the new password");
        if(doesUserExist(name)) {
            users.get(name).setPassword(password , oldPassword);
            JOptionPane.showMessageDialog(null, "done\nyour password changed.");
        }
        else
            JOptionPane.showMessageDialog(null,"this user doesn't exist.","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
