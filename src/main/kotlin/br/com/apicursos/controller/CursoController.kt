package br.com.apicursos.controller

import br.com.apicursos.model.Curso
import br.com.apicursos.service.CursoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/curso")
class CursoController {

    @Autowired
    private lateinit var service: CursoService

    @RequestMapping(method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Curso> {
        return service.findAll()
    }

    @RequestMapping
    fun findById(id : Long): Curso{
        return service.findById(id)
    }

}