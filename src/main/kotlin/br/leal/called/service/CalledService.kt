package br.leal.called.service

import br.leal.called.CalledDTO
import br.leal.called.entity.Called
import br.leal.called.repository.CalledRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CalledService {

    @Autowired
    lateinit var calledRepository: CalledRepository

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
        called.nomeCliente = dto.nomeCliente
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
                existingCalled.nomeCliente = dto.nomeCliente
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
}