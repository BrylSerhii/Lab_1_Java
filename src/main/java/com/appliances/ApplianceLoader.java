package com.appliances;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplianceLoader {

    public static List<Appliance> loadAppliancesFromStream(InputStream inputStream) throws IOException {
        List<Appliance> appliances = new ArrayList<>();

        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] params = line.split(",");
                String type = params[0];
                String name = params[1];
                int power = Integer.parseInt(params[2]);

                switch (type) {
                    case "Fridge":
                        appliances.add(new Fridge(name, power));
                        break;
                    case "WashingMachine":
                        appliances.add(new WashingMachine(name, power));
                        break;
                    case "TV":
                        appliances.add(new TV(name, power));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown appliance type: " + type);
                }
            }
        }

        return appliances;
    }
}
