package xyz.codingmentor.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Olivér
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "TEACHER.findByEmail",
            query = "SELECT t FROM Teacher t WHERE t.email=:email")
})
public class Teacher extends User implements Serializable {

    @OneToMany
    @JoinColumn(name = "Teacher_Id")
    private List<Course> courses = new ArrayList<>();
    @OneToMany
    private List<Test> tests = new ArrayList<>();

    public Teacher() {
        super();
    }
    
    public Teacher(User user){
        super(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
    }

    public Teacher(String firstName, String lastName, String password, String email) {
        super(firstName, lastName, password, email);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean changeAdmin() {
        setAdmin(!isAdmin());
        return true;
    }

}
