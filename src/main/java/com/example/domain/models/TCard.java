package com.example.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_cards")
public class TCard implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;

    @Column(name = "date_in")
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Librarian librarian;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
