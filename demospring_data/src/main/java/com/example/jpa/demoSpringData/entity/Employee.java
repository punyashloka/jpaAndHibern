package com.example.jpa.demoSpringData.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    //@ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private BigInteger phoneNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_join")
    @CreationTimestamp
    private Date dateOfJoining;

    @Column(name = "date_of_offer")
    @CreationTimestamp
    private LocalDate dateOfOffer;
    @Column(name = "date_and_time_of_offer")
    @CreationTimestamp
    private LocalDateTime dateTimeOfOffer;
    @UpdateTimestamp
    private LocalDateTime dateTimeOfOfferUpdate;

    @Version
    private Integer version = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee() {

    }

    public Employee(Employee e) {
        this.firstName = e.firstName;
        this.lastName = e.lastName;
        this.email = e.email;
        this.phoneNumber = e.phoneNumber;
        this.status = e.status;
        this.dateOfJoining = e.dateOfJoining;
        this.dateOfOffer = e.dateOfOffer;
        this.dateTimeOfOffer = e.dateTimeOfOffer;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfOffer() {
        return dateOfOffer;
    }

    public void setDateOfOffer(LocalDate dateOfOffer) {
        this.dateOfOffer = dateOfOffer;
    }

    public LocalDateTime getDateTimeOfOffer() {
        return dateTimeOfOffer;
    }

    public void setDateTimeOfOffer(LocalDateTime dateTimeOfOffer) {
        this.dateTimeOfOffer = dateTimeOfOffer;
    }

    public Integer getVersion() {
        return version;
    }

    protected void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getDateTimeOfOfferUpdate() {
        return dateTimeOfOfferUpdate;
    }

    public void setDateTimeOfOfferUpdate(LocalDateTime dateTimeOfOfferUpdate) {
        this.dateTimeOfOfferUpdate = dateTimeOfOfferUpdate;
    }
}
