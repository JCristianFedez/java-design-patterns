package com.cristian.design.patterns;

class Demo {

  public static void main(String[] args) {
    dtoToUser();
    userToDto();
  }

  private static void userToDto() {
    final UserConverter userConverter = new UserConverter();
    final User user = new User("Carlos", "Smith", false, "email@something.com");
    final UserDto userDto = userConverter.convertFromEntity(user);

    print(user, userDto);
  }

  private static void dtoToUser() {
    final UserConverter userConverter = new UserConverter();
    final UserDto userDto = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
    final User user = userConverter.convertFromDto(userDto);

    print(user, userDto);
  }

  private static void print(final User user, final UserDto userDto) {
    System.out.println(user);
    System.out.println(userDto);
    System.out.println("================================");
  }
}
