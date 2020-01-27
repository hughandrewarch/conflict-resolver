import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

public class LocalDateTimeRange {

    private LocalDateTime start;
    private LocalDateTime end;

    public LocalDateTimeRange(LocalDateTime start, LocalDateTime end) {
        if(start.isAfter(end)) {
            throw new InstantiationError("The end must be after the start");
        }

        setStart(start);
        setEnd(end);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setStart(LocalDateTime time) {
        this.start = time;
    }

    public void setEnd(LocalDateTime time) {
        this.end = time;
    }

    public boolean isBefore(LocalDateTimeRange that) {
        LocalDateTime thatStart = that.getStart();

        return this.end.isBefore(thatStart) || this.end.isEqual(thatStart);
    }

    public boolean isAfter(LocalDateTimeRange that) {
        LocalDateTime thatEnd = that.getEnd();

        return this.start.isAfter(thatEnd) || this.start.isEqual(thatEnd);
    }

    public boolean isOverlapping(LocalDateTimeRange that) {
        return !(this.isBefore(that) || this.isAfter(that));
    }
}
