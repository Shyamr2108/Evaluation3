package com.masai.app.Controller;

import com.masai.app.Login;
import com.masai.app.entity.Fir;
import com.masai.app.entity.User;
import com.masai.app.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user){
        if(user.getGender().equalsIgnoreCase("male") ||
                user.getGender().equalsIgnoreCase("female") ||
                user.getGender().equalsIgnoreCase("transgender")) {
            List<User> users=this.userServiceImpl.registerUser(user);
            return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);}
        else {
            throw new IllegalArgumentException("gender must be male female or transgender");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login credentials){
        String firstname=credentials.getFirstname();
        String lastname=credentials.getLastname();
        String password=credentials.getPassword();
        User user=this.userServiceImpl.loginUser(firstname,
                lastname,password);
        if(user==null)
            throw new IllegalArgumentException("User not found");
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping("/{userId}/fir/")
    public ResponseEntity<List<Fir>> getListFirByUser(@PathVariable("userId") int userId){
        List<Fir> firs=this.userServiceImpl.getAllFirs(userId);
        if(firs==null) {
            throw new IllegalArgumentException("Register to file an FIR");
        }
        return new ResponseEntity<List<Fir>>(firs,HttpStatus.OK);
    }
}