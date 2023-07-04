package br.com.apicursos.service

import br.com.apicursos.data.vo.v1.CursoVO
import br.com.apicursos.exceptions.ResourceNotFoundException
import br.com.apicursos.mapper.DozerMapper
import br.com.apicursos.model.Curso
import br.com.apicursos.repository.CursoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CursoService() {

    @Autowired
    private lateinit var repository: CursoRepository

    private val logger = Logger.getLogger(CursoService::class.java.name)

    fun findAll(): List<CursoVO>{
        logger.info("Finding all Courses!")
        val cursos = repository.findAll()
        return DozerMapper.parseListObject(cursos, CursoVO::class.java)
    }

    fun findById(id: Long): CursoVO{
        logger.info("Finding one courses!")

        var curso = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        return DozerMapper.parseObject(curso, CursoVO::class.java)
    }

    fun create (curso: CursoVO): CursoVO{
        logger.info("Course created with name ${curso.nome}!")
        val entity: Curso = DozerMapper.parseObject(curso, Curso::class.java)
        repository.save(entity)
        return DozerMapper.parseObject(entity, CursoVO::class.java)
    }

    fun update (curso: CursoVO): CursoVO {
        logger.info("Course updated with ID ${curso.id}!")
        val entity = repository.findById(curso.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.nome = curso.nome
        entity.descricao = curso.descricao
        entity.categoria = curso.categoria
        entity.cargaHoraria = curso.cargaHoraria
        entity.dataAdicionada = curso.dataAdicionada

        repository.save(entity)
        return DozerMapper.parseObject(entity, CursoVO::class.java)
    }

    fun delete (id: Long){
        logger.info("Course deleted with ID ${id}!")
        val entity = repository.findById(id)
            .orElseThrow{ResourceNotFoundException("No records found for this ID!")}
        repository.delete(entity)
    }


}