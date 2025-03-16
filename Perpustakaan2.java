import java.util.*;

class Buku {
    private String judul;
    private List<String> penulis;
    private String sinopsis;
    private int tahunTerbit;

    public Buku(String judul, String sinopsis, int tahunTerbit, String... penulis) {
        this.judul = judul;
        this.sinopsis = sinopsis;
        this.tahunTerbit = tahunTerbit;
        this.penulis = Arrays.asList(penulis);
    }

    public String getJudul() {
        return judul;
    }

    public List<String> getPenulis() {
        return penulis;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public int hitungJumlahKataSinopsis() {
        return sinopsis.split("\\s+").length;
    }

    public double cekTingkatKesamaan(Buku bukuLain) {
        int skor = 0;
        if (this.judul.equalsIgnoreCase(bukuLain.getJudul())) skor += 25;
        if (this.penulis.equals(bukuLain.getPenulis())) skor += 25;
        if (this.sinopsis.equalsIgnoreCase(bukuLain.getSinopsis())) skor += 25;
        if (this.tahunTerbit == bukuLain.getTahunTerbit()) skor += 25;
        return skor;
    }

    public Buku copy() {
        return new Buku(judul, sinopsis, tahunTerbit, penulis.toArray(new String[0]));
    }
}

class Kategori {
    private String nama;
    private List<Buku> bukuList;

    public Kategori(String nama) {
        this.nama = nama;
        this.bukuList = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        bukuList.add(buku);
    }

    public String getNama() {
        return nama;
    }

    public List<Buku> getBukuList() {
        return bukuList;
    }
}

public class Perpustakaan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Kategori> kategoriList = inisialisasiKategori();
        
