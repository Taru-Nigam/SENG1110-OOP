/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class represents a sensor with its type, price, weight, and quantity.
 */

public class Sensor
{
    private String type;
    private double price;
    private double weight;
    private int quantity;
    //add comments

    // Allowed Sensor types/
    private static final String[] ALLOWED_TYPES = {
            "Temperature",
            "Pressure",
            "Humidity",
            "Soil Temperature",
            "Soil Humidity",
            "Soil PH"
    };
    // Constructor to initialize the sensor with its attributes
    public Sensor(String type, double price, double weight, int quantity) {
        setType(type);
        setPrice(price);
        setWeight(weight);
        setQuantity(quantity);
    }

    // Method to get sensor type
    public String getType(){
        return type;
    }

    // Method to get sensor price
    public double getPrice(){
        return price;
    }

    // Method to get sensor weight
    public double getWeight(){
        return weight;
    }

    // Method to get sensor quantity
    public int getQuantity(){
        return quantity;
    }

    // Method to set sensor type
    private void setType(String type){
        if (!isValidType(type)){
            throw new IllegalArgumentException("Invalid Sensor type. Must be: " + String.join(", ", ALLOWED_TYPES));
        }
        this.type = type;
    }

    // Method to set price
    private void setPrice(double price){
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.price = price;
    }

    // Method to set weight
    private void setWeight(double weight){
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.weight = weight;
    }

    // Method to set sensor quantity
    public void setQuantity(int quantity){
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.quantity = quantity;
    }

    // Validate Sensor Type
    private boolean isValidType(String type){
        for (String allowedType : ALLOWED_TYPES){
            if (allowedType.equals(type)){
                return true;
            }
        }
        return false;
    }
}
