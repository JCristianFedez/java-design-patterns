package templatemethod;

import java.util.Scanner;

import templatemethod.networks.Facebook;
import templatemethod.networks.Network;
import templatemethod.networks.Twitter;

public class Demo {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce el nombre de usuario: ");
    final String userName = scanner.nextLine();
    System.out.print("Introduce la contraseña: ");
    final String password = scanner.nextLine();

    System.out.print("Escriba su mensaje: ");
    final String message = scanner.nextLine();

    System.out.println("\n Elija la red social donde va a postear el mensaje");
    System.out.println("1 - Facebook");
    System.out.println("2 - Twitter");
    final int networkChoise = scanner.nextInt();

    final Network network = networkChoise == 1 ? new Facebook(userName, password)
        : new Twitter(userName, password);
    network.post(message);
  }
}