        while (true) {
            System.out.println("\nPilih menu:");
            System.out.println("(1) Cek plagiasi antara dua buku");
            System.out.println("(2) Salin buku");
            System.out.println("(3) Hitung jumlah kata sinopsis buku");
            System.out.println("(4) Cetak semua buku berdasarkan kategori");
            System.out.println("(5) Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    cekPlagiasi(scanner, kategoriList);
                    break;
                case 2:
                    salinBuku(scanner, kategoriList);
                    break;
                case 3:
                    hitungJumlahKata(scanner, kategoriList);
                    break;
                case 4:
                    cetakBuku(scanner, kategoriList);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    private static List<Kategori> inisialisasiKategori() {
        List<Kategori> kategoriList = new ArrayList<>();
        
        Kategori teknologi = new Kategori("Teknologi");
        Kategori filsafat = new Kategori("Filsafat");
        Kategori sejarah = new Kategori("Sejarah");
        Kategori agama = new Kategori("Agama");
        Kategori psikologi = new Kategori("Psikologi");
        Kategori politik = new Kategori("Politik");
        Kategori fiksi = new Kategori("Fiksi");

        kategoriList.addAll(Arrays.asList(teknologi, filsafat, sejarah, agama, psikologi, politik, fiksi));
        
        Buku buku1 = new Buku("Dasar-Dasar Teknik Informatika", "Buku ini membahas perkembangan TIK dan pengaruhnya terhadap kehidupan modern dalam berbagai aspek.", 2020, "Novega Pratama Adiputra");
        Buku buku2 = new Buku("Pengantar Teknologi Informasi", "Membahas konsep teknologi informasi, perangkat keras, dan dasar digital secara lengkap serta aplikasinya.", 2019, "Bagaskoro, S.Kom., M.M.");
        Buku buku3 = new Buku("Penelitian Teknik Informatika", "Menjelaskan metode penelitian yang digunakan dalam bidang teknik informatika modern secara mendetail.", 2018, "Ade Johar Maturidi");
        Buku buku4 = new Buku("Clean Code", "Panduan praktik terbaik dalam menulis kode yang bersih, efisien, dan mudah dipahami oleh developer lain.", 2008, "Robert Cecil Martin");
        Buku buku5 = new Buku("Aplikasi Komputer", "Mengupas berbagai aplikasi komputer dan manfaatnya dalam kehidupan sehari-hari di berbagai bidang.", 2017, "Dwi Krisbiantoro");

        teknologi.tambahBuku(buku1);
        teknologi.tambahBuku(buku2);
        teknologi.tambahBuku(buku3);
        teknologi.tambahBuku(buku4);
        teknologi.tambahBuku(buku5);

        Buku buku6 = new Buku("Filsafat Ilmu", "Membahas dasar-dasar filsafat ilmu termasuk epistemologi dan metodologi penelitian dalam ilmu pengetahuan.", 2015, "Welhendri Azwar", "Muliono");
        Buku buku7 = new Buku("Meditations", "Kumpulan refleksi Marcus Aurelius tentang kebijaksanaan, kehidupan, dan kepemimpinan dalam menghadapi tantangan.", 180, "Marcus Aurelius");
        Buku buku8 = new Buku("Filsafat Agama", "Menjelaskan berbagai perspektif filosofis tentang agama dan nilai-nilai spiritual dalam kehidupan manusia.", 2012, "Amsal Bakhtiar");
        Buku buku9 = new Buku("Being", "Karya filsafat klasik Martin Heidegger tentang makna keberadaan manusia dalam dunia yang terus berubah.", 1927, "Martin Heidegger");
        Buku buku10 = new Buku("Filsafat Sejarah", "Mengulas pemikiran filosofis mengenai sejarah dan dampaknya terhadap peradaban manusia dari zaman ke zaman.", 2010, "Ahmad Sahidin");

        filsafat.tambahBuku(buku6);
        filsafat.tambahBuku(buku7);
        filsafat.tambahBuku(buku8);
        filsafat.tambahBuku(buku9);
        filsafat.tambahBuku(buku10);

        Buku buku11 = new Buku("Berlin", "Menceritakan sejarah kota Berlin dari awal hingga era modern dengan berbagai perubahan signifikan.", 2013, "Sinclair McKay");
        Buku buku12 = new Buku("The History of the Ancient World", "Mengulas peradaban dunia kuno mulai dari Mesopotamia hingga Roma dalam konteks sejarah dunia.", 2007, "Susan Wise Bauer");
        Buku buku13 = new Buku("The Second World War", "Analisis mendalam mengenai Perang Dunia II dan dampaknya secara global terhadap politik dan ekonomi dunia.", 2012, "Antony Beevor");
        Buku buku14 = new Buku("1776", "Menceritakan peristiwa Revolusi Amerika yang terjadi pada tahun 1776 serta dampaknya terhadap dunia.", 2005, "David McCullough");
        Buku buku15 = new Buku("The Diary of a Young Girl", "Catatan harian Anne Frank selama persembunyiannya dari Nazi di Belanda yang menggambarkan kehidupan saat itu.", 1947, "Anne Frank");

        sejarah.tambahBuku(buku11);
        sejarah.tambahBuku(buku12);
        sejarah.tambahBuku(buku13);
        sejarah.tambahBuku(buku14);
        sejarah.tambahBuku(buku15);

        Buku buku16 = new Buku("Sejarah Islam", "Membahas perkembangan Islam dari masa Nabi Muhammad hingga era modern dalam berbagai aspek kehidupan.", 2000, "Karen Armstrong");
        Buku buku17 = new Buku("Mere Christianity", "Kumpulan pemikiran C.S. Lewis mengenai dasar-dasar kepercayaan Kristen dan bagaimana mengaplikasikannya.", 1952, "C.S. Lewis");
        Buku buku18 = new Buku("What the Buddha Taught", "Menjelaskan ajaran Buddha secara sistematis dan mudah dipahami oleh semua kalangan tanpa kehilangan maknanya.", 1959, "Walpola Rahula");
        Buku buku19 = new Buku("Tafsir ibn Kathir", "Salah satu tafsir Al-Qur'an paling berpengaruh dalam dunia Islam yang membahas berbagai aspek keagamaan.", 1370, "Ibn Kathir");
        Buku buku20 = new Buku("Sejarah Nabi Muhammad", "Biografi Nabi Muhammad berdasarkan sumber terpercaya dalam Islam yang menggambarkan perjalanan hidupnya.", 833, "Ibnu Hisyam");

        agama.tambahBuku(buku16);
        agama.tambahBuku(buku17);
        agama.tambahBuku(buku18);
        agama.tambahBuku(buku19);
        agama.tambahBuku(buku20);

        Buku buku21 = new Buku("Psikologi Positif", "Menjelaskan teori dan penerapan psikologi positif dalam kehidupan manusia untuk mencapai kesejahteraan mental.", 2009, "Husaini Usman");
        Buku buku22 = new Buku("Psikologi Abnormal", "Mengupas berbagai gangguan psikologis serta metode penanganannya berdasarkan pendekatan ilmiah modern.", 2006, "Kartini Kartono");
        Buku buku23 = new Buku("Psikologi Kepribadian", "Membahas teori-teori utama yang menjelaskan karakter dan kepribadian manusia dalam berbagai perspektif.", 2007, "Sumadi Suryabrata");
        Buku buku24 = new Buku("Psikologi Pendidikan", "Menjelaskan aplikasi ilmu psikologi dalam dunia pendidikan secara mendalam untuk mendukung pembelajaran.", 2008, "Ahmadi Abu");
        Buku buku25 = new Buku("Psikologi Kognitif", "Mengulas bagaimana manusia berpikir, mengingat, dan memahami informasi dalam proses belajar sehari-hari.", 2010, "Aaron Beck");

        psikologi.tambahBuku(buku21);
        psikologi.tambahBuku(buku22);
        psikologi.tambahBuku(buku23);
        psikologi.tambahBuku(buku24);
        psikologi.tambahBuku(buku25);

        Buku buku26 = new Buku("The Prince", "Karya klasik Machiavelli tentang kekuasaan dan strategi politik yang masih relevan dalam dunia modern.", 1532, "Niccolò Machiavelli");
        Buku buku27 = new Buku("On Democracy", "Analisis mendalam mengenai prinsip dan praktik demokrasi di berbagai negara dengan contoh kasus nyata.", 1998, "Robert Dahl");
        Buku buku28 = new Buku("Demokrasi Kita", "Pandangan Mohammad Hatta tentang demokrasi di Indonesia dan tantangannya dalam konteks sosial politik.", 1960, "Mohammad Hatta");
        Buku buku29 = new Buku("Dari Sabang Sampai Merauke", "Menjelaskan keragaman budaya dan politik dalam konteks keindonesiaan serta tantangan integrasi nasional.", 2017, "Yudi Latif");
        Buku buku30 = new Buku("Sistem Politik Indonesia", "Menguraikan dinamika sistem politik di Indonesia sejak kemerdekaan hingga era reformasi saat ini.", 2003, "Miriam Budiardjo");

        politik.tambahBuku(buku26);
        politik.tambahBuku(buku27);
        politik.tambahBuku(buku28);
        politik.tambahBuku(buku29);
        politik.tambahBuku(buku30);

        Buku buku31 = new Buku("Laut Bercerita", "Kisah perjuangan aktivis mahasiswa menghadapi represi politik di Indonesia dalam berbagai situasi sulit.", 2017, "Leila Chudori");
        Buku buku32 = new Buku("Negeri 5 Menara", "Menceritakan perjalanan hidup santri dalam mengejar impian besar di pesantren dengan penuh perjuangan.", 2009, "Ahmad Fuadi");
        Buku buku33 = new Buku("5 cm", "Kisah petualangan lima sahabat dalam perjalanan mendaki Mahameru yang penuh makna dan persahabatan.", 2005, "Dhonny Dhirgantoro");
        Buku buku34 = new Buku("Perahu Kertas", "Perjalanan cinta dua anak muda dengan impian dan jalan hidup berbeda yang harus menghadapi banyak rintangan.", 2008, "Dewi Lestari");
        Buku buku35 = new Buku("Ayah", "Sebuah novel tentang keluarga, cinta, dan perjalanan hidup seorang ayah yang penuh liku-liku kehidupan.", 2015, "Andrea Hirata");
        
        fiksi.tambahBuku(buku31);
        fiksi.tambahBuku(buku32);
        fiksi.tambahBuku(buku33);
        fiksi.tambahBuku(buku34);
        fiksi.tambahBuku(buku35);
        
        return kategoriList;
    }
    
    private static void cekPlagiasi(Scanner scanner, List<Kategori> kategoriList) {
        System.out.println("Masukkan dua judul buku untuk dibandingkan:");
        String judul1 = scanner.nextLine();
        String judul2 = scanner.nextLine();
        Buku buku1 = cariBuku(judul1, kategoriList);
        Buku buku2 = cariBuku(judul2, kategoriList);
        if (buku1 != null && buku2 != null) {
            System.out.println("Tingkat kesamaan: " + buku1.cekTingkatKesamaan(buku2) + "%");
        } else {
            System.out.println("Salah satu atau kedua buku tidak ditemukan.");
        }
    }
    
    private static void salinBuku(Scanner scanner, List<Kategori> kategoriList) {
        System.out.print("Masukkan judul buku yang ingin disalin: ");
        String judul = scanner.nextLine();
        Buku buku = cariBuku(judul, kategoriList);
        if (buku != null) {
            Buku salinan = buku.copy();
            System.out.println("Buku telah disalin:");
            System.out.println("Judul: " + salinan.getJudul());
            System.out.println("Sinopsis: " + salinan.getSinopsis());
            System.out.println("Penulis: " + String.join(", ", salinan.getPenulis()));
            System.out.println("Tahun Terbit: " + salinan.getTahunTerbit());
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
    
    private static void hitungJumlahKata(Scanner scanner, List<Kategori> kategoriList) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        Buku buku = cariBuku(judul, kategoriList);
        if (buku != null) {
            System.out.println("Jumlah kata dalam sinopsis: " + buku.hitungJumlahKataSinopsis());
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
    
    private static void cetakBuku(Scanner scanner, List<Kategori> kategoriList) {
        System.out.print("Masukkan nama kategori: ");
        String kategoriNama = scanner.nextLine();
        for (Kategori kategori : kategoriList) {
            if (kategori.getNama().equalsIgnoreCase(kategoriNama)) {
                System.out.println("\nKategori: " + kategori.getNama());
                System.out.println("+------------------------------------+-------------------------------+------------+");
                System.out.printf("| %-34s | %-29s | %-10s |%n", "Judul Buku", "Penulis", "Tahun");
                System.out.println("+------------------------------------+-------------------------------+------------+");
                for (Buku buku : kategori.getBukuList()) {
                    System.out.printf("| %-34s | %-29s | %-10d |%n", buku.getJudul(), String.join(", ", buku.getPenulis()), buku.getTahunTerbit());
                }
                System.out.println("+------------------------------------+-------------------------------+------------+");
                return;
            }
        }
        System.out.println("Kategori tidak ditemukan.");
    }
    
    private static Buku cariBuku(String judul, List<Kategori> kategoriList) {
        for (Kategori kategori : kategoriList) {
            for (Buku buku : kategori.getBukuList()) {
                if (buku.getJudul().equalsIgnoreCase(judul)) {
                    return buku;
                }
            }
        }
        return null;
    }
}