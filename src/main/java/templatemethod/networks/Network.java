package templatemethod.networks;

public abstract class Network {

  private final String userName;

  private final String password;

  Network(final String userName, final String password) {
    this.userName = userName;
    this.password = password;
  }

  public boolean post(final String message) {
    if (this.logIn(this.getUserName(), this.getPassword())) {
      final boolean result = this.sendData(message.getBytes());
      this.logOut();
      return result;
    }
    return false;
  }

  abstract boolean logIn(final String userName, final String password);

  abstract boolean sendData(final byte[] data);

  abstract void logOut();

  String getUserName() {
    return this.userName;
  }

  String getPassword() {
    return this.password;
  }
}
