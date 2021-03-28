package br.com.autoinsurance.quote.entities;

import br.com.autoinsurance.quote.base.BaseEntity;
import br.com.autoinsurance.quote.dtos.PhoneDTO;
import br.com.autoinsurance.quote.enums.TypePhones;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Phone extends BaseEntity {
    private TypePhones type;
    private int countryCode;
    private int number;
    private String idCustomer;

    public Phone(TypePhones type, int countryCode, int number, String idCustomer) {
        this.type = type;
        this.countryCode = countryCode;
        this.number = number;
        this.idCustomer = idCustomer;
    }

    public Phone(PhoneDTO dto) {
        this.type = dto.getType();
        this.countryCode = dto.getCountryCode();
        this.number = dto.getNumber();
        this.idCustomer = dto.getIdCustomer();
    }

    public Phone() {
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

}
