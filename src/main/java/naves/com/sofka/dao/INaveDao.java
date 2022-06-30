package naves.com.sofka.dao;

import naves.com.sofka.domain.Nave;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author FELIPE
 */

public interface INaveDao extends CrudRepository<Nave, Long>{

    @Query("SELECT n FROM Nave n WHERE n.nombre_nave LIKE %?1%"+"or n.categoria LIKE %?1%"+"or n.pais LIKE %?1%")
    public List<Nave> findAll(String nombre);
}
