package me.bigfanoftim.domaindriven.common.model;

import jakarta.persistence.Column;

import java.util.Objects;

public class Email {

    @Column(name = "email")
    private String value;

    protected Email() {
    }

    public Email(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(this.value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
