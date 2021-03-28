package br.com.autoinsurance.quote.dtos;

import br.com.autoinsurance.quote.entities.Address;

import java.time.LocalDateTime;

public class AddressDTO {
    private String id;
    private String street;
    private String district;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String idCustomer;
    private LocalDateTime created;
    private LocalDateTime updated;

    public AddressDTO() {
    }

    public AddressDTO(String id, String street, String district, String zipcode, String city, String state, String country, String idCustomer, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.idCustomer = idCustomer;
        this.created = created;
        this.updated = updated;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.idCustomer = address.getIdCustomer();
        this.created = address.getCreated();
        this.updated = address.getUpdated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
