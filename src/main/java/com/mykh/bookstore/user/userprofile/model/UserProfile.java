package com.mykh.bookstore.user.userprofile.model;


import com.mykh.bookstore.author.model.Author;
import com.mykh.bookstore.book.model.Book;
import com.mykh.bookstore.user.model.User;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "user_profile")
@Entity
public class UserProfile {

    @Include
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @MapsId
    @OneToOne()
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private User user;

    @OneToMany(mappedBy = "userProfile",
            cascade = ALL,
            orphanRemoval = true)
    @Setter(PRIVATE)
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "userProfile",
            cascade = ALL,
            orphanRemoval = true)
    @Setter(PRIVATE)
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {
        author.setUserProfile(this);
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        author.setUserProfile(null);
        authors.remove(author);
    }

    public void addBook(Book book) {
        book.setUserProfile(this);
        books.add(book);
    }

    public void removeBook(Book book) {
        book.setUserProfile(null);
        books.remove(book);
    }
}
