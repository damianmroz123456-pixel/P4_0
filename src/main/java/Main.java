import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.print("Podaj imię: ");
      String name = scanner.nextLine();
      System.out.print("Podaj wiek: ");
      int age = Integer.parseInt(scanner.nextLine());

      s.addStudent(new Student(name, age));
      System.out.println("Student dodany!");

      scanner.close();

    } catch (IOException e) {
      System.out.println("Błąd pliku: " + e.getMessage());
    }
  }
}
