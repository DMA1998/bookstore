package com.mykh.bookstore.author.model;

import com.mykh.bookstore.book.model.Book;
import com.mykh.bookstore.user.userprofile.model.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "author")
@Entity
public class Author {

    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )

    @Include
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "author_sequence"
    )
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birthday",nullable = false)
    private LocalDateTime dateOfBirthday;

    @ManyToOne()
    @JoinColumn(name = "user_profile_id",
            referencedColumnName = "user_id",
            nullable = false)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "author",
            cascade = ALL,
            orphanRemoval = true)
    @Setter(PRIVATE)
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        book.setAuthor(this);
        books.add(book);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        books.remove(book);
    }
}
