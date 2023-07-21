package br.com.apicursos.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel

@JsonPropertyOrder("id", "nome", "descricao", "categoria", "cargaHoraria",)
data class CursoVO(

    @Mapping("id")
    @field: JsonProperty("id")
    var key: Long = 0,
    var nome : String = "",
    var descricao : String = "",
    var categoria : String = "",
    var cargaHoraria : String = "",
    var dataAdicionada : String = ""
): RepresentationModel<CursoVO>()
