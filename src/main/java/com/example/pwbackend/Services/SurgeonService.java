package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.SurgeonBody;
import com.example.pwbackend.Models.Bodies.UserBody;
import com.example.pwbackend.Models.Entities.Surgeon;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurgeonService {

    @Autowired
    private SurgeonRepository surgeonRepository;
    @Autowired
    private UserRepository userRepository;

    public Surgeon addSurgeon(Surgeon surgeon) {
        return surgeonRepository.save(surgeon);
    }

    public Surgeon getSurgeon(Long id) {
        return surgeonRepository.findById(id).orElse(null);
    }

    public List<SurgeonBody> getSurgeons() {
        List<Surgeon> surgeons = surgeonRepository.findAll();
        List<SurgeonBody> surgeonBodies = new ArrayList<>();

        surgeons.forEach(surgeon ->
            surgeonBodies.add(
                new SurgeonBody(
                    surgeon.getId(),
                    new UserBody(
                        surgeon.getUser().getFirstName(),
                        surgeon.getUser().getLastName(),
                        surgeon.getUser().getEmail()
                    ),
                    surgeon.getTitle(),
                    surgeon.getDescription(),
                    surgeon.getRating(),
                    surgeon.getImageUrl()
                )
            )
        );

        return surgeonBodies;
    }

    public boolean deleteSurgeon(Long id) {
        surgeonRepository.deleteById(id);

        Surgeon surgeon = getSurgeon(id);

        return surgeon == null;
    }
}