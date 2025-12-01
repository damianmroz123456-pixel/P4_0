import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("=== MENU ===");
                System.out.println("1 – Dodaj nowego studenta");
                System.out.println("2 – Wyświetl wszystkich studentów");
                System.out.println("3 – Wyjście");
                System.out.print("Wybierz opcję: ");

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Podaj imię: ");
                    String name = scanner.nextLine();

                    System.out.print("Podaj wiek: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Podaj kierunek studiów: ");
                    String major = scanner.nextLine();

                    System.out.print("Podaj datę urodzenia: ");
                    String birthDate = scanner.nextLine();

                    s.addStudent(new Student(name, age, major, birthDate));
                    System.out.println("Student dodany!\n");
                }
                else if (choice == 2) {
                    var students = s.getStudents();
                    System.out.println("\n--- Lista studentów ---");
                    for (Student st : students) {
                        System.out.println(st.ToString());
                    }
                    System.out.println();
                }
                else if (choice == 3) {
                    System.out.println("Koniec programu.");
                    break;
                }
                else {
                    System.out.println("Niepoprawna opcja!\n");
                }
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Błąd pliku: " + e.getMessage());
        }
    }
}
