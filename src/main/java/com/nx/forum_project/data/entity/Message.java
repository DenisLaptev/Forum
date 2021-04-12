package com.nx.forum_project.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "message", schema = "ism")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_generator")
    @SequenceGenerator(name = "message_id_generator", schema = "ism", sequenceName = "seq_message_id", allocationSize = 1)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToOne
    @JoinColumn(name = "quoted_message_id")
    private Message quotedMessage;
}
