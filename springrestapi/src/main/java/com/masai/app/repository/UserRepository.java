package com.masai.app.repository;

import com.masai.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByFirstname(String firstname,String lastname,String password);
}
