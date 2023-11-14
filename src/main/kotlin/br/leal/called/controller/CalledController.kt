package br.leal.called.controller

import br.leal.called.dto.CalledDTO
import br.leal.called.entity.Called
import br.leal.called.service.CalledService
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

    @GetMapping("/find/{id}")
    fun findById(@PathVariable id: Long): Called? {
        return calledService.findById(id)
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