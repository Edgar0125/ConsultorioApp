package mx.com.gm.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Especialista.
 */
@Setter
@Getter
@Entity
public class Especialista extends BaseEntity {

  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String especialidad;
}
