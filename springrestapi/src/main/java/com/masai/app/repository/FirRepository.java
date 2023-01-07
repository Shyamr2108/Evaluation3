package com.masai.app.repository;

import com.masai.app.entity.Fir;
import com.masai.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirRepository extends JpaRepository<Fir,Integer> {
    public List<Fir> findByUser(User user);
}
