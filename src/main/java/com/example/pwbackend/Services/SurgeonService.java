package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Surgeon;
import com.example.pwbackend.Repositories.SurgeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeonService {

    @Autowired
    private SurgeonRepository surgeonRepository;

    public Surgeon addSurgeon(Surgeon surgeon) {
        return surgeonRepository.save(surgeon);
    }

    public Surgeon getSurgeon(Long id) {
        return surgeonRepository.findById(id).orElse(null);
    }

    public List<Surgeon> getSurgeons() {
        return surgeonRepository.findAll();
    }
}