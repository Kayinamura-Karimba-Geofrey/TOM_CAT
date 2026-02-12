package com.example.model;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    public Person(){}
    public Person(Integer id, String firstName, String lastName, Gender gender, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    } }


