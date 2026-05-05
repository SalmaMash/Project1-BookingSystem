@ -0,0 +1,45 @@
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class BookingManagerTest {

    @Test
    public void addBooking_workingCase() {
        BookingRepository repo = mock(BookingRepository.class);
        when(repo.isAvailable("A1")).thenReturn(true);

        BookingManager manager = new BookingManager(repo);

        boolean result = manager.addBooking("A1");

        assertTrue(result);
        verify(repo).save("A1");
    }

    @Test
    public void addBooking_notAvailable() {
        BookingRepository repo = mock(BookingRepository.class);
        when(repo.isAvailable("A1")).thenReturn(false);

        BookingManager manager = new BookingManager(repo);

        boolean result = manager.addBooking("A1");

        assertFalse(result);
    }

    @Test
    public void cancelBooking_working() {
        BookingRepository repo = mock(BookingRepository.class);
        when(repo.exists("A1")).thenReturn(true);

        BookingManager manager = new BookingManager(repo);

        boolean result = manager.cancelBooking("A1");

        assertTrue(result);
        verify(repo).delete("A1");
    }
}