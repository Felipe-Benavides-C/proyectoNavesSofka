
package naves.com.sofka.servicio;

import java.util.List;
import naves.com.sofka.dao.INaveDao;
import naves.com.sofka.domain.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FELIPE
 */
@Service
public class NaveServiceImpl implements NaveService {

    @Autowired
    private INaveDao naveDao;

    
    @Override
    @Transactional(readOnly = true)
    public List<Nave> listarNaves(String palabraClave) {

        if(palabraClave != null){
            return naveDao.findAll(palabraClave);
        }
        return (List<Nave>) naveDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Nave nave) {
    
        naveDao.save(nave);
    }

    @Override
    @Transactional
    public void eliminar(Nave nave) {
        naveDao.delete(nave);
    }

    @Override
    @Transactional(readOnly = true)
    public Nave buscar(Nave nave) {
        return naveDao.findById(nave.getId_nave()).orElse(null);
    }
    
}
