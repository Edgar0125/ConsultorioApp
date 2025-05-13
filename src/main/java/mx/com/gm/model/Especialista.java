package mx.com.gm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Especialista.
 */
@Setter
@Getter
@Entity
public class Especialista extends BaseEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String especialidad;
}
