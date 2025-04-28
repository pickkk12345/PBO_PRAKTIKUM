import java.util.ArrayList;
import java.util.Scanner;

// Interface untuk persyaratan Posttest6
interface Pengelolaan {
    // Minimal 2 method dalam interface
    void tampilkanInfo();
    boolean validasi();
}

class Pelanggan implements Pengelolaan {
    // Mengubah akses modifier menjadi private (encapsulation)
    private String nama;
    private String kontak;

    public Pelanggan(String nama, String kontak) throws IllegalArgumentException {
        // Error handling untuk input tidak valid
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
        }
        if (kontak == null || kontak.trim().isEmpty()) {
            throw new IllegalArgumentException("Kontak pelanggan tidak boleh kosong");
        }
        this.nama = nama;
        this.kontak = kontak;
    }

    // Implementasi Getter
    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    // Implementasi Setter
    public void setNama(String nama) throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
        }
        this.nama = nama;
    }

    public void setKontak(String kontak) throws IllegalArgumentException {
        if (kontak == null || kontak.trim().isEmpty()) {
            throw new IllegalArgumentException("Kontak pelanggan tidak boleh kosong");
        }
        this.kontak = kontak;
    }

    // Metode update menggunakan setter
    public void updatePelanggan(String nama, String kontak) throws IllegalArgumentException {
        setNama(nama);
        setKontak(kontak);
    }
    
    // Method untuk menampilkan info pelanggan - akan di-override oleh subclass
    public String tampilInfo() {
        return "Nama: " + getNama() + ", Kontak: " + getKontak();
    }
    
    // Implementasi method dari interface Pengelolaan
    @Override
    public void tampilkanInfo() {
        System.out.println(tampilInfo());
    }
    
    @Override
    public boolean validasi() {
        return !(nama == null || nama.trim().isEmpty() || kontak == null || kontak.trim().isEmpty());
    }
}

// Menambahkan final class PelangganMember sehingga tidak bisa di-extend
final class PelangganMember extends Pelanggan {
    // Menggunakan final pada atribut noMember sehingga nilainya tidak bisa diubah setelah diinisialisasi
    private final String noMember;
    private int poin;
    
    // Constructor
    public PelangganMember(String nama, String kontak, String noMember) throws IllegalArgumentException {
        super(nama, kontak);
        if (noMember == null || noMember.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor Member tidak boleh kosong");
        }
        this.noMember = noMember;
        this.poin = 0;
    }
    
    // Constructor overloading
    public PelangganMember(String nama, String kontak, String noMember, int poin) throws IllegalArgumentException {
        super(nama, kontak);
        if (noMember == null || noMember.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor Member tidak boleh kosong");
        }
        if (poin < 0) {
            throw new IllegalArgumentException("Poin tidak boleh negatif");
        }
        this.noMember = noMember;
        this.poin = poin;
    }
    
    // Getter dan Setter
    public String getNoMember() {
        return noMember;
    }
    
    // Menghapus setNoMember karena noMember sekarang final
    
    public int getPoin() {
        return poin;
    }
    
    public void setPoin(int poin) throws IllegalArgumentException {
        if (poin < 0) {
            throw new IllegalArgumentException("Poin tidak boleh negatif");
        }
        this.poin = poin;
    }
    
    // Method overriding
    @Override
    public String tampilInfo() {
        return super.tampilInfo() + ", No Member: " + noMember + ", Poin: " + poin;
    }
    
    // Method overloading - mengubah implementasi karena noMember sekarang final
    public void updatePelanggan(String nama, String kontak) throws IllegalArgumentException {
        super.updatePelanggan(nama, kontak);
        // Tidak bisa update noMember karena final
    }
    
    // Method overloading
    public void updatePelanggan(String nama, String kontak, int poin) throws IllegalArgumentException {
        updatePelanggan(nama, kontak);
        setPoin(poin);
    }
    
    // Method untuk menambah poin
    public void tambahPoin(int jumlah) throws IllegalArgumentException {
        if (jumlah < 0) {
            throw new IllegalArgumentException("Jumlah poin tidak boleh negatif");
        }
        this.poin += jumlah;
    }
    
    // Implementasi method dari interface (override dari parent class)
    @Override
    public boolean validasi() {
        return super.validasi() && !(noMember == null || noMember.trim().isEmpty());
    }
}

