import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class main{
    static String status = "urut berdasar waktu", pasienSaatIni="tidak ada";
    static int input, tingkatKeparahan;
    static Scanner scanStr = new Scanner(System.in).useDelimiter("\n");
    static Scanner scanInt = new Scanner(System.in).useDelimiter("\n");
    static QueueIO db = new QueueIO();
    public static void main(String args[]){
        db.readFile();
        prosesMenu();
    }

    static void prosesMenu() {
        tampilanMenu();
        switch (input) {
            case 1:
                String namaPasien = "";
                int keparahan;
                System.out.println("masukkan nama pasien: ");
                namaPasien = scanStr.next();
                System.out.println("masukkan tingkat keparahan: ");
                keparahan = scanInt.nextInt();
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                int waktu = Integer.parseInt(sdf.format(cal.getTime()));
                db.fileQueue.enqueue(namaPasien,keparahan,waktu);
                db.writeFile();
                System.out.println("sukses menambah pasien: " + namaPasien);
                break;
            case 2:
                db.fileQueue.sortByWaktu();
                db.writeFile();
                status = "urut berdasar waktu";
                System.out.println("sukses mengurutkan berdasar waktu");
                break;
            case 3:
                db.fileQueue.sortByKeparahan();
                db.writeFile();
                status = "urut berdasar keparahan";
                System.out.println("sukses mengurutkan berdasar keparahan");
                break;
            case 4:
                db.fileQueue.readData();
                break;
            case 5:
                pasienSaatIni = db.fileQueue.getNameSaatIni();
                tingkatKeparahan = db.fileQueue.getKeparahanSaatIni();
                db.fileQueue.dequeue();
                db.writeFile();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("pilihan input tidak ada");
                break;
        }
        input = -1;
        prosesMenu();
    }
    static void tampilanMenu(){
        System.out.println("\nStatus: " + status
                +"\npasien saat ini: " + pasienSaatIni
                +"\ntingkat keparahan: " + tingkatKeparahan
                +"\n1. Tambah pasien"
                +"\n2. Urutkan berdasar waktu pasien mendaftar"
                +"\n3. Urutkan berdasar keparahan pasien"
                +"\n4. Lihat list pasien sesuai status"
                +"\n5. Panggil pasien"
                +"\n6. Keluar"
                +"\nmasukkan menu: ");
        input = scanInt.nextInt();
    }
}
