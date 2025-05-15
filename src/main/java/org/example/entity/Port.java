package org.example.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ports")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

//    @Column(name = "device_id")
//    Integer deviceId;

    @ManyToOne
    @JoinColumn(name = "device_id")
    Device deviceId;

    @Column
    String name;

    @Column
    Integer bandwidth;

}
