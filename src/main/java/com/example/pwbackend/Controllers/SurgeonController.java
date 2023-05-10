package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.SurgeonBody;
import com.example.pwbackend.Models.Entities.Surgeon;
import com.example.pwbackend.Services.SurgeonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeons")
@CrossOrigin(origins = "http://localhost:4200")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;


    @Operation(
            summary = "add a surgeon",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping
    public ResponseEntity<SurgeonBody> addSurgeon(@RequestBody SurgeonBody surgeon) {
        return new ResponseEntity<>(surgeonService.addSurgeon(surgeon), HttpStatus.OK);
    }

    @Operation(
            summary = "get a surgeon",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Surgeon returned successfully"),
                    @ApiResponse(responseCode = "404", description = "Surgeon not found", content = @Content)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<SurgeonBody> getSurgeon(@PathVariable Long id) {
        SurgeonBody surgeonBody = surgeonService.getSurgeon(id);
        if ( surgeonBody != null)
        {
            return new ResponseEntity<>(surgeonBody, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "get all surgeons",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Surgeons returned successfully"),
                    @ApiResponse(responseCode = "404", description = "Surgeons not found", content = @Content)
            }
    )
    @GetMapping
    public ResponseEntity<List<SurgeonBody>> getSurgeons() {
        List<SurgeonBody> surgeonBodies = surgeonService.getSurgeons();
        if ( surgeonBodies != null)
        {
            return new ResponseEntity<>(surgeonBodies, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @Operation(
            summary = "delete a surgeon",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "200", description = "surgeon deleted successfully"),
                @ApiResponse(responseCode = "400", description = "surgeon not deleted", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSurgeon(@PathVariable Long id) {
        Boolean result = surgeonService.deleteSurgeon(id);
        if (result)
        {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(
            summary = "update a surgeon",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "surgeon updated successfully"),
                    @ApiResponse(responseCode = "400", description = "surgeon not update", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}