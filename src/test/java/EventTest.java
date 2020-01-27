import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private LocalDateTime initialStart = LocalDateTime.of(2020, 1, 1, 12, 0, 30);
    private LocalDateTime initialEnd = LocalDateTime.of(2020, 1, 1, 13, 0, 30);

    private Event subject = new Event(1, initialStart, initialEnd);


    @Test
    void event_createdFromLocalDateTimes_shouldHideSeconds() {
        LocalDateTime expectedStart = LocalDateTime.of(2020, 1, 1, 12, 0);
        LocalDateTime expectedEnd = LocalDateTime.of(2020, 1, 1, 13, 0);

        assertEquals(subject.getRange().getStart(), expectedStart);
        assertEquals(subject.getRange().getEnd(), expectedEnd);
    }

    @Test
    void setRange_shouldHideSeconds() {
        LocalDateTime start = LocalDateTime.of(2020, 2, 2, 1, 20, 30);
        LocalDateTime end = LocalDateTime.of(2020, 2, 2, 1, 20, 30);

        LocalDateTime expectedStart = LocalDateTime.of(2020, 2, 2, 1, 20);
        LocalDateTime expectedEnd = LocalDateTime.of(2020, 2, 2, 1, 20);

        subject.setLocalDateTimeRange(start, end);

        assertEquals(subject.getRange().getStart(), expectedStart);
        assertEquals(subject.getRange().getEnd(), expectedEnd);
    }

    @Nested
    class isOverlapping {

        @Test
        void whenIsTouchingAtEnd_shouldBeFalse() {
            Event event = new Event(2, initialEnd, initialEnd.plusHours(1));

            assertFalse(subject.isOverlapping(event));
        }

        @Test
        void whenIsTouchingAtStart_shouldBeFalse() {
            Event event = new Event(2, initialStart.minusHours(1), initialStart);

            assertFalse(subject.isOverlapping(event));
        }

        @Test
        void whenStartIsOverlappingInMiddle_shouldBeTrue() {
            Event event = new Event(2, initialStart.plusMinutes(30), initialEnd.plusMinutes(30));

            assertTrue(subject.isOverlapping(event));
        }

        @Test
        void whenEndIsOverlappingInMiddle_shouldBeTrue() {
            Event event = new Event(2, initialStart.minusMinutes(30), initialEnd.minusMinutes(30));

            assertTrue(subject.isOverlapping(event));
        }

        @Test
        void whenOverlappingExactly_shouldBeTrue() {
            Event event = new Event(2, initialStart, initialEnd);

            assertTrue(subject.isOverlapping(event));
        }
    }
}