package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public class AddressRepositoryImpl implements AddressRepository {
    private final Map<String, List<Address>> addresses;

    public AddressRepositoryImpl() {
        this.addresses = new HashMap<>();
    }

    @Override
    public void addAddress(Address address) {
        validateAddress(address);
        List<Address> userAddresses = addresses.computeIfAbsent(address.getUsername(), k -> new ArrayList<>()); 
        userAddresses.add(address);
    }

    @Override
    public List<Address> getAddressesByUsername(String username) {
        validateString(username, "Username");
        return addresses.getOrDefault(username, new ArrayList<>());
    }

    @Override
    public void updateAddress(Address address) {
        validateAddress(address);
        List<Address> userAddresses = addresses.get(address.getUsername());
        if (userAddresses == null) {
            throw new IllegalArgumentException("Alamat tidak ditemukan.");
        }
        for (int i = 0; i < userAddresses.size(); i++) {
            if (userAddresses.get(i).getDetail().equals(address.getDetail())) {
                userAddresses.set(i, address);
                return;
            }
        }
        throw new IllegalArgumentException("Alamat tidak ditemukan.");
    }

    @Override
    public void deleteAddress(String username, String detail) {
        validateString(username, "Username");
        validateString(detail, "Detail");
        List<Address> userAddresses = addresses.get(username);
        if (userAddresses != null) {
            userAddresses.removeIf(address -> address.getDetail().equals(detail));
            if (userAddresses.isEmpty()) {
                addresses.remove(username);
            }
        }
    }

    @Override
    public String toString() {
        return "AddressRepositoryImpl{addresses=" + addresses.size() + "}";
    }

    private void validateAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Alamat tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}