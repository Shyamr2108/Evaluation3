package com.masai.app.service;

import com.masai.app.entity.Fir;
import com.masai.app.entity.User;
import com.masai.app.repository.FirRepository;
import com.masai.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FirRepository firRepository;

    @Override
    public List<User> registerUser(User user) {
        this.userRepository.save(user);
        return this.userRepository.findAll();
    }

    @Override
    public User loginUser(String firstname,String lastname,String password) {
        User user=this.userRepository.findByFirstname(firstname, lastname, password);
        if(user!=null) {
            return user;
        }
        return null;
    }

    @Override
    public List<Fir> getAllFirs(int userId) {
        User user=this.userRepository.findById(userId).get();
        if(user!=null) {
            return this.firRepository.findByUser(user);
        }
        return null;
    }
}
