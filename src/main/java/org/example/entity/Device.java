package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "devices")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "installation_date")
    LocalDate installationDate;
    @Column(name = "max_connections")
    Integer maxConnections;

    @OneToMany
    @JoinColumn
    List<Port> portList;
}
