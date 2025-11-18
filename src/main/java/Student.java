public class Student {

  private String Name;
  private int Age;
  private String Major;

  public Student(String name, int age, String major) {
    Name = name;
    Age = age;
    Major = major;
  }

  public String GetName() { return Name; }
  public int GetAge() { return Age; }
  public String GetMajor() { return Major; }

  public String ToString() {
    return Name + " " + Age + " " + Major;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3)
      return new Student("ParseError", -1, "None");
    return new Student(data[0], Integer.parseInt(data[1]), data[2]);
  }
}
