package com.softeng.ticket_application.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 *
 *
 * @author Argiris Sideris
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="first_name")
    @NotEmpty
    private String firstName;
    @Column(name="last_name")
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @NotNull
    private long phone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gid",referencedColumnName="id")
    private Gate gate;

    public Ticket() {
        // Default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(final long phone) {
        this.phone = phone;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(final Gate gate) {
        this.gate = gate;
    }
}
