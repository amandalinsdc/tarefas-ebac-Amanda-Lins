package br.com.animalservice.animalservice.repositories;

import br.com.animalservice.animalservice.dto.RescuedAnimals;
import br.com.animalservice.animalservice.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a where a.dataAdocao IS NULL ORDER BY a.dataAdocao ASC")
    List<Animal> findNotAdopter();

    @Query("SELECT a FROM Animal a where a.dataAdocao IS NOT NULL")
    List<Animal> findAdopter();

    @Query("SELECT new br.com.animalservice.animalservice.dto.RescuedAnimals(a.nomeRecebedor, count(a.id)) FROM Animal a where a.dataEntrada =:date GROUP BY a.nomeRecebedor")
    List<RescuedAnimals> findRescueAnimalsByReceptor(@Param("date") Date date);
}
