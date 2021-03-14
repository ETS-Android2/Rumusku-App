package com.limitless.rumusku.model;

import com.limitless.rumusku.R;

import java.util.ArrayList;

public class RuangData {
    private static String[] ruangnama ={
            "Kubus",
            "Balok",
//            "Limas.",
            "Prisma",
            "Tabung",
            "Kerucut",
            "Bola"
    };

    private static int[] ruanggambar={
            R.drawable.ic_cube,
            R.drawable.ic_blok,
//            R.drawable.ic_triangle,
            R.drawable.ic_prism,
            R.drawable.ic_tube,
            R.drawable.ic_cone,
            R.drawable.ic_ball
    };

    private static int[] ruanggambarisi={
            R.drawable.img_cube,
            R.drawable.img_blok,
//            R.drawable.img_triangle,
            R.drawable.img_prism,
            R.drawable.img_tube,
            R.drawable.img_cone,
            R.drawable.img_ball
    };

    private static String[] ruangrumusluasP={
            "Lp = 6 x s²",
            "Lp = 2{(p x l)+(p x t)+(l x t)}",
//            "Lp = AB + BC + AC",
            "Lp = 3s atau (s + s + s)",
            "Lp = 2 * π * r * (r+t)",
            "Lp = π r (r+s)",
            "Lp = 4 * π * r²"

    };

    private static String[] ruangrumusVolume={
            "V = s x s x s atau s²",
            "V = p x l x t",
//            "Lp = AB + BC + AC",
            "V = La x t",
            "V = π * r2 * t",
            "V = 1/3 x π x r² x t",
            "V = 4/3 * π * r3"

    };

    public static ArrayList<RuangModel> getListDataRuang(){
        ArrayList<RuangModel> list = new ArrayList<>();
        for (int post = 0; post < ruangnama.length;post++){
            RuangModel ruangModel = new RuangModel();
            ruangModel.setNama(ruangnama[post]);
            ruangModel.setRuangGambar(ruanggambar[post]);
            ruangModel.setRuangGambarIsi(ruanggambarisi[post]);
            ruangModel.setVolume(ruangrumusVolume[post]);
            ruangModel.setLuasP(ruangrumusluasP[post]);
            list.add(ruangModel);
        }
        return list;
    }





}
