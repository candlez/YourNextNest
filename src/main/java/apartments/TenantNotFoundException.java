package apartments;

public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
