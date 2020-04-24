package com.example.proto1;

public class UserProfile {
    public String Age;
    public String Name;

    public UserProfile(){

    }

    public UserProfile(String userAge, String userName) {
        this.Age = userAge;
        this.Name = userName;
    }

    public String getUserAge() {
        return Age;
    }

    public void setUserAge(String age) {
        Age = age;
    }

    public String getUserName() {
        return Name;
    }

    public void setUserName(String name) {
        Name = name;
    }
}
