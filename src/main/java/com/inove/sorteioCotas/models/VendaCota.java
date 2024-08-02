package com.inove.sorteioCotas.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VendaCota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long qtd;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User usr;

    @ManyToOne
    @JoinColumn(name = "cotas_id")
    private Cotas cotas;


    public VendaCota(VendaCota vendaCota) {
    }
}
