import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCalendar {

    private List<Event> events;

    public MyCalendar() {
        this.events = new ArrayList<>();
    }

    public MyCalendar(List<Event> events) {
        this.events = new ArrayList<>(events);
    }

    public List<Event> getEvents() {
        return events;
    }

    public boolean addEvent(Event event) {
        return this.events.add(event);
    }

    public boolean removeEvent(Event event) {
        return this.events.remove(event);
    }

    public List<Pair> findConflictingEvents() {
        int size = events.size();

        List<Pair> conflicting = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Event event = events.get(i);
            conflicting.addAll(events.subList(i, size)
                    .stream()
                    .filter(e -> e.getId() != event.getId())
                    .filter(event::isOverlapping)
                    .map(e -> new Pair<>(event, e))
                    .collect(Collectors.toList())
            );
        }

        return conflicting;
    }
}
