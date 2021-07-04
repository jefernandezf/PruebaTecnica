package com.prueba.fernandez.tipo.cambio.repository;

import com.prueba.fernandez.tipo.cambio.model.TipoCambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public interface TipoCambioRepository  extends JpaRepository<TipoCambio,Long> {

    @Query(value = "select c.id from Tipo_Cambio c where c.origen = ?1 AND C.destino = ?2", nativeQuery = true)
    Long buscarId(String origen,String destino);




}
