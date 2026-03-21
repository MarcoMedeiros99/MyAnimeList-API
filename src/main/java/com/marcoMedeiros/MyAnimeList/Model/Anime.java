package com.marcoMedeiros.MyAnimeList.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_anime")
public class Anime implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //Mapping & Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The title is mandatory and cannot consist solely of numbers.")
    private String titulo;

    @NotBlank(message = "Gender is mandatory.")
    private String genero;

    @NotNull(message = "The release year is required.")
    @Min(value = 1900, message = "Invalid Release Year.")
    private Integer anoLancamento;

    @NotBlank(message = "The studio is mandatory.")
    private String estudio;

    @NotNull(message = "A grade is required")
    @DecimalMin(value = "0.0", message = "The minimum grade is 0.0")
    @DecimalMax(value = "10.0", message = "The maximum grade is 10.0")
    private Double notaPessoal;

    @NotNull(message = "Assisted field training is mandatory.")
    private Boolean assistido;

    //Constructors


    public Anime() {
    }

    public Anime(Long id, String titulo, String genero, Integer anoLancamento, String estudio, Double notaPessoal, Boolean assistido) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.estudio = estudio;
        this.notaPessoal = notaPessoal;
        this.assistido = assistido;
    }

    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public Double getNotaPessoal() {
        return notaPessoal;
    }

    public void setNotaPessoal(Double notaPessoal) {
        this.notaPessoal = notaPessoal;
    }

    public Boolean getAssistido() {
        return assistido;
    }

    public void setAssistido(Boolean assistido) {
        this.assistido = assistido;
    }

    //Equals() and HashCode()


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return Objects.equals(id, anime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
