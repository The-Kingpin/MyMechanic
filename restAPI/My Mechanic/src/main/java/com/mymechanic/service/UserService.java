package com.mymechanic.service;

import com.mymechanic.entities.User;

public interface UserService {

    User findUserByUsername(String username);
}
