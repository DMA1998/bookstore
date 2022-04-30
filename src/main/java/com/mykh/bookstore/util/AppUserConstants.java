package com.mykh.bookstore.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppUserConstants {

    public final static String USER_NOT_FOUND = "User with email {0} was not found";
    public final static String USER_FOUND = "User with email {0} already registered";

}
