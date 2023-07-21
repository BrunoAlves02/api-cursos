package br.com.apicursos.mapper.custom

import br.com.apicursos.data.vo.v2.CursoVO
import br.com.apicursos.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoMapper {

    fun mapEntityToVo(curso: Curso): CursoVO{
        val vo = CursoVO()
        vo.id = curso.id
        vo.nome = curso.nome
        vo.descricao = curso.descricao
        vo.categoria = curso.categoria
        vo.cargaHoraria = curso.cargaHoraria
        vo.dataAdicionada = curso.dataAdicionada
        vo.thumbCurso = "URL Thumb"
        return vo
    }

    fun mapVoToEntity(cursoVO: CursoVO): Curso{
        val entity = Curso()
        entity.id = cursoVO.id
        entity.nome = cursoVO.nome
        entity.descricao = cursoVO.descricao
        entity.categoria = cursoVO.categoria
        entity.cargaHoraria = cursoVO.cargaHoraria
        entity.dataAdicionada = cursoVO.dataAdicionada
        //entity.thumbCurso = cursoVO.thumbCurso
        return entity
    }

}