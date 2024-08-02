package com.inove.sorteioCotas.repository;

import com.inove.sorteioCotas.models.Cotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotasRepository extends JpaRepository<Cotas, Long> {


}
