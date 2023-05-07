package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Entities.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @PostMapping
    public ResponseEntity<Boolean> addInvoice(@RequestBody Invoice user) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateInvoice(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
