package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.AppointmentBody;
import com.example.pwbackend.Services.AppointmentService;
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
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Operation(
            summary = "add appointment",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "201", description = "appointment created successfully"),
                @ApiResponse(responseCode = "400", description = "appointment not created", content = @Content())
            }
    )
    @PostMapping
    public ResponseEntity<AppointmentBody> addAppointment(@RequestBody AppointmentBody appointmentBody) {
        appointmentBody = appointmentService.addAppointment(appointmentBody);
        if( appointmentBody != null)
        {
            return new ResponseEntity<>(appointmentBody, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "get appointment",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "200", description = "appointment got successfully"),
                @ApiResponse(responseCode = "404", description = "appointment not found", content = @Content())
            }
    )
    @GetMapping("/surgeon/{surgeonId}")
    public ResponseEntity<List<AppointmentBody>> getAppointmentsBySurgeonId(@PathVariable Long surgeonId) {
        List<AppointmentBody> appointmentBody = appointmentService.getAppointmentsBySurgeonId(surgeonId);
        if(appointmentBody != null)
        {
            return new ResponseEntity<>(appointmentBody, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "get appointment",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "appointment got successfully"),
                    @ApiResponse(responseCode = "404", description = "appointment not found", content = @Content())
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentBody>> getAppointmentsByUserId(@PathVariable Long userId) {
        List<AppointmentBody> appointmentBodies = appointmentService.getAppointmentsByUserId(userId);
        if(appointmentBodies != null)
        {
            return new ResponseEntity<>(appointmentBodies, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "delete appointment",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "204", description = "appointment deleted successfully"),
                @ApiResponse(responseCode = "400", description = "appointment not found", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        Boolean result = appointmentService.deleteAppointment(id);
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
            summary = "update appointment",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "200", description = "appointment updated successfully"),
                @ApiResponse(responseCode = "400", description = "appointment not updated", content = @Content())
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
