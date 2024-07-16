package br.com.literAlura.repository;

import br.com.literAlura.model.Autor;
import br.com.literAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//interface que persiste a classe Livro pelo id do tipo Long
//CRUD operações de criar, ler, editar e excluir.
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l.titulo, l.idiomas, a.nome FROM Livro l JOIN l.autores a")
    List<Object[]> findLivrosAndAutores();

    @Query("SELECT DISTINCT a.nome FROM Autor a")
    List<String> findAutores();

    @Query("SELECT DISTINCT a FROM Autor a WHERE a.anoNascimento <= :ano AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)")
    List<Autor> findAutoresEmDeterminadoAno(@Param("ano") Integer ano);

    @Query("SELECT l FROM Livro l WHERE l.idiomas LIKE %:idioma%")
    List<Livro> findByIdioma(String idioma);
}