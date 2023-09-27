package br.leal.called.repository

import br.leal.called.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
open interface ClientRepository: JpaRepository<Cliente, Long> {

    fun findByEmail(email: String): Optional<Cliente>
}