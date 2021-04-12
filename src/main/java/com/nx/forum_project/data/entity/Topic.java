package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_id_generator")
    @SequenceGenerator(name = "topic_id_generator", schema = "ism", sequenceName = "seq_topic_id", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "topic")
    private List<Message> messages;
}
