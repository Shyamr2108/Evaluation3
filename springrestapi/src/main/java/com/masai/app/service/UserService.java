package com.masai.app.service;

import com.masai.app.entity.Fir;
import com.masai.app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> registerUser(User user);
    public User loginUser(String firstname,String lastname,String password);
    public List<Fir> getAllFirs(int userId);
}
