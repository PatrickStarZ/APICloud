package com.example.info;

public class ContactInfo {
    public String name = "小明";
    public String surname = "西门";
    public String email = "fever@icloud.com";
    public static final String NAME_PREFIX = "Name_";
    public static final String SURNAME_PREFIX = "Surname_";
    public static final String EMAIL_PREFIX = "email_";

    public ContactInfo(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
