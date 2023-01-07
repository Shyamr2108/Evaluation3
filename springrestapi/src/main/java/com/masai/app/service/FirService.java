package com.masai.app.service;

import com.masai.app.entity.Fir;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FirService {

    public List<Fir> createFir(Fir fir);
    public List<Fir> fileFirByUser(Fir fir);
}
