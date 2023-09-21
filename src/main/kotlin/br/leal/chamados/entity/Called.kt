package br.leal.chamados.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Table(name = "tb_chamado")
@Entity
data class Called(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "nome_cliente")
    var nomeCliente: String? = null,
    @Column(name = "assunto")
    var assunto: String? = null,
    @Column(name = "status")
    var status: String? = null,
    @Column(name = "atendente")
    var atendente: String? = null,
    @Column(name = "datahora")
    var dataHora: String? = null,
    @Column(name = "descricao")
    var descricao: String? = null
)