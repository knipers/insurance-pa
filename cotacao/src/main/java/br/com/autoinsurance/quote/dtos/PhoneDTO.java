package br.com.autoinsurance.quote.dtos;

import br.com.autoinsurance.quote.entities.Phone;
import br.com.autoinsurance.quote.enums.TypePhones;

import java.time.LocalDateTime;

public class PhoneDTO {
    private String id;
    private TypePhones type;
    private int countryCode;
    private int number;
    private String idCustomer;
    private LocalDateTime created;
    private LocalDateTime updated;

    public PhoneDTO() {
    }

    public PhoneDTO(String id, TypePhones type, int countryCode, int number, String idCustomer, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.type = type;
        this.countryCode = countryCode;
        this.number = number;
        this.idCustomer = idCustomer;
        this.created = created;
        this.updated = updated;
    }
    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.type = phone.getType();
        this.countryCode = phone.getCountryCode();
        this.number = phone.getNumber();
        this.idCustomer = phone.getIdCustomer();
        this.created = phone.getCreated();
        this.updated = phone.getUpdated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TypePhones getType() {
        return type;
    }

    public void setType(TypePhones type) {
        this.type = type;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
