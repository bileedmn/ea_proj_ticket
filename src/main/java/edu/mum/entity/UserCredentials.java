package edu.mum.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Ganbat Bayar
 * On: 12/17/2018
 * Project: Ticket_Booker
 */
@Entity
public class UserCredentials {
    @Id
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    @Transient
    String verifyPassword;
    Boolean enabled;

    @OneToOne(mappedBy = "userCredentials", cascade = CascadeType.PERSIST)
    private Member member;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    List<Authority> authority = new ArrayList<Authority>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
}
