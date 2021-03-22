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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "seq_id")
    private Long id;

    @Column(name="url")
    private String url;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
