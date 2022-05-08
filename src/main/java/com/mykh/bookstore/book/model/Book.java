package com.mykh.bookstore.book.model;

import com.mykh.bookstore.author.model.Author;
import com.mykh.bookstore.user.userprofile.model.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "book")
@Entity
public class Book {

    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @Include
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    @Column(name = "name",
            nullable = false)
    private String name;

    @NaturalId
    @Include
    @Column(name = "isbn",
            nullable = false)
    private String isbn;

    @Column(name = "release_date",
            nullable = false)
    private LocalDateTime releaseDate;


    @ManyToOne()
    @JoinColumn(name = "user_profile_id",
            referencedColumnName = "user_id",
            nullable = false)
    private UserProfile userProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",
            referencedColumnName = "id",
            nullable = false)
    private Author author;




}
