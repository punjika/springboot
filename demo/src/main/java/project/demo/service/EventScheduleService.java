package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.EventSchedule;
import project.demo.repository.EventScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventScheduleService {

    @Autowired
    private EventScheduleRepository repository;

    public List<EventSchedule> getAllEventSchedules() {
        return repository.findAll();
    }

    public Optional<EventSchedule> getEventScheduleById(Long id) {
        return repository.findById(id);
    }

    public EventSchedule createEventSchedule(EventSchedule eventSchedule) {
        return repository.save(eventSchedule);
    }

    public EventSchedule updateEventSchedule(Long id, EventSchedule newEventSchedule) {
        return repository.findById(id)
                .map(event -> {
                    event.setTime(newEventSchedule.getTime());
                    event.setDate(newEventSchedule.getDate());
                    event.setVenueID(newEventSchedule.getVenueID());
                    event.setCoordinatorID(newEventSchedule.getCoordinatorID());
                    return repository.save(event);
                })
                .orElseGet(() -> {
                    newEventSchedule.setId(id);
                    return repository.save(newEventSchedule);
                });
    }

    public void deleteEventSchedule(Long id) {
        repository.deleteById(id);
    }
}
