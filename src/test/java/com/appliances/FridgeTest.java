package com.appliances;

import com.appliances.models.Fridge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FridgeTest {

    @Test
    void testFridgeInitialization() {
        // Arrange: створення об'єкта холодильника
        Fridge fridge = new Fridge("Samsung", 300);

        // Assert: перевірка правильності ініціалізації
        assertEquals("Samsung", fridge.getName(), "Назва холодильника повинна бути Samsung");
        assertEquals(300, fridge.getPower(), "Потужність холодильника повинна бути 300W");
    }

    @Test
    void testGetDescription() {
        // Arrange: створення об'єкта холодильника
        Fridge fridge = new Fridge("LG", 500);

        // Act: отримання опису
        String description = fridge.getDescription();

        // Assert: перевірка, чи повертається правильний опис
        assertEquals("Fridge: LG, Power: 500W", description, "Опис повинен бути коректним");
    }
}
