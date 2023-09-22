package br.leal.called.repository

import br.leal.called.entity.Called
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
open interface CalledRepository : JpaRepository<Called, Long>{
}