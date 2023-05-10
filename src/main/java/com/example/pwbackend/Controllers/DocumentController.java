package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Entities.Document;
import com.example.pwbackend.Services.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Operation(
            summary = "create an document",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Document uploaded successfully"),
                    @ApiResponse(responseCode = "400", description = "Something is wrong with the request", content = @Content())
            }
    )
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> addDocument(@RequestPart MultipartFile file) {
        try {
            documentService.addDocument(file);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }

    @Operation(
            summary = "get an document",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "200", description = "Document downloaded successfully"),
                @ApiResponse(responseCode = "400", description = "Something is wrong with the request", content = @Content())
            }
    )
    @GetMapping("/{docId}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long docId) {
        Document document = documentService.getDocumentById(docId);
        ByteArrayResource resource = new ByteArrayResource(document.getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + document.getFileName())
                .contentType(MediaType.parseMediaType(document.getFileType()))
                .contentLength(document.getData().length)
                .body(resource);
    }

    @Operation(
            summary = "delete an document",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "200", description = "Document deleted successfully"),
                @ApiResponse(responseCode = "400", description = "Something is wrong with the request", content = @Content(examples = @ExampleObject(value = "false")))
            }

    )
    @DeleteMapping("/{docId}")
    public void deleteDocument(@PathVariable Long docId) {
        documentService.deleteDocument(docId);
    }
}
