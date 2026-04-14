import java.util.Scanner;

public class NilaiMhs {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String nim, nama, grade;
        Double uts, uas, rata;

        System.out.println("data: ");
        System.out.println("nim: "); nim = input.next();
        System.out.println("nama: "); nama = input.next();
        System.out.println("nilai UTS: "); uts = input.nextDouble();
        System.out.println("uas: "); uas = input.nextDouble();

        rata = (uts+uas)/2;

        if (rata<50)
            grade = "E";
        else if (rata<60)
            grade = "D";
        else if (rata<70)
            grade = "C";
        else if (rata<80)
            grade = "B";
        else
            grade = "A";

        System.out.println("========================================================");
        System.out.println("NIM\tNama\tUTS\tUAS\tRata2\tGrade");
        System.out.println("========================================================");
        System.out.println(nim+"\t" +nama+ "\t" +uts+ "\t" +uas+ "\t" +rata+ "\t" +grade);

        System.out.println("");
        System.out.println("");
    }
}