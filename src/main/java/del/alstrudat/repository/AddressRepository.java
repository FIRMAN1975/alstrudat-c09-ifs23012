package del.alstrudat.repository;

import del.alstrudat.entity.Address;
import java.util.*;

public interface AddressRepository {
    void addAddress(Address address);
    List<Address> getAddressesByUsername(String username);
    void updateAddress(Address address);
    void deleteAddress(String username, String detail);
}