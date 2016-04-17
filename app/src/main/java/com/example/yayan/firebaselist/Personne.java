package com.example.yayan.firebaselist;

/**
 * Created by yayan on 17/04/2016.
 */
public class Personne {

    private String name;
    private String lastname;

    @Override
    public String toString() {
        return super.toString();
    }

    public Personne() {
    }

    public Personne(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return this.name;
    }



    public String getLastname() {
        return this.lastname;
    }


}
