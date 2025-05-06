package com.example.germanvocabularyservice.germanvocabulary.service;

import com.example.germanvocabularyservice.germanvocabulary.entity.GermanWord;
import com.example.germanvocabularyservice.germanvocabulary.repository.ExcelToDatabaseRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelImportService {
    private ExcelToDatabaseRepository repository;

    public ExcelImportService(ExcelToDatabaseRepository repository) {
        this.repository = repository;
    }

    public void importFromExcel(InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            List<GermanWord> nouns = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // skip header
                GermanWord noun = new GermanWord(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue()
                );
                nouns.add(noun);
            }

            repository.saveAll(nouns);
        } catch (Exception e) {
            throw new RuntimeException("Error during import: " + e.getMessage(), e);
        }
    }

}
