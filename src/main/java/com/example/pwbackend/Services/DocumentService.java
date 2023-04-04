package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Document;
import com.example.pwbackend.Repositories.DocumentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepository;

    public Document getDocumentById(Long docId) {
        Optional<Document> document = documentRepository.findById(docId);

        return document.get();
    }

    public Document addDocument(MultipartFile file) throws IOException {
        Document document = new Document();
        document.setData(file.getBytes());
        document.setFileName(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        return documentRepository.save(document);
    }

    public void deleteDocument(Long docId) {
        Document document = documentRepository.findById(docId)
                .orElseThrow(() -> new EntityNotFoundException("Document with id " + docId + " not found"));

        documentRepository.deleteById(docId);
    }
}
