package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.SurgeonBody;
import com.example.pwbackend.Models.Bodies.UserBody;
import com.example.pwbackend.Models.Entities.Surgeon;
import com.example.pwbackend.Models.Entities.User;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurgeonService {

    @Autowired
    private SurgeonRepository surgeonRepository;
    @Autowired
    private UserRepository userRepository;

    public SurgeonBody addSurgeon(SurgeonBody surgeonBody) {
        Surgeon surgeon = new Surgeon(
                surgeonBody.getId(),
                new User(
                    surgeonBody.getUserBody().getId(),
                    null, // username
                     null, // password
                    surgeonBody.getUserBody().getRole(),
                    null, // tokens
                    surgeonBody.getUserBody().getFirstName(),
                    surgeonBody.getUserBody().getLastName(),
                    surgeonBody.getUserBody().getEmail(),
                    surgeonBody.getUserBody().getImageUrl()
                ),
                surgeonBody.getTitle(),
                surgeonBody.getRating(),
                surgeonBody.getDescription()
        );

        Surgeon savedSurgeon = surgeonRepository.save(surgeon);


        return new SurgeonBody(
                savedSurgeon.getId(),
                new UserBody(
                        savedSurgeon.getUser().getId(),
                        savedSurgeon.getUser().getRole(),
                        savedSurgeon.getUser().getFirstName(),
                        savedSurgeon.getUser().getLastName(),
                        savedSurgeon.getUser().getEmail(),
                        savedSurgeon.getUser().getImageUrl()
                ),
                savedSurgeon.getTitle(),
                savedSurgeon.getDescription(),
                savedSurgeon.getRating()
        );
    }

    public SurgeonBody getSurgeon(Long id) {
        Surgeon surgeon = surgeonRepository.findById(id).orElse(null);

        if (surgeon == null)
            return null;

        return new SurgeonBody(
                surgeon.getId(),
                new UserBody(
                    surgeon.getUser().getId(),
                    surgeon.getUser().getRole(),
                        surgeon.getUser().getFirstName(),
                    surgeon.getUser().getLastName(),
                    surgeon.getUser().getEmail(),
                    surgeon.getUser().getImageUrl()
                ),
                surgeon.getTitle(),
                surgeon.getDescription(),
                surgeon.getRating()
        );
    }

    public List<SurgeonBody> getSurgeons() {
        List<Surgeon> surgeons = surgeonRepository.findAll();
        List<SurgeonBody> surgeonBodies = new ArrayList<>();

        surgeons.forEach(surgeon ->
            surgeonBodies.add(
                new SurgeonBody(
                    surgeon.getId(),
                    new UserBody(
                        surgeon.getUser().getId(),
                        surgeon.getUser().getRole(),
                        surgeon.getUser().getFirstName(),
                        surgeon.getUser().getLastName(),
                        surgeon.getUser().getEmail(),
                        surgeon.getUser().getImageUrl()
                    ),
                    surgeon.getTitle(),
                    surgeon.getDescription(),
                    surgeon.getRating()
                )
            )
        );

        return surgeonBodies;
    }

    public Boolean deleteSurgeon(Long id) {
        surgeonRepository.deleteById(id);

        Surgeon surgeon = surgeonRepository.findById(id).orElse(null);

        return surgeon == null;
    }
}