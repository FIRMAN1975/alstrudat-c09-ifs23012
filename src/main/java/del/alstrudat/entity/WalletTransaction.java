package del.alstrudat.entity;

public class WalletTransaction {
    public enum Type {
        DEPOSIT, DEBIT
    }

    private final String transactionId;
    private final Type type;
    private final double amount;
    private final String description;

    public WalletTransaction(String transactionId, Type type, double amount, String description) {
        validateString(transactionId, "Transaction ID");
        if (type == null) {
            throw new IllegalArgumentException("Tipe tidak valid: tidak boleh null.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        validateString(description, "Description");
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "WalletTransaction{transactionId='" + transactionId + "', type=" + type + ", amount=" + amount + ", description='" + description + "'}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}