package com.mykh.bookstore.model.author;

import com.mykh.bookstore.model.book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @Column(name = "books")
    private Set<Book> books;
}
