package mx.com.gm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.model.Cita;
import mx.com.gm.repository.CitaRepository;
import mx.com.gm.repository.ConsultorioRepository;
import mx.com.gm.repository.EspecialistaRepository;
import mx.com.gm.service.CitaService;
import mx.com.gm.service.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/citas")
public class ControladorInicio {
@GetMapping ("/view")
    public String view(Model model) {
    //model.addAttribute("citas", new Cita());
    model.addAttribute("title","Hola mundo");
return "view";
    }

    @Autowired
    private CitaServiceImpl citaService;
    @Autowired
    private EspecialistaRepository doctorRepository;
    @Autowired
    private ConsultorioRepository consultorioRepository;

    @GetMapping("/new")
    public String showAppointmentForm(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("doctor", doctorRepository.findAll());
        model.addAttribute("consultorio", consultorioRepository.findAll());
        model.addAttribute("message", "Hola mundo");
        return "citas-formulario";
    }


    @PostMapping("/cita-prueb")
    public String createAppointment(@ModelAttribute("cita") Cita cita,RedirectAttributes redirectAttributes) {///ResponseEntity<?>
        try {

            //citaService.save(cita);
            citaService.validateAndSave(cita);
            redirectAttributes.addFlashAttribute("message", "La cita se creo correctamente!");
            //return ResponseEntity.ok(Map.of("message", "Appointment created successfully", "appointment", cita));
            return "redirect:/citas/listarCitas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            //return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
            return "redirect:/citas/new";
        }
    }

    @GetMapping("/listarCitas1")
    public List<Cita> listCitas(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long roomId
    ) {
        if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date);
            if (doctorId != null) {
                return citaService.findByDoctorAndDate(doctorId, localDate);
            } else if (roomId != null) {
                return citaService.findByConsultingRoomAndDate(roomId, localDate);
            } else {
                return citaService.findByDate(localDate);
            }
        }
        return citaService.findByDate(LocalDate.now());
    }


    @GetMapping("/listarCitas")
    public String listAppointments(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long roomId,
            Model model
    ) {
        List<Cita> appointments;
        if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date);
            if (doctorId != null) {
                appointments = citaService.findByDoctorAndDate(doctorId, localDate);
            } else if (roomId != null) {
                appointments = citaService.findByConsultingRoomAndDate(roomId, localDate);
            } else {
                appointments = citaService.findByDate(localDate);
            }
        } else {
            appointments = citaService.findByDate(LocalDate.now());
        }

        model.addAttribute("citas", appointments);
        model.addAttribute("doctor", doctorRepository.findAll());
        model.addAttribute("consultorio", consultorioRepository.findAll());
        return "listar-citas";
    }
/*
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Cita appointment = citaService.citaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
            model.addAttribute("appointment", appointment);
            model.addAttribute("doctors", doctorRepository.findAll());
            model.addAttribute("consultingRooms", consultingRoomRepository.findAll());
            return "appointment-form";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/appointments";
        }

    }*/

    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        try {
            cita.setId(id);
            citaService.validateAndSave(cita);
            redirectAttributes.addFlashAttribute("message", "La cita se actualizo correctamente!");
            return "redirect:/citas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/citas/edit/" + id;
        }
    }
/*
    @PostMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            citaService.cancelAppointment(id);
            redirectAttributes.addFlashAttribute("message", "La cita se cancelo correctamente !");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/appointments";
    }*/
}
