package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Surgeon;
import com.example.pwbackend.Services.SurgeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeons")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;

    @PostMapping
    public Surgeon addSurgeon(@RequestBody Surgeon surgeon) {
        return surgeonService.addSurgeon(surgeon);
    }

    @GetMapping("/{id}")
    public Surgeon getSurgeon(@PathVariable Long id) {
        return surgeonService.getSurgeon(id);
    }
    @GetMapping
    public List<Surgeon> getSurgeons() {
        return surgeonService.getSurgeons();
    }
}