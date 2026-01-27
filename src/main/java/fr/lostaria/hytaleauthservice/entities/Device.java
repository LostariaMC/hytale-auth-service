package fr.lostaria.hytaleauthservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "devices")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    private String id;

    @Column(nullable = false)
    public String ip;

    @Column(nullable = false)
    public boolean enable;

    @Column
    public String description;

}
