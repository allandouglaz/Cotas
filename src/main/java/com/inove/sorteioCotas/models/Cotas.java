package com.inove.sorteioCotas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qtd;
    @NumberFormat(pattern = "###.##")
    private Float price;
    private String cotas;

}
