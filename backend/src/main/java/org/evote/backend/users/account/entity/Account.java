package org.evote.backend.users.account.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.evote.backend.users.enums.Role;
import org.evote.backend.users.user.entity.User;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer account_id;

    private String email;
    private String password;
    private Role role;
    private Boolean hasVoted;
    private Boolean isAccountActive;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
