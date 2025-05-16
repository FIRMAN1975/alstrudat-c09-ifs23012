package del.alstrudat.entity;

public class Notification {
    private final String username;
    private final String message;
    private boolean read;

    public Notification(String username, String message) {
        validateString(username, "Username");
        validateString(message, "Message");
        this.username = username;
        this.message = message;
        this.read = false;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Notification{username='" + username + "', message='" + message + "', read=" + read + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}