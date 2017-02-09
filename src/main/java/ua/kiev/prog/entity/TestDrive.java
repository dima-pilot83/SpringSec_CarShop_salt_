package ua.kiev.prog.entity;

import javax.persistence.*;

@Entity
@Table(name = "TestDrive")
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "email")
    private String email;

    public TestDrive() {
    }

    public TestDrive(String carType, String date, String name, String telNumber, String email) {
        this.carType = carType;
        this.date = date;
        this.name = name;
        this.telNumber = telNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getcarType() {
        return carType;
    }

    public void setcarType(String carType) {
        this.carType = carType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gettelNumber() {
        return telNumber;
    }

    public void settelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "TestDrive{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
