package del.alstrudat.entity;
public class Address {
    private final String username;
    private final String detail;

    public Address(String username, String detail) {
        validateString(username, "Username");
        validateString(detail, "Detail");
        this.username = username;
        this.detail = detail;
    }

    public String getUsername() {
        return username;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "Address{username='" + username + "', detail='" + detail + "'}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}