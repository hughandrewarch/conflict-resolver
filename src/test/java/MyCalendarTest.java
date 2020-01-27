import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyCalendarTest {

    private LocalDateTime timeA = LocalDateTime.of(2020, 1, 1, 12, 0);
    private LocalDateTime timeB = LocalDateTime.of(2020, 1, 1, 12, 30);
    private LocalDateTime timeC = LocalDateTime.of(2020, 1, 1, 13, 0);
    private LocalDateTime timeD = LocalDateTime.of(2020, 1, 1, 13, 30);

    private Event eventA = new Event(1, timeA, timeA.plusHours(1));
    private Event eventB = new Event(2, timeB, timeB.plusHours(1));
    private Event eventC = new Event(3, timeC, timeC.plusHours(1));
    private Event eventD = new Event(4, timeD, timeD.plusHours(1));

    @Test
    void getEvents() {
        List<Event> events = Arrays.asList(eventA, eventB, eventC);

        MyCalendar calendar = new MyCalendar(events);

        assertEquals(calendar.getEvents(), events);
    }

    @Test
    void addEvent() {
        List<Event> events = Arrays.asList(eventA, eventB, eventC);

        MyCalendar calendar = new MyCalendar(events);
        calendar.addEvent(eventD);

        assertEquals(calendar.getEvents(), Arrays.asList(eventA, eventB, eventC, eventD));
    }

    @Test
    void removeEvent() {
        List<Event> events = Arrays.asList(eventA, eventB, eventC);

        MyCalendar calendar = new MyCalendar(events);
        calendar.removeEvent(eventC);

        assertEquals(calendar.getEvents(), Arrays.asList(eventA, eventB));
    }
}