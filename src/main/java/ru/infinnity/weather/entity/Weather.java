package ru.infinnity.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = "city")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @Column(name = "value")
    private Double value;
}
