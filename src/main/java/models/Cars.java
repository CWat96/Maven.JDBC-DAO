package models;

public class Cars {
    private Integer idCars;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String vin;

    public Cars() {
    }

    public Cars(Integer idCars, String make, String model, Integer year, String color, String vin) {
        this.idCars = idCars;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getIdCars() {
        return idCars;
    }
    public void setIdCars(Integer idCars) {
        this.idCars = idCars;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}
