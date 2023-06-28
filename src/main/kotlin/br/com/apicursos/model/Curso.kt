package br.com.apicursos.model

data class Curso(
    var id: Long = 0,
    var nome : String = "",
    var descricao : String = "",
    var categoria : String = "",
    var cargaHoraria : String = "",
    var dataAdicionada : String = ""
)
