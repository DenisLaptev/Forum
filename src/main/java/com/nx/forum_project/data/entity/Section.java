package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "section", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_id_generator")
    @SequenceGenerator(name = "section_id_generator", schema = "ism", sequenceName = "seq_section_id", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "section")
    private List<Topic> topics;

}
