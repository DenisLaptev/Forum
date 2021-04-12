package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_generator")
    @SequenceGenerator(name = "role_id_generator", schema = "ism", sequenceName = "seq_role_id", allocationSize = 1)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
