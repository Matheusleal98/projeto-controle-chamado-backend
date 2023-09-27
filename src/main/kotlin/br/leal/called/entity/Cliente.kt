package br.leal.called.entity

import jakarta.persistence.*

@Table(name = "tb_cliente")
@Entity
class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @Column(name = "nome")
    var nome: String? = null
    @Column(name = "email")
    var email: String? = null
    @Column(name = "cpf")
    var cpf: String? = null
}