package project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.demo.entity.EventSchedule;
import project.demo.service.EventScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-schedule")
public class EventScheduleController {

    @Autowired
    private EventScheduleService service;

    @GetMapping
    public List<EventSchedule> getAllEventSchedules() {
        return service.getAllEventSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventSchedule> getEventScheduleById(@PathVariable Long id) {
        Optional<EventSchedule> eventSchedule = service.getEventScheduleById(id);
        return eventSchedule.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public EventSchedule createEventSchedule(@RequestBody EventSchedule eventSchedule) {
        return service.createEventSchedule(eventSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventSchedule> updateEventSchedule(@PathVariable Long id, @RequestBody EventSchedule newEventSchedule) {
        return ResponseEntity.ok(service.updateEventSchedule(id, newEventSchedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventSchedule(@PathVariable Long id) {
        service.deleteEventSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