class Konsol implements Pengelolaan {
    // Mengubah akses modifier menjadi private (encapsulation)
    private String namaKonsol;
    private boolean tersedia;

    public Konsol(String namaKonsol, boolean tersedia) throws IllegalArgumentException {
        if (namaKonsol == null || namaKonsol.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama konsol tidak boleh kosong");
        }
        this.namaKonsol = namaKonsol;
        this.tersedia = tersedia;
    }

    // Implementasi Getter
    public String getNamaKonsol() {
        return namaKonsol;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    // Implementasi Setter
    public void setNamaKonsol(String namaKonsol) throws IllegalArgumentException {
        if (namaKonsol == null || namaKonsol.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama konsol tidak boleh kosong");
        }
        this.namaKonsol = namaKonsol;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    // Metode update menggunakan setter
    public void updateKonsol(boolean tersedia) {
        setTersedia(tersedia);
    }
    
    // Method yang akan di-override
    public String infoKonsol() {
        return "Nama: " + getNamaKonsol() + ", Tersedia: " + (isTersedia() ? "Ya" : "Tidak");
    }
    
    // Implementasi method dari interface Pengelolaan
    @Override
    public void tampilkanInfo() {
        System.out.println(infoKonsol());
    }
    
    @Override
    public boolean validasi() {
        return !(namaKonsol == null || namaKonsol.trim().isEmpty());
    }
}

// Subclass untuk KonsolPS untuk implementasi polimorfisme
class KonsolPS5 extends Konsol {
    private boolean digitalEdition;
    
    public KonsolPS5(String namaKonsol, boolean tersedia, boolean digitalEdition) throws IllegalArgumentException {
        super(namaKonsol, tersedia);
        this.digitalEdition = digitalEdition;
    }
    
    public boolean isDigitalEdition() {
        return digitalEdition;
    }
    
    public void setDigitalEdition(boolean digitalEdition) {
        this.digitalEdition = digitalEdition;
    }
    
    // Metode overriding
    @Override
    public String infoKonsol() {
        return super.infoKonsol() + ", Digital Edition: " + (isDigitalEdition() ? "Ya" : "Tidak");
    }
    
    // Metode overloading
    public void updateKonsol(boolean tersedia, boolean digitalEdition) {
        updateKonsol(tersedia);
        setDigitalEdition(digitalEdition);
    }
}

// Mengubah Karyawan menjadi abstract class dan menerapkan interface
abstract class Karyawan implements Pengelolaan {
    // Mengubah akses modifier (encapsulation)
    private String nama;
    // Menggunakan protected untuk ID - bisa diakses oleh subclass
    protected String id;

    public Karyawan(String nama, String id) throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama karyawan tidak boleh kosong");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID karyawan tidak boleh kosong");
        }
        this.nama = nama;
        this.id = id;
    }

    // Implementasi Getter
    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    // Implementasi Setter
    public void setNama(String nama) throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama karyawan tidak boleh kosong");
        }
        this.nama = nama;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID karyawan tidak boleh kosong");
        }
        this.id = id;
    }

    // Metode update menggunakan setter
    public void updateKaryawan(String nama) throws IllegalArgumentException {
        setNama(nama);
    }
    
    // Method abstract yang harus diimplementasikan oleh subclass
    public abstract double hitungGaji();
    
    // Method final untuk menampilkan info karyawan - tidak dapat di-override
    public final String infoKaryawan() {
        return "Nama: " + getNama() + ", ID: " + getId() + ", Gaji: Rp " + hitungGaji();
    }
    
    // Implementasi method dari interface Pengelolaan
    @Override
    public void tampilkanInfo() {
        System.out.println(infoKaryawan());
    }
    
    @Override
    public boolean validasi() {
        return !(nama == null || nama.trim().isEmpty() || id == null || id.trim().isEmpty());
    }
}

// Subclass untuk Manager
class Manager extends Karyawan {
    private double bonus;
    
