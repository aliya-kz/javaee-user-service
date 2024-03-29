package org.zhumagulova.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="users_seq_gen")
    @SequenceGenerator(name="users_seq_gen", sequenceName="users_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "email")
    @Email
    @NotEmpty
    private String email;

    @JsonIgnore
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
