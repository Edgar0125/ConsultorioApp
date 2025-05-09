package mx.com.gm.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
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
public class Cita extends BaseEntity {

    private int idCita;
    private String nombrePaciente;
    private LocalDateTime horarioPaciente;
    @ManyToOne
    private Consultorio consultorio;
    @ManyToOne
    private Especialista doctor;
}
