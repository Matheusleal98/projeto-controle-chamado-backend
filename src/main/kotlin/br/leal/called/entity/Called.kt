package br.leal.called.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Table(name = "tb_chamado")
@Entity
class Called {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null
    @Column(name = "assunto")
    var assunto: String? = null
    @Column(name = "status")
    var status: String? = null
    @Column(name = "atendente")
    var atendente: String? = null
    @Column(name = "datahora")
    var dataHora: String? = null
    @Column(name = "descricao")
    var descricao: String? = null
}