    public Manager(String nama, String id, double bonus) throws IllegalArgumentException {
        super(nama, id);
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus tidak boleh negatif");
        }
        this.bonus = bonus;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void setBonus(double bonus) throws IllegalArgumentException {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus tidak boleh negatif");
        }
        this.bonus = bonus;
    }
    
    // Implementasi method abstract dari parent class
    @Override
    public double hitungGaji() {
        return 3000000.0 + bonus; // Gaji dasar + bonus
    }
    
    // Method overloading
    public void updateKaryawan(String nama, double bonus) throws IllegalArgumentException {
        super.updateKaryawan(nama);
        setBonus(bonus);
    }
}

// Menambahkan class Staff sebagai implementasi lain dari abstract class Karyawan
class Staff extends Karyawan {
    private int jamLembur;
    private final double TARIF_LEMBUR = 50000.0; // Final constant
    
    public Staff(String nama, String id, int jamLembur) throws IllegalArgumentException {
        super(nama, id);
        if (jamLembur < 0) {
            throw new IllegalArgumentException("Jam lembur tidak boleh negatif");
        }
        this.jamLembur = jamLembur;
    }
    
    public int getJamLembur() {
        return jamLembur;
    }
    
    public void setJamLembur(int jamLembur) throws IllegalArgumentException {
        if (jamLembur < 0) {
            throw new IllegalArgumentException("Jam lembur tidak boleh negatif");
        }
        this.jamLembur = jamLembur;
    }
    
    // Implementasi method abstract
    @Override
    public double hitungGaji() {
        return 2500000.0 + (jamLembur * TARIF_LEMBUR); // Gaji dasar + lembur
    }
    
    // Method overloading
    public void updateKaryawan(String nama, int jamLembur) throws IllegalArgumentException {
        super.updateKaryawan(nama);
        setJamLembur(jamLembur);
    }
}

public class ManajemenPlaystation {
    // Scanner sebagai private static field
    private static Scanner scanner = new Scanner(System.in);
    // Membuat daftar-daftar sebagai protected - bisa diakses oleh subclass
    protected static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    protected static ArrayList<Konsol> daftarKonsol = new ArrayList<>();
    protected static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    
    // Static variable untuk penghitung ID
    private static int idCounter = 1;
    
    // Static method untuk generate ID
    public static String generateId(String prefix) {
        return prefix + idCounter++;
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n=== Manajemen Playstation ===");
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Tambah Pelanggan Member");
                System.out.println("3. Tambah Konsol");
                System.out.println("4. Tambah Konsol PS5");
                System.out.println("5. Lihat Data Pelanggan");
                System.out.println("6. Lihat Data Konsol");
                System.out.println("7. Update Data Pelanggan");
                System.out.println("8. Update Data Konsol");
                System.out.println("9. Hapus Data Pelanggan");
                System.out.println("10. Hapus Data Konsol");
                System.out.println("11. Tambah Staff");
                System.out.println("12. Tambah Manager");
                System.out.println("13. Update Data Karyawan");
                System.out.println("14. Lihat Data Karyawan");
                System.out.println("15. Hapus Data Karyawan");
                System.out.println("16. Validasi Semua Data");
                System.out.println("17. Keluar");
                System.out.print("Pilih menu: ");
                
                // Error handling untuk input bukan angka
                if (!scanner.hasNextInt()) {
                    String input = scanner.nextLine();
                    System.out.println("Input tidak valid. Mohon masukkan angka.");
                    continue;
                }
                
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        tambahPelanggan();
                        break;
                    case 2:
                        tambahPelangganMember();
                        break;
                    case 3:
                        tambahKonsol();
                        break;
                    case 4:
                        tambahKonsolPS5();
                        break;
                    case 5:
                        lihatPelanggan();
                        break;
                    case 6:
                        lihatKonsol();
                        break;
                    case 7:
                        updatePelanggan();
                        break;
                    case 8:
                        updateKonsol();
                        break;
                    case 9:
                        hapusPelanggan();
                        break;
                    case 10:
                        hapusKonsol();
                        break;
                    case 11:
                        tambahStaff();
                        break;
                    case 12:
                        tambahManager();
                        break;
                    case 13:
                        updateKaryawan();
                        break;
                    case 14:
                        lihatKaryawan();
                        break;
                    case 15:
                        hapusKaryawan();
                        break;
                    case 16:
                        validasiSemuaData();
                        break;
                    case 17:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi Manajemen Playstation!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                // Bersihkan buffer scanner jika terjadi error
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }

