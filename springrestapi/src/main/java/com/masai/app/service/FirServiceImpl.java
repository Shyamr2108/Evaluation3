package com.masai.app.service;

import com.masai.app.entity.Fir;
import com.masai.app.entity.User;
import com.masai.app.repository.FirRepository;
import com.masai.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirServiceImpl implements FirService{

    @Autowired
    FirRepository firRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Fir> createFir(Fir fir) {
        Fir pt= this.firRepository.save(fir);
        return this.firRepository.findAll();
    }

    @Override
    public List<Fir> fileFirByUser(Fir fir) {
        User user=this.userRepository.findById(fir.getUser().getUId()).get();
        if(user!=null) {
            fir.setUser(user);
            this.firRepository.save(fir);
            return this.firRepository.findAll();
        }
        return null;
    }


}
