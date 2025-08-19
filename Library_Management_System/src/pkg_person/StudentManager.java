// 6th class create

package pkg_person;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

@SuppressWarnings("Unchacked")
//@SuppressWarnings("ALL")
public class StudentManager {
    ObjectOutputStream oos_student = null;
    ObjectInputStream ois_student = null;

    File student_file = null;

    ArrayList<Student> student_list = null;

    public StudentManager() throws IOException {
        student_file = new File("Student.dat");
        student_list = new ArrayList<Student>();

        if (student_file.exists()) {
            try {
                ois_student = new ObjectInputStream(new FileInputStream(student_file));
                student_list = (ArrayList<Student>) ois_student.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void addStudent(Student student) {
        student_list.add(student);
    }
    public Student get(int rollNo) {
        for(Student student:student_list) {
            if (student.getRoll_no() == rollNo)
                return student;
        }
        return null;
    }
    public void viewAllStudents() {
        for (Student student:student_list)
            System.out.println(student);
    }
    public boolean deleteStudent (int delete_rollNo) {
        ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
        while (student_iterator.hasNext()) {
            Student student = student_iterator.next();
            if (student.getRoll_no() == delete_rollNo) {
                student_list.remove(student);
                return true;
            }
        }
        return false;
    }
    public boolean updateStudent (int update_rollNo, String name, String email_id, String phone_number, String address, String date_of_birth, int std, String division) {
        ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
        while (student_iterator.hasNext()) {
            Student student = student_iterator.next();
            if (student.getRoll_no() == update_rollNo) {
                student.setAddress(address);
                student.setDivision(division);
                student.setDate_of_birth(date_of_birth);
                student.setEmail_id(email_id);
                student.setName(name);
                student.setPhone_number(phone_number);
                student.setStd(std);
                return true;
            }
        }
        return false;
    }
    public void writeTofile() {
        try {
            oos_student = new ObjectOutputStream(new FileOutputStream(student_file));
            oos_student.writeObject(student_list);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

















