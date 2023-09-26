package br.leal.called.service

import br.leal.called.dto.ClienteDTO
import br.leal.called.entity.Cliente
import br.leal.called.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun createClient(dto: ClienteDTO): Cliente{
        val cliente =  mapperTo(dto)
        return clientRepository.save(cliente)
    }

    private fun mapperTo(dto: ClienteDTO): Cliente {
        val cliente = Cliente()
        cliente.nome = dto.nome
        cliente.cpf = dto.cpf
        cliente.email = dto.email
        return cliente
    }
}
