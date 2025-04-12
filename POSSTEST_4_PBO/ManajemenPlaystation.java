import java.util.ArrayList;
import java.util.Scanner;

class Pelanggan {
    // Mengubah akses modifier menjadi private (encapsulation)
    private String nama;
    private String kontak;

    public Pelanggan(String nama, String kontak) {
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
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    // Metode update menggunakan setter
    public void updatePelanggan(String nama, String kontak) {
        setNama(nama);
        setKontak(kontak);
    }
    
    // Method untuk menampilkan info pelanggan - akan di-override oleh subclass
    public String tampilInfo() {
        return "Nama: " + getNama() + ", Kontak: " + getKontak();
    }
}

// Menambahkan subclass PelangganMember untuk polimorfisme
class PelangganMember extends Pelanggan {
    private String noMember;
    private int poin;
    
    // Constructor
    public PelangganMember(String nama, String kontak, String noMember) {
        super(nama, kontak);
        this.noMember = noMember;
        this.poin = 0;
    }
    
    // Constructor overloading
    public PelangganMember(String nama, String kontak, String noMember, int poin) {
        super(nama, kontak);
        this.noMember = noMember;
        this.poin = poin;
    }
    
    // Getter dan Setter
    public String getNoMember() {
        return noMember;
    }
    
    public void setNoMember(String noMember) {
        this.noMember = noMember;
    }
    
    public int getPoin() {
        return poin;
    }
    
    public void setPoin(int poin) {
        this.poin = poin;
    }
    
    // Method overriding
    @Override
    public String tampilInfo() {
        return super.tampilInfo() + ", No Member: " + noMember + ", Poin: " + poin;
    }
    
    // Method overloading
    public void updatePelanggan(String nama, String kontak, String noMember) {
        super.updatePelanggan(nama, kontak);
        setNoMember(noMember);
    }
    
    // Method overloading
    public void updatePelanggan(String nama, String kontak, String noMember, int poin) {
        updatePelanggan(nama, kontak, noMember);
        setPoin(poin);
    }
    
    // Method untuk menambah poin
    public void tambahPoin(int jumlah) {
        this.poin += jumlah;
    }
}

class Konsol {
    // Mengubah akses modifier menjadi private (encapsulation)
    private String namaKonsol;
    private boolean tersedia;

