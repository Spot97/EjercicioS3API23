package com.example.ejercicios3api23.model;

public class Usuario  {
    int id;
    String email,first_name,last_name,avatar;

    public Usuario(int id, String email, String first_name,
                   String last_name, String avatar){
        this.id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.avatar=avatar;

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
