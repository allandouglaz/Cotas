package com.inove.sorteioCotas.service;

import com.inove.sorteioCotas.models.User;
import com.inove.sorteioCotas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User usuario) {
        return userRepository.save(usuario);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
