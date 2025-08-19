// 3rd class create

package pkg_person;

@SuppressWarnings("ALL")
public class Librarian extends Person {
    private int id;
    private String date_of_join;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate_of_join() {
        return date_of_join;
    }
    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", date_of_join='" + date_of_join + '\'' +
                ", name='" + name + '\'' +
                ", email_id='" + email_id + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
    public Librarian(String name, String email_id, String phone_number, String address, String date_of_birth, int id, String date_of_join) {
        super(name, email_id, phone_number, address, date_of_birth);
        this.id = id;
        this.date_of_join = date_of_join;
    }
    public Librarian() {
        super();
    }
}
