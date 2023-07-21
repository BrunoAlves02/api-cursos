package br.com.apicursos.data.vo.v2


data class CursoVO(
    var id: Long = 0,
    var nome : String = "",
    var descricao : String = "",
    var categoria : String = "",
    var cargaHoraria : String = "",
    var dataAdicionada : String = "",
    var thumbCurso: String? = null
)
