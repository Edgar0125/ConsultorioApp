package mx.com.gm.config;

import mx.com.gm.model.Consultorio;
import mx.com.gm.model.Especialista;
import mx.com.gm.repository.ConsultorioRepository;
import mx.com.gm.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EspecialistaRepository doctorRepository;
    @Autowired
    private ConsultorioRepository consultingRoomRepository;
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {


        // Initialize Doctors
        Especialista doctor1 = new Especialista();
        doctor1.setNombre("Juan");
        doctor1.setApellidoPaterno("Ramos");
        doctor1.setApellidoMaterno("Pérez");
        doctor1.setEspecialidad("Medicina Interna");
        doctorRepository.save(doctor1);

        Especialista doctor2 = new Especialista();
        doctor2.setNombre("María");
        doctor2.setApellidoPaterno("Gómez");
        doctor2.setApellidoMaterno("López");
        doctor2.setEspecialidad("Medicina Interna");
        doctorRepository.save(doctor2);

        Especialista doctor3 = new Especialista();
        doctor3.setNombre("Carlos");
        doctor3.setApellidoPaterno("Martínez");
        doctor3.setApellidoMaterno("Sánchez");
        doctor3.setEspecialidad("Medicina Interna");
        doctorRepository.save(doctor3);

        // Initialize Consulting Rooms
        Consultorio consultorio1 = new Consultorio();
        consultorio1.setNumero("101");
        consultorio1.setPiso(1);
        consultingRoomRepository.save(consultorio1);

        Consultorio consultorio2 = new Consultorio();
        consultorio2.setNumero("102");
        consultorio2.setPiso(1);
        consultingRoomRepository.save(consultorio2);

        Consultorio consultorio3 = new Consultorio();
        consultorio3.setNumero("201");
        consultorio3.setPiso(2);
        consultingRoomRepository.save(consultorio2);
    }

}
