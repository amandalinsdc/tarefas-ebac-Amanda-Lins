package br.com.ebac.categories.repositories;

import br.com.ebac.categories.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
    @Query("SELECT c FROM CategoriaMeme c WHERE LOWER(c.descricao) = LOWER(:descricao)")
    CategoriaMeme findByDescricao(@Param("descricao") String descricao);
}
