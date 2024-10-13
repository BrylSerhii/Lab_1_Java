package com.appliances;

import com.appliances.models.Appliance;
import com.appliances.models.Fridge;
import com.appliances.models.TV;
import com.appliances.models.WashingMachine;
import com.appliances.utils.ApplianceLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ApplianceLoaderTest {

    @Test
    void testLoadAppliancesFromFile() throws IOException {
        // Arrange: створюємо тимчасовий файл з даними про прилади
        Path tempFile = Files.createTempFile("appliances", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Fridge,Samsung,300\n");
            writer.write("WashingMachine,LG,2000\n");
            writer.write("TV,Sony,150\n");
        }

        // Act: завантажуємо прилади з тимчасового файлу через InputStream
        try (InputStream inputStream = Files.newInputStream(tempFile)) {
            List<Appliance> appliances = ApplianceLoader.loadAppliancesFromStream(inputStream);

            // Assert: перевіряємо, що прилади були завантажені коректно
            assertEquals(3, appliances.size(), "Повинно бути завантажено 3 прилади");

            Appliance fridge = appliances.get(0);
            assertTrue(fridge instanceof Fridge, "Перший прилад повинен бути холодильником");
            assertEquals("Samsung", fridge.getName(), "Назва холодильника повинна бути Samsung");
            assertEquals(300, fridge.getPower(), "Потужність холодильника повинна бути 300W");

            Appliance washingMachine = appliances.get(1);
            assertTrue(washingMachine instanceof WashingMachine, "Другий прилад повинен бути пральною машиною");
            assertEquals("LG", washingMachine.getName(), "Назва пральної машини повинна бути LG");
            assertEquals(2000, washingMachine.getPower(), "Потужність пральної машини повинна бути 2000W");

            Appliance tv = appliances.get(2);
            assertTrue(tv instanceof TV, "Третій прилад повинен бути телевізором");
            assertEquals("Sony", tv.getName(), "Назва телевізора повинна бути Sony");
            assertEquals(150, tv.getPower(), "Потужність телевізора повинна бути 150W");
        }

        // Очищення: видалення тимчасового файлу
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testLoadAppliancesFromFileWithInvalidData() throws IOException {
        // Arrange: створюємо тимчасовий файл з неправильним форматом даних
        Path tempFile = Files.createTempFile("invalid_appliances", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("UnknownType,Test,500\n");
        }

        // Act & Assert: перевіряємо, що буде викликано виключення через невідомий тип приладу
        try (InputStream inputStream = Files.newInputStream(tempFile)) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                ApplianceLoader.loadAppliancesFromStream(inputStream);
            });

            assertTrue(exception.getMessage().contains("Unknown appliance type"), "Повідомлення про помилку повинно містити 'Unknown appliance type'");
        }

        // Очищення: видалення тимчасового файлу
        Files.deleteIfExists(tempFile);
    }
}
