package ca.georgiancollege2330;

public class Phone {
    private String brand;
    private String model;
    private String os;
    private String screenSize;
    private String price;

    public Phone(String brand, String model, String os, String screenSize, String price) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.screenSize = screenSize;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getPrice() {
        return price;
    }
}
