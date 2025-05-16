package del.alstrudat.model;


import java.util.List;
import del.alstrudat.entity.Address;

public interface AddressModel {
    void addAddress(String username, String detail);
    List<Address> getAddresses(String username);
    void updateAddress(String username, String oldDetail, String newDetail);
    void deleteAddress(String username, String detail);
}