    public Konsol(String namaKonsol, boolean tersedia) {
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
    public void setNamaKonsol(String namaKonsol) {
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
}

// Subclass untuk KonsolPS untuk implementasi polimorfisme
class KonsolPS5 extends Konsol {
    private boolean digitalEdition;
    
    public KonsolPS5(String namaKonsol, boolean tersedia, boolean digitalEdition) {
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

class Karyawan {
    // Mengubah akses modifier (encapsulation)
    private String nama;
    // Menggunakan protected untuk ID - bisa diakses oleh subclass
    protected String id;

    public Karyawan(String nama, String id) {
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
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Metode update menggunakan setter
    public void updateKaryawan(String nama) {
        setNama(nama);
    }
    
    // Method yang akan di-override
    public double hitungGaji() {
        return 3000000.0; // Gaji default karyawan
    }
    
    // Method untuk menampilkan info karyawan
    public String infoKaryawan() {
        return "Nama: " + getNama() + ", ID: " + getId() + ", Gaji: Rp " + hitungGaji();
    }
}

// Subclass untuk Manager
class Manager extends Karyawan {
    private double bonus;
    
    public Manager(String nama, String id, double bonus) {
        super(nama, id);
        this.bonus = bonus;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    // Method overriding
    @Override
    public double hitungGaji() {
        return super.hitungGaji() + bonus;
    }
    
    // Method overloading
    public void updateKaryawan(String nama, double bonus) {
        super.updateKaryawan(nama);
        setBonus(bonus);
    }
}

public class ManajemenPlaystation {
    // Scanner sebagai private static field
    private static Scanner scanner = new Scanner(System.in);
    // Membuat daftar-daftar sebagai protected - bisa diakses oleh subclass
    protected static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    protected static ArrayList<Konsol> daftarKonsol = new ArrayList<>();
    protected static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
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
            System.out.println("11. Tambah Karyawan");
            System.out.println("12. Tambah Manager");
            System.out.println("13. Update Data Karyawan");
            System.out.println("14. Lihat Data Karyawan");
            System.out.println("15. Hapus Data Karyawan");
            System.out.println("16. Keluar");
            System.out.print("Pilih menu: ");
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
                    tambahKaryawan();
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
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    // Metode dengan akses modifier public
    public static void tambahPelanggan() {
        System.out.print("Masukkan nama pelanggan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kontak pelanggan: ");
        String kontak = scanner.nextLine();
        daftarPelanggan.add(new Pelanggan(nama, kontak));
        System.out.println("Pelanggan berhasil ditambahkan!");
    }
    
    // Metode untuk tambah pelanggan member (implementation of polymorphism)
    public static void tambahPelangganMember() {
        System.out.print("Masukkan nama pelanggan member: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kontak pelanggan member: ");
        String kontak = scanner.nextLine();
        System.out.print("Masukkan nomor member: ");
        String noMember = scanner.nextLine();
        System.out.print("Masukkan poin awal (0 jika baru): ");
        int poin = scanner.nextInt();
        scanner.nextLine();
        
        daftarPelanggan.add(new PelangganMember(nama, kontak, noMember, poin));
        System.out.println("Pelanggan Member berhasil ditambahkan!");
    }

    public static void lihatPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
        } else {
            System.out.println("\nDaftar Pelanggan:");
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                Pelanggan p = daftarPelanggan.get(i);
                // Menggunakan method polymorphic
                System.out.println((i + 1) + ". " + p.tampilInfo());
            }
        }
    }

    public static void updatePelanggan() {
        lihatPelanggan();
        if (daftarPelanggan.isEmpty()) return;
        System.out.print("Pilih nomor pelanggan yang ingin diupdate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarPelanggan.size()) {
            Pelanggan p = daftarPelanggan.get(index);
            
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kontak baru: ");
            String kontak = scanner.nextLine();
            
            // Polymorphism - different behavior based on object type
            if (p instanceof PelangganMember) {
                System.out.print("Masukkan nomor member baru: ");
                String noMember = scanner.nextLine();
                System.out.print("Masukkan poin baru: ");
                int poin = scanner.nextInt();
                scanner.nextLine();
                ((PelangganMember) p).updatePelanggan(nama, kontak, noMember, poin);
            } else {
                p.updatePelanggan(nama, kontak);
            }
            
            System.out.println("Data pelanggan berhasil diperbarui!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    public static void tambahKonsol() {
        System.out.print("Masukkan nama konsol: ");
        String namaKonsol = scanner.nextLine();
        daftarKonsol.add(new Konsol(namaKonsol, true));
        System.out.println("Konsol berhasil ditambahkan!");
    }
    
    // Metode untuk menambah konsol PS5
    public static void tambahKonsolPS5() {
        System.out.print("Masukkan nama konsol PS5: ");
        String namaKonsol = scanner.nextLine();
        System.out.print("Tersedia? (true/false): ");
        boolean tersedia = scanner.nextBoolean();
        System.out.print("Digital Edition? (true/false): ");
        boolean digitalEdition = scanner.nextBoolean();
        scanner.nextLine();
        
        daftarKonsol.add(new KonsolPS5(namaKonsol, tersedia, digitalEdition));
        System.out.println("Konsol PS5 berhasil ditambahkan!");
    }

    public static void lihatKonsol() {
        if (daftarKonsol.isEmpty()) {
            System.out.println("Belum ada konsol.");
        } else {
            System.out.println("\nDaftar Konsol:");
            for (int i = 0; i < daftarKonsol.size(); i++) {
                Konsol k = daftarKonsol.get(i);
                // Menggunakan polymorphic method
                System.out.println((i + 1) + ". " + k.infoKonsol());
            }
        }
    }

    public static void updateKonsol() {
        lihatKonsol();
        if (daftarKonsol.isEmpty()) return;
        System.out.print("Pilih nomor konsol yang ingin diupdate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarKonsol.size()) {
            Konsol k = daftarKonsol.get(index);
            System.out.print("Apakah konsol tersedia? (true/false): ");
            boolean tersedia = scanner.nextBoolean();
            
            // Polymorphism - different behavior based on object type
            if (k instanceof KonsolPS5) {
                System.out.print("Digital Edition? (true/false): ");
                boolean digitalEdition = scanner.nextBoolean();
                ((KonsolPS5) k).updateKonsol(tersedia, digitalEdition);
            } else {
                k.updateKonsol(tersedia);
            }
            
            scanner.nextLine();
            System.out.println("Konsol berhasil diperbarui!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    public static void hapusPelanggan() {
        lihatPelanggan();
        if (daftarPelanggan.isEmpty()) return;
        System.out.print("Pilih nomor pelanggan yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarPelanggan.size()) {
            daftarPelanggan.remove(index);
            System.out.println("Pelanggan berhasil dihapus!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    public static void hapusKonsol() {
        lihatKonsol();
        if (daftarKonsol.isEmpty()) return;
        System.out.print("Pilih nomor konsol yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarKonsol.size()) {
            daftarKonsol.remove(index);
            System.out.println("Konsol berhasil dihapus!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    public static void tambahKaryawan() {
        System.out.print("Masukkan nama karyawan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        daftarKaryawan.add(new Karyawan(nama, id));
        System.out.println("Karyawan berhasil ditambahkan!");
    }
    
    // Metode untuk menambah manager
    public static void tambahManager() {
        System.out.print("Masukkan nama manager: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID manager: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan bonus manager: ");
        double bonus = scanner.nextDouble();
        scanner.nextLine();
        
        daftarKaryawan.add(new Manager(nama, id, bonus));
        System.out.println("Manager berhasil ditambahkan!");
    }

    public static void lihatKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada karyawan.");
        } else {
            System.out.println("\nDaftar Karyawan:");
            for (int i = 0; i < daftarKaryawan.size(); i++) {
                Karyawan k = daftarKaryawan.get(i);
                // Menggunakan method polymorphic
                System.out.println((i + 1) + ". " + k.infoKaryawan());
            }
        }
    }

    public static void updateKaryawan() {
        lihatKaryawan();
        if (daftarKaryawan.isEmpty()) return;
        System.out.print("Pilih nomor karyawan yang ingin diupdate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarKaryawan.size()) {
            Karyawan k = daftarKaryawan.get(index);
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            
            // Polymorphism - different behavior based on object type
            if (k instanceof Manager) {
                System.out.print("Masukkan bonus baru: ");
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                ((Manager) k).updateKaryawan(nama, bonus);
            } else {
                k.updateKaryawan(nama);
            }
            
            System.out.println("Data karyawan berhasil diperbarui!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    public static void hapusKaryawan() {
        lihatKaryawan();
        if (daftarKaryawan.isEmpty()) return;
        System.out.print("Pilih nomor karyawan yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < daftarKaryawan.size()) {
            daftarKaryawan.remove(index);
            System.out.println("Karyawan berhasil dihapus!");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }
}