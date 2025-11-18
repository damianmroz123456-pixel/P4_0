import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("1 – Dodaj studenta");
      System.out.println("2 – Wyświetl wszystkich studentów");
      System.out.print("Wybierz opcję: ");

      int choice = Integer.parseInt(scanner.nextLine());

      if(choice == 1) {
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj wiek: ");
        int age = Integer.parseInt(scanner.nextLine());

        s.addStudent(new Student(name, age));
        System.out.println("Student dodany!");
      }
      else if(choice == 2) {
        var students = s.getStudents();
        for(Student current : students) {
          System.out.println(current.ToString());
        }
      }

    } catch (IOException e) {
      System.out.println("Błąd pliku: " + e.getMessage());
    }
  }
}
