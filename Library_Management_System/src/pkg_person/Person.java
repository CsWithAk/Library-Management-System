//2nd class create

package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
abstract public class Person implements Serializable {
    protected String name;
    protected String email_id;
    protected String phone_number;
    protected String address;
    protected String date_of_birth;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        boolean isValidName = Pattern.matches("[a-zA-z]+", name);
        if (isValidName)
            this.name = name;
        else
            this.name = "default name";
        this.name = name;
    }
    public String getEmail_id() {
        return email_id;
    }
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        boolean isValid_phone_number = Pattern.matches("\\d{10}", phone_number);
        if (isValid_phone_number)
            this.phone_number = phone_number;
        else
            this.phone_number = phone_number;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(String date_of_birth) {
        boolean isValid_date_of_birth = Pattern.matches("\\d{2}/\\d{2}/\\d{4}", date_of_birth);
        if (isValid_date_of_birth)
            this.date_of_birth = date_of_birth;
        else
            this.date_of_birth = "00/00/0000";
    }
    public Person(String name, String email_id, String phone_number, String address, String date_of_birth) {
        this.setName(name);
        this.email_id = email_id;
        this.setPhone_number(phone_number);
        this.address = address;
        this.setDate_of_birth(date_of_birth);
    }

    public Person() {
        super();
    }

}
