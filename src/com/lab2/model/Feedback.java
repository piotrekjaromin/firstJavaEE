package com.lab2.model;

public class Feedback {
    String name;
    String mail;
    String comment;

    public Feedback(String name, String mail, String comment) {
        this.name = name;
        this.mail = mail;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

        public String toString() {
            return name + " " + mail + " " + comment;
        }
}
