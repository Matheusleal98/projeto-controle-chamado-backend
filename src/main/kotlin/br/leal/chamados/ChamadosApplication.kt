package br.leal.chamados

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChamadosApplication

fun main(args: Array<String>) {
	runApplication<ChamadosApplication>(*args)
}
