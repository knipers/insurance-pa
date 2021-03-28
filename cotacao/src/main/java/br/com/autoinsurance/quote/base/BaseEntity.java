package br.com.autoinsurance.quote.base;

import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BaseEntity {

    @Id
    private String id;
    private LocalDateTime created;
    private LocalDateTime updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
