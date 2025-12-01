public class Student {
  private String Name;
  private int Age;
  private String Major;
  private String BirthDate;
  public Student(String name, int age, String major, String birthDate) {
    Name = name;
    Age = age;
    Major = major;
    BirthDate = birthDate;
  }
  public String GetName() { return Name; }
  public int GetAge() { return Age; }
  public String GetMajor() { return Major; }
  public String GetBirthDate() { return BirthDate; }
  public String ToString() {
    return Name + " " + Age + " " + Major+  " " + BirthDate;
  }
  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4)
      return new Student("ParseError", -1, "None", "Unknown");
    return new Student(data[0], Integer.parseInt(data[1]), data[2], data[3]);
  }
}