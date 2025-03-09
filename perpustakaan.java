import java.util.*;

class Buku {
    private String judul;
    private List<String> penulis;

    public Buku(String judul, String... penulis) {
        this.judul = judul;
        this.penulis = Arrays.asList(penulis);
    }

    public String getJudul() {
        return judul;
    }

    public List<String> getPenulis() {
        return penulis;
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

public class perpustakaan {
    public static void main(String[] args) {
        List<Kategori> kategoriList = new ArrayList<>();

        Kategori teknologi = new Kategori("Teknologi");
        Kategori filsafat = new Kategori("Filsafat");
        Kategori sejarah = new Kategori("Sejarah");
        Kategori agama = new Kategori("Agama");
        Kategori psikologi = new Kategori("Psikologi");
        Kategori politik = new Kategori("Politik");
        Kategori fiksi = new Kategori("Fiksi");

        kategoriList.addAll(Arrays.asList(teknologi, filsafat, sejarah, agama, psikologi, politik, fiksi));

        teknologi.tambahBuku(new Buku("Dasar-Dasar Teknik Informatika", "Novega Pratama Adiputra"));
        teknologi.tambahBuku(new Buku("Pengantar Teknologi Informasi", "Buhori Muslim"));
        teknologi.tambahBuku(new Buku("Penelitian Teknik Informatika", "Ade Johar Maturidi"));
        teknologi.tambahBuku(new Buku("Clean Code", "Robert Cecil Martin"));
        teknologi.tambahBuku(new Buku("Aplikasi Komputer", "Dwi Krisbiantoro"));

        filsafat.tambahBuku(new Buku("Filsafat Ilmu", "Welhendri Azwar dan Muliono"));
        filsafat.tambahBuku(new Buku("Meditations", "Marcus Aurelius"));
        filsafat.tambahBuku(new Buku("Filsafat Agama", "Amsal Bakhtiar"));
        filsafat.tambahBuku(new Buku("Being", "Martin Heidegger"));
        filsafat.tambahBuku(new Buku("Filsafat Sejarah", "Ahmad Sahidin"));

        sejarah.tambahBuku(new Buku("Berlin", "Sinclair McKay"));
        sejarah.tambahBuku(new Buku("The History of the Ancient World", "Susan Wise Bauer"));
        sejarah.tambahBuku(new Buku("The Second World War", "Antony Beevor"));
        sejarah.tambahBuku(new Buku("1776", "David McCullough"));
        sejarah.tambahBuku(new Buku("The Diary of a Young Girl", "Anne Frank"));

        agama.tambahBuku(new Buku("Sejarah Islam", "Karen Armstrong"));
        agama.tambahBuku(new Buku("Mere Christianity", "C.S. Lewis"));
        agama.tambahBuku(new Buku("What the Buddha Taught", "Walpola Rahula"));
        agama.tambahBuku(new Buku("Tafsir ibn Kathir", "Ibn Kathir"));
        agama.tambahBuku(new Buku("Sejarah Nabi Muhammad", "Ibnu Hisyam"));

        psikologi.tambahBuku(new Buku("Psikologi Positif", "Husaini Usman"));
        psikologi.tambahBuku(new Buku("Psikologi Abnormal", "Kartini Kartono"));
        psikologi.tambahBuku(new Buku("Psikologi Kepribadian", "Sumadi Suryabrata"));
        psikologi.tambahBuku(new Buku("Psikologi Pendidikan", "Ahmadi Abu"));
        psikologi.tambahBuku(new Buku("Psikologi Kognitif", "Aaron Beck"));

        politik.tambahBuku(new Buku("The Prince", "Niccolò Machiavelli"));
        politik.tambahBuku(new Buku("On Democracy", "Robert Dahl"));
        politik.tambahBuku(new Buku("Demokrasi Kita", "Mohammad Hatta"));
        politik.tambahBuku(new Buku("Dari Sabang Sampai Merauke", "Yudi Latif"));
        politik.tambahBuku(new Buku("Sistem Politik Indonesia", "Miriam Budiardjo"));

        fiksi.tambahBuku(new Buku("Laut Bercerita", "Leila Chudori"));
        fiksi.tambahBuku(new Buku("Negeri 5 Menara", "Ahmad Fuadi"));
        fiksi.tambahBuku(new Buku("5 cm", "Dhonny Dhirgantoro"));
        fiksi.tambahBuku(new Buku("Perahu Kertas", "Dewi Lestari"));
        fiksi.tambahBuku(new Buku("Ayah", "Andrea Hirata"));

        for (Kategori kategori : kategoriList) {
            System.out.println("\nKategori: " + kategori.getNama());
            System.out.println("+------------------------------------+-------------------------------+");
            System.out.printf("| %-34s | %-29s |%n", "Judul Buku", "Penulis");
            System.out.println("+------------------------------------+-------------------------------+");
            for (Buku buku : kategori.getBukuList()) {
                System.out.printf("| %-34s | %-29s |%n", buku.getJudul(), String.join(", ", buku.getPenulis()));
            }
            System.out.println("+------------------------------------+-------------------------------+");
        }
    }
}