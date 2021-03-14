package com.limitless.rumusku.model;

import com.limitless.rumusku.R;

import java.util.ArrayList;

public class DatarData {
    private static String[] bangundatarnama ={
            "Persegi",
            "Persegi Panjang",
            "Segitiga",
            "Jajar Genjang",
            "Trapesium",
            "Layang Layang",
            "Belah Ketupat",
            "Lingkaran"
    };


    private static int[] bangundatargambar={
            R.drawable.ic_square,
            R.drawable.ic_rectangle,
            R.drawable.ic_triangle,
            R.drawable.ic_pararellogam,
            R.drawable.ic_trapezoid,
            R.drawable.ic_kite,
            R.drawable.ic_rhomb,
            R.drawable.ic_circle
    };

    private static int[] datargambarisi={
            R.drawable.img_square,
            R.drawable.img_rectangle,
            R.drawable.img_triangle,
            R.drawable.img_pararellogam,
            R.drawable.img_trapezoid,
            R.drawable.img_kite,
            R.drawable.img_rhomb,
            R.drawable.img_circle
    };

    private static String[] datarrumuskeliling={
            "K = 4 x s",
            "K = 2 x (p+l)",
            "K = AB + BC + AC",
            "K = AB + BC + CD + AD",
            "K = AB + BC + CD + DA",
            "K = a + b + c + d",
            "K = 4 x s",
            "K = π x (r + r)"

    };

    private static String[] datarrumusluas={
            "L = s x s",
            "L = P x L",
            "L = ½ x a x t",
            "L = a x t",
            "L = ½ x jumlah sisi sejajar x tinggi",
            "L = ½ x d1 x d2",
            "L = ½ x d1 x d2",
            "L = π x r x r"

    };


    public static ArrayList<DatarModel> getListData(){
        ArrayList<DatarModel> list = new ArrayList<>();
        for (int post = 0; post < bangundatarnama.length;post++){
            DatarModel datarModels = new DatarModel();
            datarModels.setNama(bangundatarnama[post]);
            datarModels.setDatarGambar(bangundatargambar[post]);
            datarModels.setDatargambarisi(datargambarisi[post]);
            datarModels.setRumus(datarrumuskeliling[post]);
            datarModels.setLuas(datarrumusluas[post]);
            list.add(datarModels);
        }
        return list;
    }


}
