package mx.com.gm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Consultorio.
 */
@Setter
@Getter
@Entity
public class Consultorio{


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String numero;
    private int piso;

}
