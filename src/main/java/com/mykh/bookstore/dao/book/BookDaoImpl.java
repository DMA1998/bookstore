package com.mykh.bookstore.dao.book;

import com.mykh.bookstore.model.book.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao<Book, String> {

}
