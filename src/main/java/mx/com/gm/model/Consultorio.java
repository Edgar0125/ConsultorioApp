package mx.com.gm.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Consultorio.
 */
@Setter
@Getter
@Entity
public class Consultorio extends BaseEntity{

    private Long id;
    private String numero;
    private int piso;
}
