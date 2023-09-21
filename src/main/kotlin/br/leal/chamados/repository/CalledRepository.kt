package br.leal.chamados.repository

import br.leal.chamados.entity.Called
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
open interface CalledRepository : JpaRepository<Called, Long>{
}