package br.leal.chamados

data class CalledDTO(val nomeCliente: String,
                     val assunto: String,
                     val descricao: String,
                     val atendente: String,
                     val status: String,
)