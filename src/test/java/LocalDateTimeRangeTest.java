import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocalDateTimeRangeTest {

    private LocalDateTime initialStart = LocalDateTime.of(2020, 1, 1, 12, 0, 30);
    private LocalDateTime initialEnd = LocalDateTime.of(2020, 1, 1, 13, 0, 30);

    private LocalDateTimeRange subject = new LocalDateTimeRange(initialStart, initialEnd);

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isBefore {
        @Test
        void is_strictly_before_returns_true() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(2), initialEnd.plusHours(2));

            assertTrue(subject.isBefore(dateRange));
        }

        @Test
        void is_before_and_adjacent_returns_true() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(1), initialEnd.plusHours(1));

            assertTrue(subject.isBefore(dateRange));
        }

        @Test
        void is_overlapping_returns_false() {
            LocalDateTimeRange dateRange1 = new LocalDateTimeRange(initialStart.minusMinutes(30), initialEnd.minusMinutes(30));
            LocalDateTimeRange dateRange2 = new LocalDateTimeRange(initialStart.plusMinutes(30), initialEnd.plusMinutes(30));

            assertFalse(subject.isBefore(dateRange1));
            assertFalse(subject.isBefore(dateRange2));
        }

        @Test
        void is_after_and_adjacent_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(1), initialEnd.minusHours(1));

            assertFalse(subject.isBefore(dateRange));
        }

        @Test
        void is_strictly_after_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(2), initialEnd.minusHours(2));

            assertFalse(subject.isBefore(dateRange));
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isAfter {
        @Test
        void is_strictly_after_returns_true() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(2), initialEnd.minusHours(2));

            assertTrue(subject.isAfter(dateRange));
        }

        @Test
        void is_after_and_adjacent_returns_true() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(1), initialEnd.minusHours(1));

            assertTrue(subject.isAfter(dateRange));
        }

        @Test
        void is_overlapping_returns_false() {
            LocalDateTimeRange dateRange1 = new LocalDateTimeRange(initialStart.minusMinutes(30), initialEnd.minusMinutes(30));
            LocalDateTimeRange dateRange2 = new LocalDateTimeRange(initialStart.plusMinutes(30), initialEnd.plusMinutes(30));

            assertFalse(subject.isAfter(dateRange1));
            assertFalse(subject.isAfter(dateRange2));
        }

        @Test
        void is_before_and_adjacent_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(1), initialEnd.plusHours(1));

            assertFalse(subject.isAfter(dateRange));
        }

        @Test
        void is_strictly_before_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(2), initialEnd.plusHours(2));

            assertFalse(subject.isAfter(dateRange));
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isOverlapping {
        @Test
        void is_strictly_after_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(2), initialEnd.minusHours(2));

            assertFalse(subject.isOverlapping(dateRange));
        }

        @Test
        void is_after_and_adjacent_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.minusHours(1), initialEnd.minusHours(1));

            assertFalse(subject.isOverlapping(dateRange));
        }

        @Test
        void is_overlapping_returns_true() {
            LocalDateTimeRange dateRange1 = new LocalDateTimeRange(initialStart.minusMinutes(30), initialEnd.minusMinutes(30));
            LocalDateTimeRange dateRange2 = new LocalDateTimeRange(initialStart.plusMinutes(30), initialEnd.plusMinutes(30));

            assertTrue(subject.isOverlapping(dateRange1));
            assertTrue(subject.isOverlapping(dateRange2));
        }

        @Test
        void is_before_and_adjacent_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(1), initialEnd.plusHours(1));

            assertFalse(subject.isOverlapping(dateRange));
        }

        @Test
        void is_strictly_before_returns_false() {
            LocalDateTimeRange dateRange = new LocalDateTimeRange(initialStart.plusHours(2), initialEnd.plusHours(2));

            assertFalse(subject.isOverlapping(dateRange));
        }
    }
}