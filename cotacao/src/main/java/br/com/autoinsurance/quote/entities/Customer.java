package br.com.autoinsurance.quote.entities;

import br.com.autoinsurance.quote.base.BaseEntity;
import br.com.autoinsurance.quote.dtos.CustomerDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer extends BaseEntity {
    private String email;
    private String name;
    private String cpf;

    public Customer(String email, String name, String cpf) {
        this.email = email;
        this.name = name;
        this.cpf = cpf;
    }

    public Customer(CustomerDTO dto) {
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.cpf = dto.getCpf();
    }

    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
