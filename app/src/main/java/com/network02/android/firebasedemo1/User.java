package com.network02.android.firebasedemo1;

import java.util.List;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private int age;


    private List<String> favoriteColors;

    User() {}

    public User(String username, String firstName, String lastName, int age, List<String> favoriteColors) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favoriteColors = favoriteColors;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<String> getFavoriteColors() {
        return favoriteColors;
    }

    public void setFavoriteColors(List<String> favoriteColors) {
        this.favoriteColors = favoriteColors;
    }
}
