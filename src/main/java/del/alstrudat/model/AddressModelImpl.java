package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class AddressModelImpl implements AddressModel {
    private final AddressRepository addressRepository;

    public AddressModelImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void addAddress(String username, String detail) {
        addressRepository.addAddress(new Address(username, detail));
    }

    @Override
    public List<Address> getAddresses(String username) {
        return addressRepository.getAddressesByUsername(username);
    }

    @Override
    public void updateAddress(String username, String oldDetail, String newDetail) {
        Address oldAddress = getAddresses(username).stream()
                .filter(a -> a.getDetail().equals(oldDetail))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Alamat tidak ditemukan."));
        addressRepository.deleteAddress(username, oldDetail);
        addressRepository.addAddress(new Address(username, newDetail));
    }

    @Override
    public void deleteAddress(String username, String detail) {
        addressRepository.deleteAddress(username, detail);
    }

    @Override
    public String toString() {
        return "AddressModelImpl{addressRepository=" + addressRepository + "}";
    }
}