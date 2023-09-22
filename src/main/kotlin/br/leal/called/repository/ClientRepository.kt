package br.leal.called.repository

import br.leal.called.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
open interface ClientRepository: JpaRepository<Cliente, Long> {
}