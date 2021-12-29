package com.mykh.bookstore.repository.user;

import com.mykh.bookstore.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
