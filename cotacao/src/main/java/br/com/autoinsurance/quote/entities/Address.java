package br.com.autoinsurance.quote.entities;

import br.com.autoinsurance.quote.base.BaseEntity;
import br.com.autoinsurance.quote.dtos.AddressDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address extends BaseEntity {
    private String street;
    private String district;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String idCustomer;

    public Address(String street, String district, String zipcode, String city, String state, String country, String idCustomer) {
        this.street = street;
        this.district = district;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.idCustomer = idCustomer;
    }

    public Address(AddressDTO dto) {
        this.street = dto.getStreet();
        this.district = dto.getDistrict();
        this.zipcode = dto.getZipcode();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.country = dto.getCountry();
        this.idCustomer = dto.getIdCustomer();
    }

    public Address() {
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
}
