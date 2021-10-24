package com.uts_pbp_c_9229.listdata;

import com.uts_pbp_c_9229.dao.City;
import com.uts_pbp_c_9229.dao.Destination;
import com.uts_pbp_c_9229.dao.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DestinationList {
    public ArrayList<Destination> destinations;

    public DestinationList(){
        destinations = new ArrayList<>();
        destinations.add(d1);
        destinations.add(d2);
        destinations.add(d3);
        destinations.add(d4);
        destinations.add(d5);
        destinations.add(d6);
        destinations.add(d7);
        destinations.add(d8);
    }

    public Destination getDestinationById(int id){
        for(Destination destination : destinations){
            if(destination.getId() == id)
                return destination;
        }
        return null;
    }

    public static final Destination d1 =
            new Destination(1,"YOGYAKARTA", "Paralayang Beach",
                    "Beach", "https://i.ibb.co/qFyp5Xh/paralayang-1.png",
                    "Area Hutan, Giricahyo, Purwosari, Kabupaten Gunung Kidul, Daerah Istimewa Yogyakarta 55872",
                    "Bukit Paralayang Parangtritis merupakan sebuah tempat wisata di Yogyakarta. Tempat wisata ini menyajikan pemandangan Pantai Parangtritis " +
                            "dari atas bukit dengan ketinggian 900 mdpl dan pemandangan matahari terbenam.");
    public static final Destination d2 =
            new Destination(2,"YOGYAKARTA", "Glagah Beach",
                    "Beach", "https://i.ibb.co/BnwY5NQ/glagah-1.png",
                    " Desa Glagah, Kecamatan Temon, Kabupaten Gunungkidul, Daerah Istimewa Yogyakarta   ",
                    "Pantai Glagah Indah merupakan salah satu pantai di Yogyakarta dengan hamparan pasir yang berwarna hitam dan banyak mengandung pasir besi.");
    public static final Destination d3 =
            new Destination(3,"BALI", "FINNS Beach Club",
                    "Beach", "https://i.ibb.co/8Y5SYRc/finss-club-2.png",
                    "Jl. Pantai Berawa No.99, Canggu, Kec. Kuta Utara,  Kabupaten Badung, Bali 80361",
                    "Tempat nongkrong tepi pantai ramai  yang menawarkan 2 restoran,  kedai sushi, 5 bar, dan 2 kolam renang outdoor.");
    public static final Destination d4 =
            new Destination(4,"BALI", "Pandawa Beach",
                    "Beach", "https://i.ibb.co/PFT2zSx/pantai-pandawa-1.png",
                    "Jalan Pantai Pandawa, Desa Kutuh, Kecamatan Kuta Selatan, Kabupaten Badung, Provinsi Bali 80361",
                    "Pantai Pandawa adalah salah satu kawasan wisata di area Kuta selatan, Kabupaten Badung, Bali. Pantai ini terletak di balik perbukitan dan sering disebut sebagai Pantai Rahasia.");
    public static final Destination d5 =
            new Destination(5,"BALI", "Beachwalk",
                    "Beach", "https://i.ibb.co/V9WyJPy/beachwalk-1.png",
                    " Jl. Pantai Kuta, Kuta, Kabupaten Badung, Bali 80361",
                    "Beachwalk adalah pusat perbelanjaan yang terletak di kawasan Badung, Bali,dan menghadap langsung ke pantai utama Pantai Kuta.");

    public static final Destination d6 =
            new Destination(6,"JAKARTA", "Kota Tua",
                    "City", "https://ik.imagekit.io/tvlk/blog/2018/08/Jakarta-Museum-Fatahillah-756302473.jpg?tr=dpr-1,w-675",
                    "Jalan Pintu Besar Utara Nomer 27, RT 07/ RW 07, Pinangsia, Tamansari, Jakarta Barat, DKI Jakarta",
                    "Kota tua di Jakarta, yang juga bernama Kota Tua, berpusat di Alun-Alun Fatahillah, yaitu alun-alun yang ramai dengan pertunjukan rutin tarian tradisional.");

    public static final Destination d7 =
            new Destination(7,"YOGYAKARTA", "Candi Prambanan",
                    "Temple", "https://akcdn.detik.net.id/community/media/visual/2020/03/20/b86bb4c8-f0b2-4771-83f3-57b723d5ccd4_169.jpeg?w=700&q=90",
                    "Jl. Raya Solo - Yogyakarta No.16, Kranggan, Bokoharjo, Kec. Prambanan, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55571",
                    "Candi Prambanan atau Candi Roro Jonggrang adalah kompleks candi Hindu terbesar di Indonesia yang dibangun pada abad ke-9 masehi. Candi ini dipersembahkan untuk Trimurti, tiga dewa utama Hindu yaitu Brahma sebagai dewa pencipta, Wisnu sebagai dewa pemelihara, dan Siwa sebagai dewa pemusnah.");

    public static final Destination d8 =
            new Destination(8,"SEMARANG", "Candi Borobudur",
                    "Temple", "https://backpanel.kemlu.go.id/PublishingImages/Borobudur/Bor%202.JPG",
                    " Jl. Badrawati, Kw. Candi Borobudur, Borobudur, Kec. Borobudur, Magelang, Jawa Tengah",
                    "Borobudur adalah sebuah candi Buddha yang terletak di Borobudur, Magelang, Jawa Tengah, Indonesia. Candi ini terletak kurang lebih 100 km di sebelah barat daya Semarang, 86 km di sebelah barat Surakarta, dan 40 km di sebelah barat laut Yogyakarta.");
}
