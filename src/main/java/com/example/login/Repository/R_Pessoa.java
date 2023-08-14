package com.example.login.Repository;

import com.example.login.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
    @Query(value = "SELECT * FROM PESSOA WHERE nome = :nome", nativeQuery = true)
    M_Pessoa findByNome(@Param("nome") String nome);
}