package com.camila.beneficiarios.model.repository;

import com.camila.beneficiarios.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< Usuario, Long > {


    Optional< Usuario > findByLogin( String login );
}
