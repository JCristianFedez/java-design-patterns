package iterator.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {

  private final String name;

  private final String email;

  private final Map<String, List<String>> contacts = new HashMap<>();

  public Profile(final String email, final String name, final String... contacts) {
    this.email = email;
    this.name = name;
    this.parseContacts(contacts);
  }

  private void parseContacts(final String... contacts) {
    for (final String contact : contacts) {
      final String[] parts = contact.split(":");
      String contactType = "friend";
      String contactEmail;
      if (parts.length == 1) {
        contactEmail = parts[0];
      } else {
        contactType = parts[0];
        contactEmail = parts[1];
      }

      this.contacts.computeIfAbsent(contactType, type -> new ArrayList<>());
      this.contacts.get(contactType).add(contactEmail);
    }
  }

  public String getEmail() {
    return email;
  }

  public List<String> getContacts(final String contactType) {
    return this.contacts.get(contactType);
  }
}
