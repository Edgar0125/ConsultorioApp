package mx.com.gm.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Calss cita.
 *
 */
@Setter
@Getter
@Entity
public class Cita  {

    //private int idCita;
    @Id
    private Long id;
    private String nombrePaciente;
    private LocalDateTime citaHora;
    @ManyToOne
    private Consultorio consultorio;
    @ManyToOne
    private Especialista doctor;


}
