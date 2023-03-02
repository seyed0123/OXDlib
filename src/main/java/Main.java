import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */
    static Library lib = new Library();
    public static void main(String[] args)
    {
        lib.addLibrarian("arshia","mamamia");
        login();
    }
    public static void login()
    {
        int res = 0;
        String name;
        while (true) {
            name = JOptionPane.showInputDialog("Enter the your username");
            String password = JOptionPane.showInputDialog("Enter the new password");
            if((name==null || password==null))
                System.exit(0);
            res = lib.login(name, password);
            if ((Math.abs(res)) == 2) {
                break;
            } else
                JOptionPane.showMessageDialog(null, "the username or the password is wrong.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if(res==2) {
            while (true)
                if (userMenu(name))
                    break;
        }
        else
            while (true)
                if (librarianMenu())
                    break;
    }
    static String userinput()
    {
        return JOptionPane.showInputDialog("1-change password\n2-rent book\n3-return book\n4-borrow book list\n5-log out");
    }
    static boolean userMenu(String username)
    {
        String command = userinput();
        if(Objects.equals(command, "1"))
        {
            String oldPassword = JOptionPane.showInputDialog("Enter the old password");
            String password = JOptionPane.showInputDialog("Enter the new password");
            lib.updateUser(username, oldPassword , password);
        }else if (Objects.equals(command, "2"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            lib.rentBook(username,ISBN);
        }else if (Objects.equals(command, "3"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            lib.returnBook(username , ISBN);
        }else if (Objects.equals(command, "4"))
        {
            lib.searchUser(username);
        }else if (Objects.equals(command, "5"))
        {
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, "Was machst du bro?.");
        }
        return false;
    }
    static String librarianInput()
    {
        return JOptionPane.showInputDialog("1-add book\n2-remove book\n3-search Book\n4-update Book\n6-increase Book\n7-decrease Book\n8-addUser\n9-removeUser\n10-searchUser\n11-updateUser\n12-addLibrarian\n13-removeLibrarian\n14-searchLibrarian\n15-updateLibrarian\n16-logout");
    }
    static boolean librarianMenu()
    {
        String commend = librarianInput();
        if(Objects.equals(commend, "1"))
        {
            String name = JOptionPane.showInputDialog("Enter the book name");
            String author =JOptionPane.showInputDialog("Enter the book author");
            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the book year (Write numerically)"));
            int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the book initial value (Write numerically)"));
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            lib.addBook(name,author ,year , num ,ISBN);
        }else if(Objects.equals(commend, "2"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            lib.removeBook(ISBN);
        }else if (Objects.equals(commend, "3"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            lib.searchBook(ISBN);
        }else if (Objects.equals(commend, "4"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the book year (Write numerically)"));
            lib.updateBook(ISBN,year);
        }else if(Objects.equals(commend, "5"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of books added (Write numerically)"));
            lib.increaseBook(ISBN, num);
        }else if(Objects.equals(commend, "6"))
        {
            int ISBN = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ISBN book code (Write numerically)"));
            int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of books removed (Write numerically)"));
            lib.decreaseBook(ISBN,num);
        }else if (Objects.equals(commend, "7"))
        {
            String name = JOptionPane.showInputDialog("Enter the username");
            String password =JOptionPane.showInputDialog("Enter the password");
            lib.addUser(name , password);
        }else if (Objects.equals(commend, "8"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            lib.removeUser(name);
        }else if (Objects.equals(commend, "9"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            lib.searchUser(name);
        }else if(Objects.equals(commend, "10"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            String oldPassword = JOptionPane.showInputDialog("Enter the old password");
            String password = JOptionPane.showInputDialog("Enter the new password");
            lib.updateUser(name , oldPassword, password);
        }else if (Objects.equals(commend, "11"))
        {
            String name = JOptionPane.showInputDialog("Enter the username");
            String password =JOptionPane.showInputDialog("Enter the password");
            lib.addLibrarian(name , password);
        }else if (Objects.equals(commend, "12"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            lib.removeLibrarian(name);
        }else if (Objects.equals(commend, "13"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            lib.searchLibrarian(name);
        }else if (Objects.equals(commend, "14"))
        {
            String name = JOptionPane.showInputDialog("Enter the user name");
            String oldPassword = JOptionPane.showInputDialog("Enter the old password");
            String password = JOptionPane.showInputDialog("Enter the new password");
            lib.updateLibrarian(name , oldPassword, password);
        }else if (commend=="16")
        {
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, "Was machst du bro?.");
        }
        return false;
    }

}
