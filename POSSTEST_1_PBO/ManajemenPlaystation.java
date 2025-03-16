import java.util.ArrayList;
import java.util.Scanner;

class Pelanggan {
    String nama;
    String kontak;

    public Pelanggan(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public void updatePelanggan(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }
}

class Konsol {
    String namaKonsol;
    boolean tersedia;

    public Konsol(String namaKonsol, boolean tersedia) {
        this.namaKonsol = namaKonsol;
        this.tersedia = tersedia;
    }

    public void updateKonsol(boolean tersedia) {
        this.tersedia = tersedia;
    }
}

class Karyawan {
    String nama;
    String id;

    public Karyawan(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public void updateKaryawan(String nama) {
        this.nama = nama;
    }
}

public class ManajemenPlaystation {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    static ArrayList<Konsol> daftarKonsol = new ArrayList<>();
    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Manajemen Playstation ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Tambah Konsol");
            System.out.println("3. Lihat Data Pelanggan");
            System.out.println("4. Lihat Data Konsol");
            System.out.println("5. Update Data Pelanggan");
            System.out.println("6. Update Data Konsol");
            System.out.println("7. Hapus Data Pelanggan");
            System.out.println("8. Hapus Data Konsol");
            System.out.println("9. Tambah Karyawan");
            System.out.println("10. Update Data Karyawan");
            System.out.println("11. Lihat Data Karyawan");
            System.out.println("12. Hapus Data Karyawan");
            System.out.println("13. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    tambahKonsol();
                    break;
                case 3:
                    lihatPelanggan();
                    break;
                case 4:
                    lihatKonsol();
                    break;
                case 5:
                    updatePelanggan();
                    break;
                case 6:
                    updateKonsol();
                    break;
                case 7:
                    hapusPelanggan();
                    break;
                case 8:
                    hapusKonsol();
                    break;
                case 9:
                    tambahKaryawan();
                    break;
                case 10:
                    updateKaryawan();
                    break;
                case 11:
                    lihatKaryawan();
                    break;
                case 12:
                    hapusKaryawan();
                    break;
                case 13:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    public static void tambahPelanggan() {
        System.out.print("Masukkan nama pelanggan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kontak pelanggan: ");
        String kontak = scanner.nextLine();
        daftarPelanggan.add(new Pelanggan(nama, kontak));
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    public static void lihatPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
        } else {
            System.out.println("\nDaftar Pelanggan:");
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                Pelanggan p = daftarPelanggan.get(i);
                System.out.println((i + 1) + ". Nama: " + p.nama + ", Kontak: " + p.kontak);
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
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kontak baru: ");
            String kontak = scanner.nextLine();
            daftarPelanggan.get(index).updatePelanggan(nama, kontak);
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

    public static void lihatKonsol() {
        if (daftarKonsol.isEmpty()) {
            System.out.println("Belum ada konsol.");
        } else {
            System.out.println("\nDaftar Konsol:");
            for (int i = 0; i < daftarKonsol.size(); i++) {
                Konsol k = daftarKonsol.get(i);
                System.out.println((i + 1) + ". Nama: " + k.namaKonsol + ", Tersedia: " + (k.tersedia ? "Ya" : "Tidak"));
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
            System.out.print("Apakah konsol tersedia? (true/false): ");
            boolean tersedia = scanner.nextBoolean();
            daftarKonsol.get(index).updateKonsol(tersedia);
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

    public static void lihatKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada karyawan.");
        } else {
            System.out.println("\nDaftar Karyawan:");
            for (int i = 0; i < daftarKaryawan.size(); i++) {
                Karyawan k = daftarKaryawan.get(i);
                System.out.println((i + 1) + ". Nama: " + k.nama + ", ID: " + k.id);
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
            System.out.print("Masukkan nama baru: ");
            String nama = scanner.nextLine();
            daftarKaryawan.get(index).updateKaryawan(nama);
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