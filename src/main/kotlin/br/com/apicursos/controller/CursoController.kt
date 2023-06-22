package br.com.apicursos.controller

import br.com.apicursos.model.CursoModel
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CursoController {


    @RequestMapping("/cursos")
    fun teste(): CursoModel{
        return CursoModel("Kotlin","curso Bruno","mobile", "10hr", "16/06/2023")
    }

}