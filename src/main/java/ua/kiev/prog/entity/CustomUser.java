package ua.kiev.prog.entity;

import javax.persistence.*;

import ua.kiev.prog.entity.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CustomUser")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "car_number")
    private String carNumber;

    @OneToMany(mappedBy = "customUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TakenServices> takenServices = new ArrayList<TakenServices>();

    public CustomUser() {
    }

    public CustomUser(String login, String password, String salt, UserRole role) {
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }


    public CustomUser(String login, String password, String salt, UserRole role, String name, String email,
            String telNumber, String carType, String carNumber) {
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.name = name;
        this.email = email;
        this.telNumber = telNumber;
        this.carType = carType;
        this.carNumber = carNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettelNumber() {
        return telNumber;
    }

    public void settelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getcarType() {
        return carType;
    }

    public void setcarType(String carType) {
        this.carType = carType;
    }

    public String getcarNumber() {
        return carNumber;
    }

    public void setcarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public List<TakenServices> getTakenServices() {
        return takenServices;
    }

    public void setTakenServices(List<TakenServices> takenServices) {
        this.takenServices = takenServices;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", carType='" + carType + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", takenServices=" + takenServices +
                '}';
    }
}

