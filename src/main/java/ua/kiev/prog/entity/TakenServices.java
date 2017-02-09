package ua.kiev.prog.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TakenServices")
public class TakenServices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @Column(name = "price",columnDefinition = "DECIMAL(7,2)")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "custom_User_Id")
    private CustomUser customUser;

    public TakenServices() {
    }

    public TakenServices(String login, String date, String name, BigDecimal price, CustomUser customUser) {
        this.login = login;
        this.date = date;
        this.name = name;
        this.price = price;
        this.customUser = customUser;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    @Override
    public String toString() {
        return "TakenServices{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
