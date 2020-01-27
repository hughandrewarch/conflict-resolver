import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        LocalDateTime start = LocalDateTime.of(2020, 1, 1, 12, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 1, 13, 0);

        List<Event> events = new ArrayList<>();
        events.add(new Event(1, start, end));
        events.add(new Event(2, start.plusMinutes(30), end.plusMinutes(30)));
        events.add(new Event(3, start.plusMinutes(60), end.plusMinutes(60)));
        events.add(new Event(4, start.plusMinutes(90), end.plusMinutes(90)));
        events.add(new Event(5, start, end.plusMinutes(120)));
        events.add(new Event(6, start.minusHours(1), end.minusHours(1)));

        MyCalendar calendar = new MyCalendar(events);

        calendar.findConflictingEvents()
                .forEach(Main::printConflict);
    }

    private static void printConflict(Pair<Event, Event> pair) {
        System.out.println(pair.getLeft() + " has a conflict with " + pair.getRight());
    }
}
