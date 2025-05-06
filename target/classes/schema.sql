CREATE TABLE german_vocabulary (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    singular_nominativ VARCHAR(255),
    singular_akkusativ VARCHAR(255),
    plural_nominativ VARCHAR(255),
    plural_akkusativ VARCHAR(255),
    wort_ohne_artikel VARCHAR(255),
    english_translation VARCHAR(255)
);
