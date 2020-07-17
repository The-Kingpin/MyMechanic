package com.mymechanic.service;


import com.mymechanic.entities.User;

import javax.persistence.EntityExistsException;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsername(String username);

    void addUser(User user) throws EntityExistsException;
}
