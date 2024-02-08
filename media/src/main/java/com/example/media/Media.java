package com.example.media;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "Media")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMedia")

    private Long id; // Clé primaire

    private String nomMedia;

    private String typeMedia;

    private String email;
}
