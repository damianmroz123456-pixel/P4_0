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
                System.out.println("3 – Znajdź studenta po imieniu");
                System.out.println("4 – Usuń studenta");
                System.out.println("5 – Zaktualizuj dane studenta");
                System.out.println("6 – Wyjście");
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
                    System.out.print("Podaj imię studenta: ");
                    String name = scanner.nextLine();
                    Student st = s.findStudentByName(name);
                    if (st == null) {
                        System.out.println("Nie znaleziono studenta.\n");
                    } else {
                        System.out.println("Znaleziono: " + st.ToString() + "\n");
                    }
                }
                else if (choice == 4) {
                    System.out.print("Podaj imię studenta do usunięcia: ");
                    String name = scanner.nextLine();
                    boolean ok = s.deleteStudentByName(name);
                    if (ok) System.out.println("Usunięto studenta.\n");
                    else System.out.println("Nie znaleziono studenta lub wystąpił błąd.\n");
                }
                else if (choice == 5) {
                    System.out.print("Podaj imię studenta do aktualizacji: ");
                    String name = scanner.nextLine();
                    System.out.print("Podaj nowy wiek: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    boolean ok = s.updateStudentAgeByName(name, newAge);
                    if (ok) System.out.println("Zaktualizowano dane studenta.\n");
                    else System.out.println("Nie znaleziono studenta lub wystąpił błąd.\n");
                }
                else if (choice == 6) {
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