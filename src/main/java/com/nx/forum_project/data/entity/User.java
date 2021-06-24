package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
//    @SequenceGenerator(name = "user_id_generator", schema = "ism", sequenceName = "seq_user_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "Must be filled")
    @Size(min = 2, max = 30, message = "The Length of field must be from 2 to 30 symbols")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Must be filled")
    @Size(min = 2, max = 30, message = "The Length of field must be from 2 to 30 symbols")
    private String lastName;

    @Column(name = "login")
//    @NotNull(message = "Must be filled")
//    @Size(min = 1, message = "The Length of field must be from 1 symbol")
    private String login;

    @Column(name = "password")
//    @NotNull(message = "Must be filled")
//    @Size(min = 1, message = "The Length of field must be from 1 symbol")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @ManyToMany
    @JoinTable(
            name = "user_role", schema = "ism",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
