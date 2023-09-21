package br.leal.chamados.controller

import br.leal.chamados.CalledDTO
import br.leal.chamados.entity.Called
import br.leal.chamados.service.CalledService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/calleds")
class CalledController {

    @Autowired
    lateinit var calledService: CalledService

    @GetMapping("/list")
    fun list(): MutableList<Called> {
        return calledService.findAll()
    }

    @DeleteMapping("/delete/{codigo}")
    fun delete(@PathVariable codigo: Long) {
        calledService.delete(codigo)
    }

    @PostMapping("/save")
    fun createCalled(@RequestBody dto: CalledDTO): Called {
        return  calledService.createCalled(dto)
    }

    @PutMapping("/edit/{id}")
    fun replaceEmployee(@RequestBody dto: CalledDTO, @PathVariable id: Long): Called {
        return calledService.updateCalled(dto,id)
    }

}