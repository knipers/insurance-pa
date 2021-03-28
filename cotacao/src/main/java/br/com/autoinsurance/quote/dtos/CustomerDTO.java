package br.com.autoinsurance.quote.dtos;

import br.com.autoinsurance.quote.entities.Customer;

import java.time.LocalDateTime;

public class CustomerDTO {
    private String id;
    private String email;
    private String name;
    private String cpf;
    private LocalDateTime created;
    private LocalDateTime updated;

    public CustomerDTO(String id, String email, String name, String cpf, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.cpf = cpf;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.cpf = customer.getCpf();
        this.created = customer.getCreated();
        this.updated = customer.getUpdated();
    }
}
