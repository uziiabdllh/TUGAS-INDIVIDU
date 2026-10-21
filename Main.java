public class Main {
    public static void main(String[] args) {
        // 1. Buat Objek Course
        Course javaCourse = new Course();
        javaCourse.setTitle("Pemrograman Berorientasi Objek");

        // 2. Buat Data Mahasiswa 1
        Student student1 = new Student();
        student1.setName("Budi");

        Assignment assign1 = new Assignment();
        assign1.setMark(85);

        Assignment assign2 = new Assignment();
        assign2.setMark(90);

        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);
        record1.addAssignment(assign1);
        record1.addAssignment(assign2);

        // 3. Buat Data Mahasiswa 2
        Student student2 = new Student();
        student2.setName("Siti");

        Assignment assign3 = new Assignment();
        assign3.setMark(50);

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);
        record2.addAssignment(assign3);

        // 4. Tambahkan record ke Course
        javaCourse.addCourseRecord(record1);
        javaCourse.addCourseRecord(record2);

        // 5. Uji Coba Fungsi Method
        System.out.println("=== DAFTAR MAHASISWA ===");
        javaCourse.printCourseStudents();

        System.out.println("\n=== MAHASISWA TERBAIK ===");
        javaCourse.printBestStudent();

        System.out.println("\n=== MAHASISWA LAYAK UJIAN AKHIR ===");
        javaCourse.printFinalExamStudents();
    }
}