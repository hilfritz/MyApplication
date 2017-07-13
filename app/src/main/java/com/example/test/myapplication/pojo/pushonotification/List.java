
package com.example.test.myapplication.pojo.pushonotification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phones")
    @Expose
    private Phones phones;
    @SerializedName("email")
    @Expose
    private java.util.List<String> email = null;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("registered")
    @Expose
    private Boolean registered;
    @SerializedName("emergencyContacts")
    @Expose
    private java.util.List<EmergencyContact> emergencyContacts = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    public java.util.List<String> getEmail() {
        return email;
    }

    public void setEmail(java.util.List<String> email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public java.util.List<EmergencyContact> getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(java.util.List<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

}
