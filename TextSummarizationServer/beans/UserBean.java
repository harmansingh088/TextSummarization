/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author dell1
 */
public class UserBean {
    private int userid;
    private String username;
    private String password;
    private String usertype;
    private boolean userstatus;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String dob;
    private boolean gender;

    public int getUserId() {
        return userid;
    }

    
    public void setUserId(int userid) {
        this.userid = userid;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return usertype;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

    public boolean getUserStatus() {
        return userstatus;
    }

    public void setUserStatus(boolean userstatus) {
        this.userstatus = userstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
}
