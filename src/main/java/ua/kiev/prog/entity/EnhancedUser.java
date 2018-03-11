package ua.kiev.prog.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/**
 * Created by Dmitriy on 11.03.2018.
 */
public class EnhancedUser extends User {

    private String salt;

    public EnhancedUser(String username, String password,
            Collection<? extends GrantedAuthority> authorities,
            String salt) {
        super(username, password, authorities);
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
