package mx.com.gm.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Calss cita.
 *
 */
@Setter
@Getter
@Entity
@Table(name = "cita")
public class Cita  extends BaseEntity{

    //private int idCita;
    /*@Id
    private Long id;*/
    private String nombrePaciente;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime citaHora;
    @ManyToOne
    private Consultorio consultorio;
    @ManyToOne
    private Especialista doctor;


}
