import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords; 

    public Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() { 
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        // Mencetak seluruh mahasiswa yang mengambil course
        Enumeration<CourseRecord> e = courseRecords.elements();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            System.out.println(cr.getStudent().getName());
        }
    }

    public void printBestStudent() {
        // Mencetak mahasiswa dengan nilai rata-rata tugas terbaik
        Enumeration<CourseRecord> e = courseRecords.elements();
        Student bestStudent = null;
        double maxAverage = -1.0;

        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            Enumeration<Assignment> assignments = cr.getAssignments();
            double totalMark = 0;
            int count = 0;

            try {
                while (assignments.hasMoreElements()) {
                    Assignment a = assignments.nextElement();
                    totalMark += a.getMark();
                    count++;
                }
            } catch (NotYetSetException ex) {
                
            }

            if (count > 0) {
                double average = totalMark / count;
                if (average > maxAverage) {
                    maxAverage = average;
                    bestStudent = cr.getStudent();
                }
            }
        }

        if (bestStudent != null) {
            System.out.println("Best Student: " + bestStudent.getName() + " with average: " + maxAverage);
        } else {
            System.out.println("No student data available.");
        }
    }

    public void printFinalExamStudents() {
        // Mencetak mahasiswa yang layak ujian akhir (rata-rata >= 60.0)
        Enumeration<CourseRecord> e = courseRecords.elements();
        
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            Enumeration<Assignment> assignments = cr.getAssignments();
            double totalMark = 0;
            int count = 0;

            try {
                while (assignments.hasMoreElements()) {
                    Assignment a = assignments.nextElement();
                    totalMark += a.getMark();
                    count++;
                }
            } catch (NotYetSetException ex) {
                
            }

            if (count > 0) {
                double average = totalMark / count;
                if (average >= 60.0) {
                    System.out.println(cr.getStudent().getName() + " (Eligible with average: " + average + ")");
                }
            }
        }
    }
}