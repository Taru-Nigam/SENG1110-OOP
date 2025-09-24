/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class provides the user interface for the program.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Interface
{
    private final Farm[] farms;
    private int farmCount;
    private final Scanner scanner;

    public Interface(){
        farms = new Farm[5];
        farmCount = 0;
        scanner = new Scanner(System.in);
    }
    // Method to control the flow of the program
    public void run() {
        //this method should control the flow of the program
        int choice;
        while (true) {
            printMenu();
            choice = getIntInput();
            scanner.nextLine(); // Consumes newline

            // Select User Choices
            switch (choice) {
                case 1 -> addFarm();
                case 2 -> removeFarm();
                case 3 -> addSensorToFarm();
                case 4 -> removeSensorItems();
                case 5 -> listSensorsAtFarm();
                case 6 -> queryCumulativeValue();
                case 7 -> exportToFile();
                case 8 -> {
                    System.out.println("\nExiting Program.");
                    return;
                }
                default -> System.out.println("\nInvalid Choice. Please Try Again.");
            }
        }
    }

    private void printMenu(){
        System.out.println("\n1. Add Farm");
        System.out.println("2. Remove Farm");
        System.out.println("3. Add Sensor To Farm");
        System.out.println("4. Remove Sensor Items From Farm");
        System.out.println("5. List Sensors At Farm");
        System.out.println("6. Query Cumulative Value of Sensors At Farm");
        System.out.println("7. Export Farm and Sensor Information to File");
        System.out.println("8. Exit\n");
        System.out.println("Enter Your Choice: ");
    }

    // Method to add a farm
    private void addFarm(){
        // Check if already have two farms
        if (farmCount >= 5){
            System.out.println("\nThere are already 5 farms");
            return;
        }
        System.out.println("\nEnter Farm Name: (No spaces)");
        String name = scanner.nextLine();
        if (getFarm(name) != null){
            System.out.println("\nFarm already exists.");
            return;
        }
        try {
            farms[farmCount++] = new Farm(name);
            System.out.println("\nFarm Added Successfully!");
        } catch (IllegalArgumentException e){
            System.out.println("\nError: " + e.getMessage());
        }
    }

    // Method to remove a farm
    private void removeFarm(){
        printFarms();
        System.out.println("\nEnter Farm Name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < farmCount; i++){
            if (farms[i].getName().equals(name)){
                for (int j = i; j < farmCount-1; j++){
                    farms[j] = farms[j+1];
                }
                farms[--farmCount] = null;
                System.out.println("\nFarm removed successfully.");
                return;
            }
        }
        System.out.println("\nFarm Not Found");
    }
    // Method to add a sensor to a farm
    private void addSensorToFarm() {
        printFarms(); // prints the farms
        System.out.println("\nEnter farm name: ");
        String farmName = scanner.nextLine();

        Farm farm = getFarm(farmName); // prints the sensors in the farm
        if (farm == null) {
            System.out.println("Farm not found.");
            return;
        }
        if (farm.hasMaxSensors()) {
            System.out.println("\nFarm already has 3 sensors.\n");
            return;
        }

        System.out.println("\nEnter Sensor Type (Temperature, Pressure, Humidity, Soil Temperature, Soil Humidity, Soil PH): ");
        String sensorType = scanner.nextLine();

        Sensor existingSensor = getExistingSensor(sensorType);
        if (existingSensor != null) {
            System.out.println("\nSensor " + sensorType + " exists, with price $" + existingSensor.getPrice() +
                    " and weight " + existingSensor.getWeight() + "kg. Adding additional sensors.");
            System.out.println("\nEnter quantity: ");
            int quantity = getPositiveIntInput();
            scanner.nextLine();

            Sensor newSensor = new Sensor(sensorType, existingSensor.getPrice(), existingSensor.getWeight(), quantity);
            farm.addSensor(newSensor);

        } else {
            System.out.println("\nEnter Price: ");
            double price = getPositiveDoubleInput("Price must be positive.");

            System.out.println("\nEnter Weight (kg): ");
            double weight = getPositiveDoubleInput("Weight must be positive.");

            System.out.println("\nEnter Quantity: ");
            int quantity = getPositiveIntInput();

            try {
                Sensor sensor = new Sensor(sensorType, price, weight, quantity);
                farm.addSensor(sensor);
                System.out.println("\nSensor added successfully.");
            } catch (IllegalArgumentException e){
                System.out.println("\nError: "+ e.getMessage());
            }
        }
    }

    // Method to remove a sensor from a farm
    private void removeSensorItems(){
        printFarms(); // Prints farms
        System.out.println("\nEnter Farm Name: ");
        String farmName = scanner.nextLine();

        Farm farm = getFarm(farmName);
        if (farm == null){
            System.out.println("\nFarm Not Found.");
            return;
        }
        farm.printSensors(); // Prints the sensors in the farm for easier viewing
        // Check if there are any sensors in the farm
        if (farm.getSensorCount() == 0) { // Assuming getSensorCount() returns the number of sensors
            System.out.println("\nThere are no sensors in the farm.");
            return;
        }

        System.out.println("\nEnter Sensor Type: ");
        String sensorType = scanner.nextLine();

        System.out.println("\nEnter Quantity to remove: ");
        int quantity = getPositiveIntInput();

        int removed = farm.removeSensorItems(sensorType, quantity);
        if (removed == -1){
            System.out.println("\nError: Sensor not found or insufficient quantity");
        } else {
            System.out.println("\n" + removed + " items of Sensor " + sensorType + " removed from farm " + farmName + " successfully.");
        }
    }

    // Method to list sensors at a farm
    private void listSensorsAtFarm() {
        printFarms(); // Prints farms
        System.out.println("\nEnter farm name: ");
        String farmName = scanner.nextLine();
        Farm farm = getFarm(farmName);
        if (farm == null) {
            System.out.println("Farm not found.");
            return;
        }
        farm.printSensors();
    }

    // Method to query total sensors and cost at a farm
    private void queryCumulativeValue() {
        printFarms(); // Prints farms
        System.out.println("\nEnter Farm Name: ");
        String farmName = scanner.nextLine();
        Farm farm = getFarm(farmName);
        if (farm == null) {
            System.out.println("\nFarm Not Found.");
            return;
        }
        System.out.printf("Farm %s has cumulative sensor value $%.2f%n", farm.getName(), farm.getTotalCost());
    }
    // Method to export farm and sensor information to a file
    private void exportToFile(){
        System.out.println("\nEnter filename to export: ");
        String filename = scanner.nextLine();
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < farmCount; i++) {
                Farm farm = farms[i];
                if (!farm.hasAnySensors()) {
                    writer.write(farm.getName() + "\n");
                } else {
                    Sensor[] sensors = farm.getSensors();
                    for (int j = 0; j < farm.getSensorCount(); j++) {
                        Sensor sensor = sensors[j];
                        writer.write(String.format("%s %s $%.2f %.2f kg %d units\n",
                                farm.getName(), sensor.getType(), sensor.getPrice(),
                                sensor.getWeight(), sensor.getQuantity()));
                    }
                }
            }
            System.out.println("\nExport Successfully!");
        } catch (IOException e){
            System.out.println("\nError exporting to file: "+ e.getMessage());
        }
    }

    // Method to get a farm by name
    private Farm getFarm(String name){
        for (int i = 0; i < farmCount; i++){
            if (farms[i].getName().equals(name)){
                return farms[i];
            }
        }
        return null;
    }

    // Method to get an existing sensor by type
    private Sensor getExistingSensor(String type){
        for (int i = 0; i < farmCount; i++){
            Farm farm = farms[i];
            Sensor[] sensors = farm.getSensors();
            for (int j = 0; j < farm.getSensorCount(); j++){
                Sensor sensor = sensors[j];
                if (sensor.getType().equals(type)){
                    return sensor;
                }
            }
        }
        return null;
    }
    // Method to get an integer input from the user
    private int getIntInput(){
        while (true){
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Please Enter A Number.");
                scanner.nextLine();
            }
        }
    }

    // Method to get a positive double input from the user
    private double getPositiveDoubleInput(String errorMessage) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                if (input > 0) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
    // Method to get a positive integer input from the user
    private int getPositiveIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Quantity must be positive.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
    // Prints the farms on the interface
    public void printFarms(){
        System.out.println("\nFarms:");
        for (int i = 0; i < farmCount; i++) {
            Farm farm = farms[i];
            System.out.println(farm.getName());
        }
    }
    // Main method to run the program
    public static void main(String[] args) {
        Interface intFace = new Interface();
        intFace.run();
    }

}