import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service {
    public void addStudent(Student student) throws IOException {
        var f = new FileWriter("db.txt", true);
        var b = new BufferedWriter(f);
        b.append(student.ToString());
        b.newLine();
        b.close();
    }
    public Collection<Student> getStudents() throws IOException {
        var ret = new ArrayList<Student>();
        var reader = new BufferedReader(new FileReader("db.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            ret.add(Student.Parse(line));
        }
        reader.close();
        return ret;
    }
    public Student findStudentByName(String name) {
        try {
            var students = getStudents();
            for (Student st : students) {
                if (st.GetName().equalsIgnoreCase(name)) {
                    return st;
                }
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }
    public boolean deleteStudentByName(String name) {
        try {
            var students = getStudents();
            boolean removed = false;
            students.removeIf(st -> st.GetName().equalsIgnoreCase(name));
            var writer = new BufferedWriter(new FileWriter("db.txt", false));
            for (Student st : students) {
                writer.write(st.ToString());
                writer.newLine();
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
