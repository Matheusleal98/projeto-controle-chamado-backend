package br.leal.called.entity

import jakarta.persistence.Entity
import jakarta.persistence.*

@Table(name = "tb_atendente")
@Entity
data class Atendente (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "nome")
    var nome: String? = null,
    @Column(name = "email")
    var email: String? = null
)