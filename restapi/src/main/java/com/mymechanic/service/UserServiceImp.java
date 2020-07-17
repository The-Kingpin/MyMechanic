package com.mymechanic.service;


import com.mymechanic.entities.User;
import com.mymechanic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public void addUser(User user) throws EntityExistsException {

        if (this.findUserByUsername(user.getUsername()).isPresent()) {
            throw new EntityExistsException("User already exist!");
        }

        this.userRepository.save(user);
    }


}
