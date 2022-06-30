
package naves.com.sofka.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author FELIPE
 */
@Data
@Entity
@Table(name = "nave")
public class Nave implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nave;
    private String nombre_nave;
    private String categoria;
    private String pais;
    
    
    
}
