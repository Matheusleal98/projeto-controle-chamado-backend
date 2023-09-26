package br.leal.called.controller

import br.leal.called.dto.ClienteDTO
import br.leal.called.entity.Cliente
import br.leal.called.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/called/client")
class ClientController {

    @Autowired
    lateinit var clientService: ClientService

    @PostMapping("/save")
    fun createClient(@RequestBody dto: ClienteDTO): Cliente {
        return clientService.createClient(dto)
    }
}