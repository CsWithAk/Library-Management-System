# 📚 Library Management System (Java)

A simple **Library Management System** built in **Java**, designed to manage books, students, and transactions in a library.  
This project demonstrates the use of **OOP concepts, exception handling, and file handling** in Java.

---

## 🗂️ Project Structure

Library_Management_System/
│── src/
│ ├── pkg_book/
│ │ ├── Book.java
│ │ ├── BookManager.java
│ │
│ ├── pkg_exception/
│ │ ├── BookNotFoundException.java
│ │ ├── StudentNotFoundException.java
│ │
│ ├── pkg_main/
│ │ ├── Main.java
│ │
│ ├── pkg_person/
│ │ ├── Librarian.java
│ │ ├── Person.java
│ │ ├── Student.java
│ │ ├── StudentManager.java
│ │
│ ├── pkg_transactions/
│ │ ├── BookTransaction.java
│ │ ├── BookTransactionManager.java
│
│── book_transaction.dat
│── Books.dat
│── Student.dat
│── .gitignore
│── Library_Management_System.iml



---

## 🚀 Features

### 👨‍🎓 Student Module
- View all available books  
- Search book by ISBN  
- List books by subject  
- Issue and return books  

### 👩‍💼 Librarian Module
- Authenticate librarian with password  
- Manage books (add/remove/update)  
- Manage students  
- Track issued/returned books  

### ⚠️ Exception Handling
- Custom exceptions for **Book Not Found** and **Student Not Found**  

### 💾 Data Persistence
- Data stored in `.dat` files (Books, Students, Transactions)  

---

## 🛠️ Technologies Used
- **Java (JDK 23)**  
- **OOP Principles** (Encapsulation, Inheritance, Polymorphism)  
- **Custom Exceptions**  
- **File Handling**  

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Library_Management_System.git
2. Open the project in IntelliJ IDEA / Eclipse / VS Code

3. Compile and run the Main.java file:
      javac src/pkg_main/Main.java
      java src/pkg_main/Main

   
🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
