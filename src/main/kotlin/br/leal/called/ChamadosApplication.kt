package br.leal.called

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChamadosApplication

fun main(args: Array<String>) {
	runApplication<ChamadosApplication>(*args)
}
