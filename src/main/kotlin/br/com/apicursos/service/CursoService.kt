package br.com.apicursos.service

import br.com.apicursos.model.Curso
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class CursoService() {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(CursoService::class.java.name)

    fun findAll(): List<Curso>{
        logger.info("Finding all Classes!")
        val cursos: MutableList<Curso> = ArrayList()

        for(i in 0..7){
            val curso = mockCurso(i)
            cursos.add(curso)
        }

        return cursos
    }

    fun findById(id: Long): Curso{
        logger.info("Finding one courses!")

        val curso = Curso()
        curso.id = counter.incrementAndGet()
        curso.nome= "Curso de Android com SpringBoot"
        curso.descricao = "Android com MVVM"
        curso.categoria = "Mobile"
        curso.cargaHoraria = "10hrs"
        curso.dataAdicionada = "10/10/10"
        return curso
    }

    fun create (curso: Curso) = curso
    fun update (curso: Curso) = curso
    fun delete (id:Long){}

    private fun mockCurso(i: Int): Curso {
        val curso = Curso()
        curso.id = counter.incrementAndGet()
        curso.nome= "Curso de Android com SpringBoot"
        curso.descricao = "Android com MVVM"
        curso.categoria = "Mobile"
        curso.cargaHoraria = "10hrs"
        curso.dataAdicionada = "10/10/10"
        return curso
    }

}