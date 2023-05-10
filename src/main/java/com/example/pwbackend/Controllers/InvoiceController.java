package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Entities.Invoice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Operation(
            summary = "add an invoice",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "invoice created successfully"),
                    @ApiResponse(responseCode = "400", description = "invoice not created", content = @Content())
            }
    )
    @PostMapping
    public ResponseEntity<Boolean> addInvoice(@RequestBody Invoice user) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Operation(
            summary = "get an invoice",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "invoice got successfully"),
                    @ApiResponse(responseCode = "404", description = "invoice not found", content = @Content())
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(
            summary = "delete an invoice",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "204", description = "invoice deleted successfully"),
                    @ApiResponse(responseCode = "400", description = "invoice not deleted", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Operation(
            summary = "update an invoice",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "invoice updated successfully"),
                    @ApiResponse(responseCode = "400", description = "invoice not updated", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
