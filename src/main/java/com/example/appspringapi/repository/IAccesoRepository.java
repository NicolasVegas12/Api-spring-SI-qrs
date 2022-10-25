package com.example.appspringapi.repository;

import com.example.appspringapi.webApi.models.dto.WP_AuthResponse;
import com.example.appspringapi.webApi.models.entity.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAccesoRepository extends JpaRepository<Acceso,Long> {
    Acceso getAccesoByIdAccesoAndCodigo(Long idAcceso, String codigo);
}
