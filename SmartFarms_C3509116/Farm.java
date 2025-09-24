/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class represents a farm with its name and up to three sensors.
 */

public class Farm {
    private final String name;
    // Array holds up to 3 sensors
    private final Sensor[] sensors;
    // Current number of sensors in farm
    private int sensorCount;

    // Name of the farm
    public Farm(String name) {
        if (name.contains(" ")){
            throw new IllegalArgumentException("Farm name must not contain spaces");
        }
        this.name = name;
        this.sensors = new Sensor[4]; // Maximum of 4 sensors as per requirements
        this.sensorCount = 0;
    }

    // Method to get farm name
    public String getName() {
        return name;
    }

    // Method to add a sensor to the farm
    public void addSensor(Sensor sensor) {
        for (int i = 0; i < sensorCount; i++){
            if (sensors[i].getType().equals(sensor.getType())){
                sensors[i].setQuantity(sensors[i].getQuantity() + sensor.getQuantity());
                return;
            }
        }

        // Add sensor if space available
        if (sensorCount < 4){
            sensors[sensorCount++] = sensor;
        }
    }

    // Method to remove a sensor from the farm
    public int removeSensorItems(String type, int quantity) {
        for (int i = 0; i < sensorCount; i++) {
            if (sensors[i].getType().equals(type)) {
                // Check if we have enough sensors to remove
                if (sensors[i].getQuantity() < quantity) {
                    return -1; // Not enough sensors to remove
                }

                // Remove the quantity from the sensor
                sensors[i].setQuantity(sensors[i].getQuantity() - quantity);

                // If quantity becomes 0, remove the sensor
                if (sensors[i].getQuantity() == 0) {
                    // Shift remaining sensors to the left
                    for (int j = i; j < sensorCount - 1; j++) {
                        sensors[j] = sensors[j + 1];
                    }
                    sensors[--sensorCount] = null; // Clear the last sensor reference
                }
                return quantity; // Return the number of items removed
            }
        }
        return -1; // Sensor type not found
    }

    // Method to check if the farm has any sensors
    public boolean hasAnySensors() {
        return sensorCount > 0;
    }

    /**
     * Checks if the farm already has 3 different types of sensors.
     *
     * @return true if the farm has 3 different types of sensors, false otherwise.
     */
    public boolean hasMaxSensors() {
        return sensorCount >= 3;
    }

    // Method to get sensors by type
    public Sensor getSensorByType(String type){
        for (int i = 0; i < sensorCount; i++){
            if (sensors[i].getType().equals(type)){
                return sensors[i];
            }
        }
        return null;
    }

    // Method to get total number of sensors in farm
    public int getTotalSensors() {
        int total = 0;
        for (int i = 0; i < sensorCount; i++){
            total += sensors[i].getQuantity();
        }
        return total;
    }

    // Method to get total cost of sensors in farm
    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < sensorCount; i++){
            total += sensors[i].getPrice() * sensors[i].getQuantity();
        }
        return total;
    }

    // Method to print sensors in farm
    public void printSensors() {
        if (sensorCount == 0){
            System.out.println("No sensors in the farm "+ name);
            return;
        }
        for (int i = 0; i< sensorCount; i++){
            System.out.println(sensors[i].getType() + " Sensor" +
                                " has price $" +sensors[i].getPrice()+
                                ", weight " + sensors[i].getWeight()+
                                "kg, and quantity of " + sensors[i].getQuantity());
        }
    }
    // Method to get sensors
    public Sensor[] getSensors(){
        return sensors;
    }
    // Method to get sensorCount
    public int getSensorCount(){
        return sensorCount;
    }

}