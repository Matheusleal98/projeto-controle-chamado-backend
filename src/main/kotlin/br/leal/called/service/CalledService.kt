package br.leal.called.service

import br.leal.called.dto.CalledDTO
import br.leal.called.entity.Called
import br.leal.called.entity.Cliente
import br.leal.called.repository.CalledRepository
import br.leal.called.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CalledService {

    @Autowired
    lateinit var calledRepository: CalledRepository
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun createCalled(dto: CalledDTO): Called {
        val called = mapperTo(dto)
        return calledRepository.save(called)
    }

    fun delete(id: Long) {
        calledRepository.deleteById(id)
    }

    fun findAll(): MutableList<Called> {
        return calledRepository.findAll()
    }

    fun findById(id: Long?): Called? {
        return calledRepository.findByIdOrNull(id)
    }

    fun mapperTo(dto: CalledDTO): Called {
        val called = Called()
        called.cliente = findByClient(dto)
        called.assunto = dto.assunto
        called.status = dto.status
        called.atendente = dto.atendente
        called.descricao = dto.descricao
        called.dataHora = LocalDateTime.now().toString()
        return called
    }

    fun updateCalled(dto: CalledDTO, id: Long): Called {
        return calledRepository.findById(id)
            .map { existingCalled ->
                existingCalled.cliente = findByClient(dto)
                existingCalled.status = dto.status
                existingCalled.atendente = dto.atendente
                existingCalled.assunto = dto.assunto
                existingCalled.descricao= dto.descricao
                calledRepository.save(existingCalled)
            }
            .orElseGet {
                val newCalled = Called()
                newCalled.id = id
                createCalled(dto)
                calledRepository.save(newCalled)
            }
    }

    fun findByClient(dto: CalledDTO): Cliente? {
        val cliente = clientRepository.findByEmail(dto.cliente)
        if (cliente.isPresent){
            val nome = cliente.get()
            return nome
        } else {
            return null
        }
    }
}