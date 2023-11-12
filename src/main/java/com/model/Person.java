package com.model;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int age;


    public Person(int id, String name, int age, String adress, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public Person() {
    }
    private Person (Builder builder) {

        id = builder.id;
        name = builder.name;
        age = builder.age;




    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public static class Builder {

        private int id;
        private String name;
        private int age;



        public Builder() {


        }

        public Builder id (int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }


        public Person build() {
            return new Person(this);
        }
    }
    @Override
    public String toString() {
        return "com.model.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +

                '}';
    }
}
