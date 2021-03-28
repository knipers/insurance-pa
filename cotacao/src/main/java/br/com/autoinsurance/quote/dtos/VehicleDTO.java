package br.com.autoinsurance.quote.dtos;

import br.com.autoinsurance.quote.entities.Phone;
import br.com.autoinsurance.quote.entities.Vehicle;
import br.com.autoinsurance.quote.enums.TypePhones;

import java.time.LocalDateTime;

public class VehicleDTO {
    private String id;
    private String licensePlate;
    private String brand;
    private String model;
    private String yearManufacture;
    private String yearModel;
    private String renavam;
    private String idCustomer;
    private LocalDateTime created;
    private LocalDateTime updated;

    public VehicleDTO() {
    }

    public VehicleDTO(String id, String licensePlate, String brand, String model, String yearManufacture, String yearModel, String renavam, String idCustomer, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.yearModel = yearModel;
        this.renavam = renavam;
        this.idCustomer = idCustomer;
        this.created = created;
        this.updated = updated;
    }

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.licensePlate = vehicle.getLicensePlate();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.yearManufacture = vehicle.getYearManufacture();
        this.yearModel = vehicle.getYearModel();
        this.renavam = vehicle.getRenavam();
        this.idCustomer = vehicle.getIdCustomer();
        this.created = vehicle.getCreated();
        this.updated = vehicle.getUpdated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(String yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getYearModel() {
        return yearModel;
    }

    public void setYearModel(String yearModel) {
        this.yearModel = yearModel;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
