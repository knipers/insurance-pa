package br.com.autoinsurance.quote.entities;

import br.com.autoinsurance.quote.base.BaseEntity;
import br.com.autoinsurance.quote.dtos.VehicleDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle extends BaseEntity {
    private String licensePlate;
    private String brand;
    private String model;
    private String yearManufacture;
    private String yearModel;
    private String renavam;
    private String idCustomer;

    public Vehicle(String licensePlate, String brand, String model, String yearManufacture, String yearModel, String renavam, String idCustomer) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.yearModel = yearModel;
        this.renavam = renavam;
        this.idCustomer = idCustomer;
    }

    public Vehicle() {
    }

    public Vehicle(VehicleDTO dto) {
        this.licensePlate = dto.getLicensePlate();
        this.brand = dto.getBrand();
        this.model = dto.getModel();
        this.yearManufacture = dto.getYearManufacture();
        this.yearModel = dto.getYearModel();
        this.renavam = dto.getRenavam();
        this.idCustomer = dto.getIdCustomer();
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
}
