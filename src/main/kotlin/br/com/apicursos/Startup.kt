package br.com.apicursos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class Startup

fun main(args: Array<String>) {
	runApplication<Startup>(*args)

	println("------------------------------------------------")
	println("------------------------------------------------")
	println("------------------------------------------------")
	println("----------------API RODANDO---------------------")
	println("------------------------------------------------")
	println("------------------------------------------------")
	println("------------------------------------------------")
}
