package pkg_main;

import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transactions.BookTransactionManager;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("All")
public class Main {

    private static boolean authenticateLibrarian(Scanner sc) {
        final String LIBRARIAN_PASSWORD = "Ak@90";
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter librarian password: ");
            String inputPassword = sc.next();

            if (inputPassword.equals(LIBRARIAN_PASSWORD)) {
                return true;
            } else {
                attempts--;
                System.out.println("Incorrect password. " + attempts + " attempts remaining.");
            }
        }

        System.out.println("Too many failed attempts. Access denied.");
        return false;
    }

    public static void main(String[] args) throws StudentNotFoundException, IOException {
        int choice;
        System.out.println("__--__Welcome to Coder Sena Library__--__");
        Scanner sc = new Scanner(System.in);

        BookManager bm = new BookManager();
        StudentManager sm = new StudentManager();
        BookTransactionManager btm = new BookTransactionManager();

        do {
            System.out.println("\n Enter 1. If Student \n Enter 2. If Librarian \n Enter 3. Save & Exit Here");
            System.out.print("Enter Your choice:  ");
            choice = sc.nextInt();

            if (choice == 1) { // If User is Student!
                System.out.println("Enter Your Roll Number: ");
                int rollno = sc.nextInt();
                try {
                    Student s = sm.get(rollno);
                    if (s == null)
                        throw new StudentNotFoundException();
                    int stud_choice;
                    do {
                        System.out.println("\n Enter 1. to view all Books. \n Enter 2. to Search Book by ISBN. \n Enter 3. to List Books by Subject. \n Enter 4. to Issue a Book. \n Enter 5. to Return a Book. \n Enter 6. to Exit");
                        System.out.print("Enter Your choice: ");
                        stud_choice = sc.nextInt();
                        switch(stud_choice){
                            case 1:
                                System.out.println("Available Books");
                                bm.viewAllBooks();
                                break;

                            case 2:
                                System.out.println("Enter The Book's ISBN to Search: ");
                                int search_isbn = sc.nextInt();
                                Book book = bm.searchBookByIsbn(search_isbn);
                                if (book == null)
                                    System.out.println("No Books Found in The Library");
                                else
                                    System.out.println(book);
                                break;

                            case 3:
                                System.out.print("Enter the Subject to search: ");
                                sc.nextLine();
                                String search_subject = sc.nextLine();
                                bm.listBooksBySubject(search_subject);
                                break;

                            case 4:
                                System.out.print("Enter The Book's ISBN for Issue: ");
                                int issue_isbn = sc.nextInt();
                                book = bm.searchBookByIsbn(issue_isbn);
                                try {
                                    if (book == null) {
                                        throw new BookNotFoundException();
                                    }

                                    if (book.getAvailable_quantity() > 0) {
                                        if (btm.issueBook(rollno, issue_isbn)) {
                                            book.setAvailable_quantity(book.getAvailable_quantity() - 1);
                                            System.out.println("Book Has Issued Successfully.");
                                        }
                                    }
                                    else {
                                        System.out.println("This Book Has Been Already Issued.");
                                    }
                                }
                                catch (BookNotFoundException bnfe) {
                                    System.out.println(bnfe);
                                }
                                break;

                            case 5:
                                System.out.print("Enter The Book's ISBN to Return :");
                                int return_isbn = sc.nextInt();
                                book = bm.searchBookByIsbn(return_isbn);
                                if (book != null) {
                                    if (btm.returnBook(rollno, return_isbn)) {
                                        book.setAvailable_quantity(book.getAvailable_quantity() + 1);
                                        System.out.println("Book Return Successfull.");
                                    }
                                    else
                                        System.out.println("You Don't Have Any Book Issued Of This ISBN.");
                                }
                                else
                                    System.out.println("The Book's ISBN Doesn't Exists.");
                                break;

                            case 6:
                                System.out.println("Thank You For Using Our Library.");
                                break;

                            default:
                                System.out.println("Invalid Choice.");
                                break;

                        }
                    } while (stud_choice != 6);
                } catch (StudentNotFoundException snfe) {
                    System.out.println(snfe);
                }
            } else if (choice == 2) {  // If the User is Librarian!
                if (!authenticateLibrarian(sc)) {
                    continue;
                }

                int lib_choice;

                do {
                    System.out.println("\n Enter 11. to View All Students. \n Enter 12. to Print Student by Roll Number. \n Enter 13. to Register a New Student. \n Enter 14. to Update Student Information. \n Enter 15. to Delete a Student.");
                    System.out.println("\n Enter 21. to View All Books. \n Enter 22. to Print Book by ISBN. \n Enter 23. to Add a New Book. \n Enter 24. to Update Book Information. \n Enter 25. to Delete a Book.");
                    System.out.println("\n Enter 31. to View All Transactions.");
                    System.out.println("\n Enter 99. to Exit");
                    System.out.print("\n Enter Your choice: ");
                    lib_choice = sc.nextInt();
                    switch(lib_choice){
                        case 11: // View All Students....
                            System.out.println("All the Students Records.");
                            sm.viewAllStudents();
                            sc.nextLine();
                            break;
                        case 12: // Roll Number based Student Searching....
                            System.out.print("Enter Roll Number to get Student Details: ");
                            int get_rollNo = sc.nextInt();
                            Student student = sm.get(get_rollNo);
                            if (student == null) {
                                System.out.println("No Student Found.");
                            }
                            else
                                System.out.println(student);
                            break;
                        case 13: // Adding New Student....
                            System.out.println("Enter Students Details to Add.");
                            String name;
                            String email_id;
                            String phone_number;
                            String address;
                            String date_of_birth;
                            int roll_no;
                            int std;
                            String division;
                            sc.nextLine();
                            System.out.println("Name: ");
                            name = sc.nextLine();
                            System.out.print("Email Id: ");
                            email_id = sc.nextLine();
                            System.out.print("Phone Number: ");
                            phone_number = sc.nextLine();
                            System.out.print("Address: ");
                            address = sc.nextLine();
                            System.out.print("Date Of Birth: ");
                            date_of_birth = sc.nextLine();
                            System.out.print("Roll Number: ");
                            roll_no = sc.nextInt();
                            System.out.print("Standard: ");
                            std = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Division: ");
                            division = sc.nextLine();

                            student = new Student(name, email_id, phone_number, address, date_of_birth, roll_no, std, division);
                            sm.addStudent(student);
                            System.out.println("Student Added Successfully.");
                            sm.writeTofile();
                            break;

                        case 14: // Update student details....
                            System.out.println("Enter The Student's Roll Number: ");
                            int modify_rollNo;
                            modify_rollNo = sc.nextInt();
                            student = sm.get(modify_rollNo);
                            try {
                                if (student == null)
                                    throw new StudentNotFoundException();
                                sc.nextLine();
                                System.out.print("Name: ");
                                name = sc.nextLine();
                                System.out.print("Email Id: ");
                                email_id = sc.nextLine();
                                System.out.print("Phone Number: ");
                                phone_number = sc.nextLine();
                                System.out.print("Address: ");
                                address = sc.nextLine();
                                System.out.print("Date Of Birth: ");
                                date_of_birth = sc.nextLine();
                                System.out.print("Standard: ");
                                std = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Division: ");
                                division = sc.nextLine();

                                sm.updateStudent(modify_rollNo, name, email_id, phone_number, address, date_of_birth, std, division);
                                System.out.println("Student's Record Updated Successfully.");
                                sm.writeTofile();
                                break;
                            }
                            catch (StudentNotFoundException snfe){
                                System.out.println(snfe);
                            }

                        case 15:  // to Delete Student details....
                            System.out.print("Enter The Student's Roll Number: ");
                            int delete_rollNo;
                            delete_rollNo = sc.nextInt();
                            if (sm.deleteStudent(delete_rollNo))
                                System.out.println("Student Record is Successfully Deleted");
                            else
                                System.out.println("No Record Found Related to this Roll Number");
                            break;

                        case 21: // View All Books....
                            System.out.println("All The Book Record.");
                            bm.viewAllBooks();
                            break;
                        case 22: // Search Book By ISBN
                            int search_isbn;
                            System.out.print("Enter The Book's ISBN to Search: ");
                            search_isbn = sc.nextInt();
                            Book book = bm.searchBookByIsbn(search_isbn);
                            if (book == null)
                                System.out.println("No Books Found in The Library");
                            else
                                System.out.println(book);
                            break;

                        case 23: // Add New Book Into Library
                            System.out.println("Please Enter the Book's Details Here");
                            int isbn;
                            String title;
                            String author;
                            String publisher;
                            int edition;
                            String subject;
                            int available_quantity;

                            System.out.print("ISBN: ");
                            isbn = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Book's Title: ");
                            title = sc.nextLine();
                            System.out.print("Book's Author Name: ");
                            author = sc.nextLine();
                            System.out.print("Book's Publisher: ");
                            publisher = sc.nextLine();
                            System.out.print("Book's Edition: ");
                            edition = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Book's Subject: ");
                            subject = sc.nextLine();
                            System.out.print("Book's Available Quantity: ");
                            available_quantity = sc.nextInt();
                            sc.nextLine();

                            book = new Book(isbn, title, author, publisher, edition, subject, available_quantity);
                            bm.addABook(book);
                            System.out.println("Book Added Successfully");
                            bm.writeTofile();
                            break;

                        case 24: // Update Book Record.....
                            System.out.print("Please Enter The ISNB to Update: ");
                            int update_isbn;
                            update_isbn = sc.nextInt();
                            try {
                                book = bm.searchBookByIsbn(update_isbn);
                                if (book == null)
                                    throw new BookNotFoundException();
                                System.out.print("Enter The Book's Details to Update: ");
                                sc.nextLine();

                                System.out.print("Book's Title: ");
                                title = sc.nextLine();
                                System.out.print("Book's Author Name: ");
                                author = sc.nextLine();
                                System.out.print("Book's Publisher: ");
                                publisher = sc.nextLine();
                                System.out.print("Book's Edition: ");
                                edition = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Book's Subject: ");
                                subject = sc.nextLine();
                                System.out.print("Book's Avauilable Quantity: ");
                                available_quantity = sc.nextInt();
                                sc.nextLine();
                                bm.updateBook(update_isbn,title, author, publisher, edition, subject, available_quantity);
                                System.out.println("Book's Details Successfully Updated");
                                bm.writeTofile();
                            }
                            catch (BookNotFoundException bnfe) {
                                System.out.println(bnfe);
                            }
                            break;

                        case 25: // to Delete Book Details....
                            System.out.print("Please Enter The ISBN to Delete The Book: ");
                            int delete_isbn;
                            delete_isbn = sc.nextInt();
                            try {
                                book = bm.searchBookByIsbn(delete_isbn);
                                if (book == null)
                                    throw new BookNotFoundException();
                                bm.deleteBook(delete_isbn);
                                System.out.println("Book Records is successfully Deleted");
                            }
                            catch (BookNotFoundException bnfe) {
                                System.out.println(bnfe);
                            }
                            break;

                        case 31: // View All Books Transactions like Which Book which Book Which student Obtained....
                            System.out.println("All The Books Transactions Are Here");
                            btm.showAll();

                        case 99:
                            System.out.println("Thank You For Using Our Library.");
                            break;
                        default:
                            System.out.println("Invalid Choice.!");
                            break;
                    }
                } while (lib_choice != 99);
            }
        } while (choice != 3);
        sm.writeTofile();
        bm.writeTofile();
        btm.writeTofile();
        sc.close();
    }
}