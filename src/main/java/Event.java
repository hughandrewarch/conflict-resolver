import java.time.LocalDateTime;
import java.util.Objects;

public class Event {

    private long id;
    private LocalDateTimeRange range;

    public Event(long id, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        setLocalDateTimeRange(start, end);
    }

    public long getId() {
        return id;
    }

    public LocalDateTimeRange getRange() {
        return range;
    }

    public void setLocalDateTimeRange(LocalDateTime start, LocalDateTime end) {

        LocalDateTime rangeStart = LocalDateTime.of(start.getYear(), start.getMonth(), start.getDayOfMonth(), start.getHour(), start.getMinute());
        LocalDateTime rangeEnd = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), end.getHour(), end.getMinute());

        range = new LocalDateTimeRange(rangeStart, rangeEnd);
    }

    public boolean isOverlapping(Event that) {
        return this.getRange().isOverlapping(that.getRange());
    }

    @Override
    public String toString() {
        return "Event " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
