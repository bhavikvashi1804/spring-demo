package com.example.demo.model.student;

public class Student {

    // properties
    private Integer studentId;
    private String firstName;
    private String lastName;


    // getters & setters
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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


    // constructor
    public Student(){

    }

    public Student(Integer studentId, String firstName, String lastName){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // methods
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
