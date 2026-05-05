public class BookingManager {

    private BookingRepository repository;

    public BookingManager(BookingRepository repository) {
        this.repository = repository;
    }

    public boolean addBooking(String roomId) {
        if (repository.isAvailable(roomId)) {
            repository.save(roomId);
            return true;
        }
        return false;
    }

    public boolean cancelBooking(String roomId) {
        if (repository.exists(roomId)) {
            repository.delete(roomId);
            return true;
        }
        return false;
    }

    public boolean checkRoom(String roomId) {
        return repository.isAvailable(roomId);
    }
}

interface BookingRepository {
    boolean isAvailable(String roomId);
    void save(String roomId);
    void delete(String roomId);
    boolean exists(String roomId);
}
