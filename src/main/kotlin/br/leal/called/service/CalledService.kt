package br.leal.chamados.service

import br.leal.chamados.CalledDTO
import br.leal.chamados.entity.Called
import br.leal.chamados.repository.CalledRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CalledService {

    @Autowired
    lateinit var calledRepository: CalledRepository

    fun createCalled(calledDTO: CalledDTO): Called {
        val called = Called()
            called.nomeCliente = calledDTO.nomeCliente
            called.assunto = calledDTO.assunto
            called.status = calledDTO.status
            called.atendente = calledDTO.atendente
            called.descricao = calledDTO.descricao
            called.dataHora = LocalDateTime.now().toString()
        return calledRepository.save(called)
    }

    fun findAll(): MutableList<Called> {
        return calledRepository.findAll()
    }

    fun delete(id: Long) {
        calledRepository.deleteById(id)
    }

    fun save(chamado: Called): Called {
        return calledRepository.save(chamado)
    }

    fun findById(id: Long?): Called? {
        return calledRepository.findByIdOrNull(id)
    }

    fun updateCalled(dto: CalledDTO, id: Long): Called {
        return calledRepository.findById(id)
            .map { existingCalled ->
                existingCalled.nomeCliente = dto.nomeCliente
                existingCalled.assunto = dto.assunto
                existingCalled.status = dto.status
                existingCalled.atendente = dto.atendente
                existingCalled.descricao = dto.descricao
                calledRepository.save(existingCalled)
            }
            .orElseGet {
                val newCalled = createCalled(dto) // Crie um novo objeto Called com base no DTO
                newCalled.id = id // Defina o ID do novo objeto como o ID fornecido
                calledRepository.save(newCalled)
            }
    }
}