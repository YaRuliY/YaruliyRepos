package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "city")
    private String city;

    public User(String name, String lastName, String gender, String city){
        this.first_name = name;
        this.last_name = lastName;
        this.gender = gender;
        this.city = city;
    }

    public User(){}

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;

    }

    public String getFirstName() {
        return first_name;

    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;

    }

    public String getLastName() {
        return last_name;

    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getGender() {
        return gender;

    }

    public void setGender(String gender) {
        this.gender = gender;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean search(String key){
        if (this.first_name.contains(key.toLowerCase()) || this.first_name.contains(key.toUpperCase()) ||
                this.last_name.contains(key.toLowerCase()) || this.last_name.contains(key.toUpperCase()) ||
                this.city.contains(key.toLowerCase()) || this.city.contains(key.toUpperCase())) return true;
        else return false;
    }

}