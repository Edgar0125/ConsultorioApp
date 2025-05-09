package mx.com.gm.controller;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.model.Cita;
import mx.com.gm.repository.ConsultorioRepository;
import mx.com.gm.repository.EspecialistaRepository;
import mx.com.gm.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/citas")
public class ControladorInicio {


    @Autowired
    private CitaService citaService;
    @Autowired
    private EspecialistaRepository doctorRepository;
    @Autowired
    private ConsultorioRepository consultorioRepository;

    @GetMapping("/new")
    public String showAppointmentForm(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("doctores", doctorRepository.findAll());
        model.addAttribute("consultorios", consultorioRepository.findAll());
        return "appointment-form";
    }

    @PostMapping
    public String createAppointment(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        try {
            citaService.validateAndSave(cita);
            redirectAttributes.addFlashAttribute("message", "La cita se creo correctamente!");
            return "redirect:/citas";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/citas/new";
        }
    }

    @GetMapping
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

        model.addAttribute("appointments", appointments);
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("consultingRooms", consultorioRepository.findAll());
        return "appointment-list";
    }

   /* @GetMapping("/edit/{id}")
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

    @PostMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            citaService.cancelAppointment(id);
            redirectAttributes.addFlashAttribute("message", "La cita se cancelo correctamente !");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/appointments";
    }
}
