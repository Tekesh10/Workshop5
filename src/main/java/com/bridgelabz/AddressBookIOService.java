package com.bridgelabz;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
public class AddressBookIOService {
    public void writeContactDetails(Map<String, List<Contacts>> addressBooks) {
        Path path = Paths.get("ContactDetails.txt");
        StringBuilder contactDetailsBuilder = new StringBuilder();
        addressBooks.keySet().forEach(keyOfBook -> {
            contactDetailsBuilder.append("\n").append(keyOfBook).append("->\n");
            addressBooks.get(keyOfBook).forEach(contacts -> {
                String string = contacts.toString();
                contactDetailsBuilder.append(string);
            });
        });
    }
}
