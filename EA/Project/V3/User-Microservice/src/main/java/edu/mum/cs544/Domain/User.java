package  edu.mum.cs544.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String penName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String sex;
    @Lob
    private String biography;

    // Address related attributes
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;

    // Account Related attributes
  //  @JsonIgnore
    private String username;
   // @JsonIgnore
    private String password;
    private String role;
    private boolean status;
    private String note;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    // user may be interested on many topics
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Interest> interest;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String penName, Date dob, String sex, String biography,
        String city, String state, String country, String phone, String email, String username, String password,
        String role, boolean status, String note, Date createdOn, List<Interest> interest) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.penName = penName;
      this.dob = dob;
      this.sex = sex;
      this.biography = biography;
      this.city = city;
      this.state = state;
      this.country = country;
      this.phone = phone;
      this.email = email;
      this.username = username;
      this.password = password;
      this.role = role;
      this.status = status;
      this.note = note;
      this.createdOn = createdOn;
      this.interest = interest;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getPenName() {
      return penName;
    }

    public void setPenName(String penName) {
      this.penName = penName;
    }

    public Date getDob() {
      return dob;
    }

    public void setDob(Date dob) {
      this.dob = dob;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }

    public String getBiography() {
      return biography;
    }

    public void setBiography(String biography) {
      this.biography = biography;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getRole() {
      return role;
    }

    public void setRole(String role) {
      this.role = role;
    }

    public boolean isStatus() {
      return status;
    }

    public void setStatus(boolean status) {
      this.status = status;
    }

    public String getNote() {
      return note;
    }

    public void setNote(String note) {
      this.note = note;
    }

    public Date getCreatedOn() {
      return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
      this.createdOn = createdOn;
    }

    public List<Interest> getInterest() {
      return interest;
    }

    public void setInterest(List<Interest> interest) {
      this.interest = interest;
    }

    
}
