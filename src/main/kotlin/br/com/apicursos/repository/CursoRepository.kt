package br.com.apicursos.repository

import br.com.apicursos.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository : JpaRepository <Curso, Long>