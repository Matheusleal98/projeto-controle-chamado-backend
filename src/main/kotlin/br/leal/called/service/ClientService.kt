package br.leal.called.service

import br.leal.called.ClienteDTO
import br.leal.called.entity.Cliente
import br.leal.called.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun createClient(dto: ClienteDTO): Cliente{
        val client = Cliente()
        client.nome = dto.nome
        client.email = dto.email
        client.cpf = dto.cpf
        return clientRepository.save(client)
    }
}
