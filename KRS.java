import java.util.ArrayList;
import java.util.Scanner;

class MataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public int getSks() {
        return sks;
    }

    public String toString() {
        return kode + " - " + nama + " (" + sks + " SKS)";
    }
}
class Mahasiswa {
    private String nim;
    private String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}
class karturencanastudi {
    private Mahasiswa mahasiswa;
    private ArrayList<MataKuliah> daftarMK;
    private int totalSKS = 0;
    private final int MAKS_SKS = 24;
    private String namaKPS;

    public karturencanastudi(Mahasiswa mahasiswa, String namaKPS) {
        this.mahasiswa = mahasiswa;
        this.namaKPS = namaKPS;
        daftarMK = new ArrayList<>();
    }
    public boolean tambahMatakuliah(MataKuliah mk) {
        if (totalSKS + mk.getSks() > MAKS_SKS) {
            System.out.println("SKS melebihi batas 24! Mata kuliah tidak dapat ditambahkan.");
            return false;
        }
        daftarMK.add(mk);
        totalSKS += mk.getSks();
        return true;
    }

    public void cetakKRS() {
        System.out.println("\n===== KARTU RENCANA STUDI (KRS) =====");
        System.out.println("NIM  : " + mahasiswa.getNim());
        System.out.println("Nama : " + mahasiswa.getNama());
        System.out.println("--------------------------------------");
        System.out.println("Daftar Mata Kuliah:");

        for (MataKuliah mk : daftarMK) {
            System.out.println("- " + mk.toString());
        }

        System.out.println("--------------------------------------");
        System.out.println("Total SKS: " + totalSKS);
        System.out.println("\nDisetujui oleh:");
        System.out.println("KPS: " + namaKPS);
        System.out.println("Ttd: _____________________");
    }
}
public class KRS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input mahasiswa
        System.out.print("Masukkan NIM mahasiswa  : ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama mahasiswa : ");
        String nama = input.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama);

        System.out.print("Masukkan nama KPS: ");
        String namaKps = input.nextLine();

        KRS krs = new KRS(mhs, namaKps);

        System.out.print("Berapa mata kuliah yang ingin diambil? ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nMata Kuliah ke-" + (i + 1));
            System.out.print("Kode MK   : ");
            String kode = input.nextLine();
            System.out.print("Nama MK   : ");
            String namaMK = input.nextLine();
            System.out.print("Jumlah SKS: ");
            int sks = input.nextInt();
            input.nextLine(); // clear buffer

            MataKuliah mk = new MataKuliah(kode, namaMK, sks);
            krs.tambahMatakuliah(mk);
        }

    
        krs.cetakKRS();
    }
}
