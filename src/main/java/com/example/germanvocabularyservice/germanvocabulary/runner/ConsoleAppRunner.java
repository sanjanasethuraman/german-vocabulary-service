package com.example.germanvocabularyservice.germanvocabulary.runner;

import com.example.germanvocabularyservice.germanvocabulary.GermanvocabularyApplication;
import com.example.germanvocabularyservice.germanvocabulary.entity.AnswerEvaluator;
import com.example.germanvocabularyservice.germanvocabulary.entity.GermanWord;
import com.example.germanvocabularyservice.germanvocabulary.service.ExcelImportService;
import com.example.germanvocabularyservice.germanvocabulary.service.GermanNounService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import java.io.FileInputStream;

@Component
public class ConsoleAppRunner implements CommandLineRunner {

    private final ExcelImportService excelImportService;
    private final GermanNounService germanNounService;

    public ConsoleAppRunner(ExcelImportService excelImportService, GermanNounService germanNounService) {
        this.excelImportService = excelImportService;
        this.germanNounService = germanNounService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        do {
            System.out.println("========= MENU =========");
            System.out.println("1. Import Excel Data");
            System.out.println("2. Get a word");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    try {
                        FileInputStream fis = new FileInputStream("/Users/d2c-sanjana-s/Downloads/GermanVocabulary.xlsx");
                        excelImportService.importFromExcel(fis);
                        System.out.println("✅ Import completed.");
                    } catch (Exception e) {
                        System.out.println("❌ Failed to import: " + e.getMessage());
                    }
                    break;
                case "2":
                    GermanWord incomingData = germanNounService.getRandomWordFromDatabase();
                    System.out.println("The word for you is: " + incomingData.getWortOhneArtikel());
                    System.out.println("Please enter the Singular Nominativ form of " + incomingData.getWortOhneArtikel() + ": ");
                    String singularNominativ = scanner.nextLine();
                    System.out.println("Please enter the Singular Akkusativ form of " + incomingData.getWortOhneArtikel() + ": ");
                    String singularAkkusativ = scanner.nextLine();
                    System.out.println("Please enter the Plural Nominativ form of " + incomingData.getWortOhneArtikel() + ": ");
                    String pluralNominativ = scanner.nextLine();
                    System.out.println("Please enter the Singular Akkusativ form of " + incomingData.getWortOhneArtikel() + ": ");
                    String pluralAkkusativ = scanner.nextLine();

                    GermanWord generatedWordFromUserInput = new GermanWord(singularNominativ, singularAkkusativ, pluralNominativ, pluralAkkusativ, incomingData.getWortOhneArtikel(), incomingData.getEnglishTranslation());
                    AnswerEvaluator solutionValidity = germanNounService.checkValidityOfAnswer(generatedWordFromUserInput);

                    if (solutionValidity != null && solutionValidity.isAnswerValid()) {
                        System.out.println("Your answer was correct ✅");
                        System.out.println("Your score is: " + solutionValidity.getScore());
                    }
                    else System.out.println("Your answer was incorrect :( ❌❌");
                    break;
                case "3":
                    System.out.println("👋 Exiting.");
                    break;
                default:
                    System.out.println("❗ Invalid input.");
            }
        } while (!input.equals("3"));
        scanner.close();
    }
}
