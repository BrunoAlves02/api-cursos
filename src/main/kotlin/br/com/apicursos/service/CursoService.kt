package br.com.apicursos.service

import br.com.apicursos.controller.CursoController
import br.com.apicursos.data.vo.v1.CursoVO
import br.com.apicursos.exceptions.RequiredObjectIsNullException
import br.com.apicursos.data.vo.v2.CursoVO as CursoVOV2
import br.com.apicursos.exceptions.ResourceNotFoundException
import br.com.apicursos.mapper.DozerMapper
import br.com.apicursos.mapper.custom.CursoMapper
import br.com.apicursos.model.Curso
import br.com.apicursos.repository.CursoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import java.util.logging.Logger

@Service
class CursoService() {

    @Autowired
    private lateinit var repository: CursoRepository

    @Autowired
    private lateinit var mapper: CursoMapper

    private val logger = Logger.getLogger(CursoService::class.java.name)

    fun findAll(): List<CursoVO>{
        logger.info("Finding all Courses!")
        val cursos = repository.findAll()
        val vos = DozerMapper.parseListObject(cursos, CursoVO::class.java)
        for (person in vos) {
            val withSelfRel = linkTo(CursoController::class.java).slash(person.key).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun findById(id: Long): CursoVO{
        logger.info("Finding one courses!")

        var curso = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val personVO: CursoVO = DozerMapper.parseObject(curso, CursoVO::class.java)
        val withSelfRel = linkTo(CursoController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun create (curso: CursoVO?): CursoVO{
        if (curso == null) throw RequiredObjectIsNullException()
        logger.info("Course created with name ${curso.nome}!")
        val entity: Curso = DozerMapper.parseObject(curso, Curso::class.java)
        repository.save(entity)
        val cursoVO : CursoVO = DozerMapper.parseObject(entity, CursoVO::class.java)
        val withSelfRel = linkTo(CursoController::class.java).slash(cursoVO.key).withSelfRel()
        cursoVO.add(withSelfRel)
        return cursoVO
    }
    fun createV2 (curso: CursoVOV2): CursoVOV2{
        logger.info("Course created with name ${curso.nome}!")
        val entity: Curso = mapper.mapVoToEntity(curso)
        repository.save(entity)
        return mapper.mapEntityToVo(entity)
    }

    fun update (curso: CursoVO?): CursoVO {
        if (curso == null) throw RequiredObjectIsNullException()
        logger.info("Course updated with ID ${curso.key}!")
        val entity = repository.findById(curso.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.nome = curso.nome
        entity.descricao = curso.descricao
        entity.categoria = curso.categoria
        entity.cargaHoraria = curso.cargaHoraria
        entity.dataAdicionada = curso.dataAdicionada

        repository.save(entity)
        val cursoVO : CursoVO = DozerMapper.parseObject(entity, CursoVO::class.java)
        val withSelfRel = linkTo(CursoController::class.java).slash(cursoVO.key).withSelfRel()
        cursoVO.add(withSelfRel)
        return cursoVO
    }

    fun delete (id: Long){
        logger.info("Course deleted with ID ${id}!")
        val entity = repository.findById(id)
            .orElseThrow{ResourceNotFoundException("No records found for this ID!")}
        repository.delete(entity)
    }


}