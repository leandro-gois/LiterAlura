package br.com.literAlura.model;

import jakarta.persistence.*;

@Entity
@Table (name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    //private Integer nascAno;
    private Integer anoNascimento;
    //private Integer mortAno;
    private Integer anoFalecimento;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    //construto padrão
    public Autor() {
    }

    public Autor(DadosAutor dadosAutor, Livro livro) {
        this.nome = dadosAutor.getName();
        this.anoNascimento = dadosAutor.getBirthYear();
        this.anoFalecimento = dadosAutor.getDeathYear();
        this.livro = livro;
    }


    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    // Método toString para representação significativa
    @Override
    public String toString() {
        return "Autor: " + nome + "\n" +
                "Ano de nascimento: " + anoNascimento + "\n"+
                "________________________________________________\n";

    }
}