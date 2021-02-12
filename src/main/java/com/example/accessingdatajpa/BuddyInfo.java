package com.example.accessingdatajpa;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Basic
    private Integer id;

    @Basic
    private String firstName;

    @Basic
    private String lastName;

    @Basic
    private String phoneNumber;

    @Basic
    private String address;



    public BuddyInfo() { }

    public BuddyInfo(String firstName, String lastName){

        this(firstName,lastName,null);
    }

    public BuddyInfo(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public BuddyInfo(String firstName, String lastName, String phoneNumber, String address) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress((address));
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

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfoString() {
        return getFirstName() + " " + getLastName() + " " + getAddress();
    }

    @Override
    public String toString(){
        return getFirstName() + " " + getLastName() + " " + getPhoneNumber() + " " + getAddress() + " " + getId();
    }


}
