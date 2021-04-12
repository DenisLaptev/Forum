package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "avatar", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avatar_id_generator")
    @SequenceGenerator(name = "avatar_id_generator", schema = "ism", sequenceName = "seq_avatar_id", allocationSize = 1)
    private Long id;

    @Column(name = "url")
    private String url;

    //@OneToOne
    //@JoinColumn(name = "user_id")
    @OneToOne(mappedBy = "avatar")
    private User user;
}