    // Method static baru untuk validasi semua data
    public static void validasiSemuaData() {
        System.out.println("\n=== Validasi Semua Data ===");
        
        // Validasi data pelanggan
        System.out.println("\nValidasi Data Pelanggan:");
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Tidak ada data pelanggan untuk divalidasi.");
        } else {
            boolean semuaValid = true;
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                Pelanggan p = daftarPelanggan.get(i);
                boolean valid = p.validasi();
                System.out.println((i + 1) + ". " + p.tampilInfo() + " - " + (valid ? "Valid" : "Tidak Valid"));
                if (!valid) semuaValid = false;
            }
            System.out.println("Semua data pelanggan " + (semuaValid ? "valid" : "tidak valid"));
        }
        
        // Validasi data konsol
        System.out.println("\nValidasi Data Konsol:");
        if (daftarKonsol.isEmpty()) {
            System.out.println("Tidak ada data konsol untuk divalidasi.");
        } else {
            boolean semuaValid = true;
            for (int i = 0; i < daftarKonsol.size(); i++) {
                Konsol k = daftarKonsol.get(i);
                boolean valid = k.validasi();
                System.out.println((i + 1) + ". " + k.infoKonsol() + " - " + (valid ? "Valid" : "Tidak Valid"));
                if (!valid) semuaValid = false;
            }
            System.out.println("Semua data konsol " + (semuaValid ? "valid" : "tidak valid"));
        }
        
        // Validasi data karyawan
        System.out.println("\nValidasi Data Karyawan:");
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Tidak ada data karyawan untuk divalidasi.");
        } else {
            boolean semuaValid = true;
            for (int i = 0; i < daftarKaryawan.size(); i++) {
                Karyawan k = daftarKaryawan.get(i);
                boolean valid = k.validasi();
                System.out.println((i + 1) + ". " + k.infoKaryawan() + " - " + (valid ? "Valid" : "Tidak Valid"));
                if (!valid) semuaValid = false;
            }
            System.out.println("Semua data karyawan " + (semuaValid ? "valid" : "tidak valid"));
        }
    }

    // Metode dengan akses modifier public
    public static void tambahPelanggan() {
        try {
            System.out.print("Masukkan nama pelanggan: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kontak pelanggan: ");
            String kontak = scanner.nextLine();
            
            Pelanggan pelanggan = new Pelanggan(nama, kontak);
            daftarPelanggan.add(pelanggan);
            System.out.println("Pelanggan berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Metode untuk tambah pelanggan member (implementation of polymorphism)
    public static void tambahPelangganMember() {
        try {
            System.out.print("Masukkan nama pelanggan member: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kontak pelanggan member: ");
            String kontak = scanner.nextLine();
            System.out.print("Masukkan nomor member: ");
            String noMember = scanner.nextLine();
            
            // Error handling untuk input bukan angka
            System.out.print("Masukkan poin awal (0 jika baru): ");
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input poin harus berupa angka");
            }
            int poin = scanner.nextInt();
            scanner.nextLine();
            
            PelangganMember member = new PelangganMember(nama, kontak, noMember, poin);
            daftarPelanggan.add(member);
            System.out.println("Pelanggan Member berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void lihatPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
        } else {
            System.out.println("\nDaftar Pelanggan:");
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                Pelanggan p = daftarPelanggan.get(i);
                // Menggunakan method dari interface
                System.out.print((i + 1) + ". ");
                p.tampilkanInfo();
            }
        }
    }

    public static void updatePelanggan() {
        try {
            lihatPelanggan();
            if (daftarPelanggan.isEmpty()) return;
            
            System.out.print("Pilih nomor pelanggan yang ingin diupdate: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarPelanggan.size()) {
                throw new IndexOutOfBoundsException("Nomor pelanggan tidak valid");
            }
            
            Pelanggan p = daftarPelanggan.get(index);
            
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kontak baru: ");
            String kontak = scanner.nextLine();
            
            // Polymorphism - different behavior based on object type
            if (p instanceof PelangganMember) {
                System.out.print("Masukkan poin baru: ");
                // Error handling untuk input bukan angka
                if (!scanner.hasNextInt()) {
                    String input = scanner.nextLine();
                    throw new IllegalArgumentException("Input poin harus berupa angka");
                }
                int poin = scanner.nextInt();
                scanner.nextLine();
                
                // Ubah karena noMember sekarang final
                ((PelangganMember) p).updatePelanggan(nama, kontak, poin);
            } else {
                p.updatePelanggan(nama, kontak);
            }
            
            System.out.println("Data pelanggan berhasil diperbarui!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void tambahKonsol() {
        try {
            System.out.print("Masukkan nama konsol: ");
            String namaKonsol = scanner.nextLine();
            Konsol konsol = new Konsol(namaKonsol, true);
            daftarKonsol.add(konsol);
            System.out.println("Konsol berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Metode untuk menambah konsol PS5
    public static void tambahKonsolPS5() {
        try {
            System.out.print("Masukkan nama konsol PS5: ");
            String namaKonsol = scanner.nextLine();
            
            System.out.print("Tersedia? (y/n): ");
            String tersediaInput = scanner.nextLine().toLowerCase();
            if (!tersediaInput.equals("y") && !tersediaInput.equals("n")) {
                throw new IllegalArgumentException("Input harus 'y' atau 'n'");
            }
            boolean tersedia = tersediaInput.equals("y");
            
            System.out.print("Digital Edition? (y/n): ");
            String digitalInput = scanner.nextLine().toLowerCase();
            if (!digitalInput.equals("y") && !digitalInput.equals("n")) {
                throw new IllegalArgumentException("Input harus 'y' atau 'n'");
            }
            boolean digitalEdition = digitalInput.equals("y");
            
            KonsolPS5 konsolPS5 = new KonsolPS5(namaKonsol, tersedia, digitalEdition);
            daftarKonsol.add(konsolPS5);
            System.out.println("Konsol PS5 berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void lihatKonsol() {
        if (daftarKonsol.isEmpty()) {
            System.out.println("Belum ada konsol.");
        } else {
            System.out.println("\nDaftar Konsol:");
            for (int i = 0; i < daftarKonsol.size(); i++) {
                Konsol k = daftarKonsol.get(i);
                // Menggunakan method dari interface
                System.out.print((i + 1) + ". ");
                k.tampilkanInfo();
            }
        }
    }

    public static void updateKonsol() {
        try {
            lihatKonsol();
            if (daftarKonsol.isEmpty()) return;
            
            System.out.print("Pilih nomor konsol yang ingin diupdate: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarKonsol.size()) {
                throw new IndexOutOfBoundsException("Nomor konsol tidak valid");
            }
            
            Konsol k = daftarKonsol.get(index);
            
            System.out.print("Apakah konsol tersedia? (y/n): ");
            String tersediaInput = scanner.nextLine().toLowerCase();
            if (!tersediaInput.equals("y") && !tersediaInput.equals("n")) {
                throw new IllegalArgumentException("Input harus 'y' atau 'n'");
            }
            boolean tersedia = tersediaInput.equals("y");
            
            // Polymorphism - different behavior based on object type
            if (k instanceof KonsolPS5) {
                System.out.print("Digital Edition? (y/n): ");
                String digitalInput = scanner.nextLine().toLowerCase();
                if (!digitalInput.equals("y") && !digitalInput.equals("n")) {
                    throw new IllegalArgumentException("Input harus 'y' atau 'n'");
                }
                boolean digitalEdition = digitalInput.equals("y");
                
                ((KonsolPS5) k).updateKonsol(tersedia, digitalEdition);
            } else {
                k.updateKonsol(tersedia);
            }
            
            System.out.println("Konsol berhasil diperbarui!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void hapusPelanggan() {
        try {
            lihatPelanggan();
            if (daftarPelanggan.isEmpty()) return;
            
            System.out.print("Pilih nomor pelanggan yang ingin dihapus: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarPelanggan.size()) {
                throw new IndexOutOfBoundsException("Nomor pelanggan tidak valid");
            }
            
            daftarPelanggan.remove(index);
            System.out.println("Pelanggan berhasil dihapus!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void hapusKonsol() {
        try {
            lihatKonsol();
            if (daftarKonsol.isEmpty()) return;
            
            System.out.print("Pilih nomor konsol yang ingin dihapus: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarKonsol.size()) {
                throw new IndexOutOfBoundsException("Nomor konsol tidak valid");
            }
            
            daftarKonsol.remove(index);
            System.out.println("Konsol berhasil dihapus!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
    
    // Mengganti tambahKaryawan menjadi tambahStaff karena Karyawan sekarang abstract
    public static void tambahStaff() {
        try {
            System.out.print("Masukkan nama staff: ");
            String nama = scanner.nextLine();
            
            // Menggunakan static method untuk generate ID
            String id = generateId("STF");
            System.out.println("ID Staff yang diberikan: " + id);
            
            System.out.print("Masukkan jam lembur: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input jam lembur harus berupa angka");
            }
            int jamLembur = scanner.nextInt();
            scanner.nextLine();
            
            if (jamLembur < 0) {
                throw new IllegalArgumentException("Jam lembur tidak boleh negatif");
            }
            
            Staff staff = new Staff(nama, id, jamLembur);
            daftarKaryawan.add(staff);
            System.out.println("Staff berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
    
    // Metode untuk menambah manager
    public static void tambahManager() {
        try {
            System.out.print("Masukkan nama manager: ");
            String nama = scanner.nextLine();
            
            // Menggunakan static method untuk generate ID
            String id = generateId("MGR");
            System.out.println("ID Manager yang diberikan: " + id);
            
            System.out.print("Masukkan bonus manager: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextDouble()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input bonus harus berupa angka");
            }
            double bonus = scanner.nextDouble();
            scanner.nextLine();
            
            if (bonus < 0) {
                throw new IllegalArgumentException("Bonus tidak boleh negatif");
            }
            
            Manager manager = new Manager(nama, id, bonus);
            daftarKaryawan.add(manager);
            System.out.println("Manager berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void lihatKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada karyawan.");
        } else {
            System.out.println("\nDaftar Karyawan:");
            for (int i = 0; i < daftarKaryawan.size(); i++) {
                Karyawan k = daftarKaryawan.get(i);
                // Menggunakan method dari interface
                System.out.print((i + 1) + ". ");
                k.tampilkanInfo();
            }
        }
    }

    public static void updateKaryawan() {
        try {
            lihatKaryawan();
            if (daftarKaryawan.isEmpty()) return;
            
            System.out.print("Pilih nomor karyawan yang ingin diupdate: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarKaryawan.size()) {
                throw new IndexOutOfBoundsException("Nomor karyawan tidak valid");
            }
            
            Karyawan k = daftarKaryawan.get(index);
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            
            // Polymorphism - different behavior based on object type
            if (k instanceof Manager) {
                System.out.print("Masukkan bonus baru: ");
                // Error handling untuk input bukan angka
                if (!scanner.hasNextDouble()) {
                    String input = scanner.nextLine();
                    throw new IllegalArgumentException("Input bonus harus berupa angka");
                }
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                
                if (bonus < 0) {
                    throw new IllegalArgumentException("Bonus tidak boleh negatif");
                }
                
                ((Manager) k).updateKaryawan(nama, bonus);
            } else if (k instanceof Staff) {
                System.out.print("Masukkan jam lembur baru: ");
                // Error handling untuk input bukan angka
                if (!scanner.hasNextInt()) {
                    String input = scanner.nextLine();
                    throw new IllegalArgumentException("Input jam lembur harus berupa angka");
                }
                int jamLembur = scanner.nextInt();
                scanner.nextLine();
                
                if (jamLembur < 0) {
                    throw new IllegalArgumentException("Jam lembur tidak boleh negatif");
                }
                
                ((Staff) k).updateKaryawan(nama, jamLembur);
            } else {
                k.updateKaryawan(nama);
            }
            
            System.out.println("Data karyawan berhasil diperbarui!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }

    public static void hapusKaryawan() {
        try {
            lihatKaryawan();
            if (daftarKaryawan.isEmpty()) return;
            
            System.out.print("Pilih nomor karyawan yang ingin dihapus: ");
            // Error handling untuk input bukan angka
            if (!scanner.hasNextInt()) {
                String input = scanner.nextLine();
                throw new IllegalArgumentException("Input harus berupa angka");
            }
            
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (index < 0 || index >= daftarKaryawan.size()) {
                throw new IndexOutOfBoundsException("Nomor karyawan tidak valid");
            }
            
            daftarKaryawan.remove(index);
            System.out.println("Karyawan berhasil dihapus!");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            // Bersihkan buffer scanner
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
}