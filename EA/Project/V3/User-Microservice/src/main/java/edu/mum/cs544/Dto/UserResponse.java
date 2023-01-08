package  edu.mum.cs544.Dto;

import  edu.mum.cs544.Domain.Interest;

import java.util.Date;
import java.util.List;

public class UserResponse {
    private String firstName;
    private String lastName;
    private String penName;
    private Date dob;
    private String sex;
    private String biography;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
    //private String username;
    private String role;
    private boolean status;
    private String note;
    private Date createdOn;
    private List<Interest> interest;
    public UserResponse() {
    }
    public UserResponse(String firstName, String lastName, String penName, Date dob, String sex, String biography,
            String city, String state, String country, String phone, String email, String role, boolean status,
            String note, Date createdOn, List<Interest> interest) {
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
        this.role = role;
        this.status = status;
        this.note = note;
        this.createdOn = createdOn;
        this.interest = interest;
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
