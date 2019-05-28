package pl.xkoem.tickets.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xkoem.tickets.models.CityEntity;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    List<CityEntity> findAll();

}
