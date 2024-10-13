package com.appliances;


import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Завантаження приладів з файлу
        List<Appliance> appliances = ApplianceLoader.loadAppliancesFromFile("appliances.txt");

        // Увімкнення приладів
        appliances.get(0).plugIn(); // Наприклад, холодильник

        // Підрахунок спожитої потужності
        int totalPower = appliances.stream()
                .filter(Appliance::isPluggedIn)
                .mapToInt(Appliance::getPower)
                .sum();
        System.out.println("Total power consumption: " + totalPower + "W");

        // Сортування приладів за потужністю
        appliances.sort(Comparator.comparingInt(Appliance::getPower));
        System.out.println("Appliances sorted by power:");
        appliances.forEach(appliance -> System.out.println(appliance.getDescription()));

        // Пошук приладу за діапазоном потужності
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter power range (min max): ");
        int minPower = scanner.nextInt();
        int maxPower = scanner.nextInt();

        appliances.stream()
                .filter(a -> a.getPower() >= minPower && a.getPower() <= maxPower)
                .forEach(a -> System.out.println("Found: " + a.getDescription()));
    }
}
