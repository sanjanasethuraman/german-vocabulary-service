package com.example.germanvocabularyservice.germanvocabulary.controller;

import com.example.germanvocabularyservice.germanvocabulary.service.ExcelImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/nouns")
public class GermanWordController {

    private final ExcelImportService excelImportService;

    @Autowired
    public GermanWordController(ExcelImportService excelImportService) {
        this.excelImportService = excelImportService;
    }

    @PostMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            excelImportService.importFromExcel(inputStream);
            return "✅ Import successful";
        } catch (Exception e) {
            return "❌ Import failed: " + e.getMessage();
        }
    }
}
