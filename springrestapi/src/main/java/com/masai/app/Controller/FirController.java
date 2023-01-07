package com.masai.app.Controller;


import com.masai.app.entity.Fir;
import com.masai.app.service.FirServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fir")
public class FirController {

    @Autowired
    private FirServiceImpl firServiceImpl;

    @PostMapping("/fir")
    public ResponseEntity<?> fileFir(@Valid @RequestBody Fir fir){
        System.out.println(fir.getUser().getUId());
        List<Fir> firs=this.firServiceImpl.fileFirByUser(fir);
        System.out.println(firs.size());
        if(firs.size()==0) {
            throw new IllegalArgumentException("Register user to file a fir");
        }
        return new ResponseEntity<List<Fir>>(firs,HttpStatus.CREATED);
    }
}


