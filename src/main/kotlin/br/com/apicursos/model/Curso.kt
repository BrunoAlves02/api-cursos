package br.com.apicursos.model

import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
@Table(name = "curso")
data class Curso(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "nome", nullable = false, length = 100)
    var nome : String = "",

    @Column(name = "descricao", nullable = false, length = 100)
    var descricao : String = "",

    @Column(name = "categoria", nullable = false, length = 100)
    var categoria : String = "",

    @Column(name = "carga_horaria", nullable = false, length = 10)
    var cargaHoraria : String = "",

    @Column(name = "data_adicionada", nullable = false, length = 10)
    var dataAdicionada : String = ""
)
