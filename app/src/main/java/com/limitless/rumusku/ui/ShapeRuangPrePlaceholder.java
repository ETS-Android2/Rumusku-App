package com.limitless.rumusku.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.limitless.rumusku.OnDoneListener;
import com.limitless.rumusku.R;

public class ShapeRuangPrePlaceholder extends Fragment {
    private LinearLayout val1, val2, val3, val4;
    private TextView tvVal1, tvVal2, tvVal3, tvVal4, tvRumus, tvPos;
    private EditText etVal1, etVal2, etVal3, etVal4;
    private SharedPreferences preferences;
    private Button btnResult,btnShare;
    private int posisi;
    private String hasilKu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.item_pre_shape, container, false);

        tvRumus = root.findViewById(R.id.textView2);
        btnResult = root.findViewById(R.id.btn_count);
        preferences = root.getContext().getSharedPreferences("datar", 0);

        tvVal1 = root.findViewById(R.id.tv_val1);
        tvVal2 = root.findViewById(R.id.tv_val2);
        tvVal3 = root.findViewById(R.id.tv_val3);
        tvVal4 = root.findViewById(R.id.tv_val4);

        etVal1 = root.findViewById(R.id.et_val1);
        etVal2 = root.findViewById(R.id.et_val2);
        etVal3 = root.findViewById(R.id.et_val3);
        etVal4 = root.findViewById(R.id.et_val4);

        val1 = root.findViewById(R.id.ll_val1);
        val2 = root.findViewById(R.id.ll_val2);
        val3 = root.findViewById(R.id.ll_val3);
        val4 = root.findViewById(R.id.ll_val4);
        tvPos = root.findViewById(R.id.tv_kondisi);

        etVal1.setGravity(Gravity.CENTER);
        etVal2.setGravity(Gravity.CENTER);
        etVal3.setGravity(Gravity.CENTER);
        etVal4.setGravity(Gravity.CENTER);

        etVal1.setOnEditorActionListener(new OnDoneListener());
        etVal2.setOnEditorActionListener(new OnDoneListener());
        etVal3.setOnEditorActionListener(new OnDoneListener());
        etVal4.setOnEditorActionListener(new OnDoneListener());

        posisi = preferences.getInt("posisi", 0);
        tvRumus.setText(preferences.getString("rumus", null));
        tvPos.setText("Luas Permukaan");

        onView(root);

        btnShare = root.findViewById(R.id.btn_share_load);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShare();
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog dialog = new BottomSheetDialog(getContext(), R.style.LoadShape);
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_load_shape, (LinearLayout) root.findViewById(R.id.item_load_shape));

                onAction(view, root, dialog);

                view.findViewById(R.id.btn_share_load).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onSharehasil();
                    }
                });

                view.findViewById(R.id.btn_count_load).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });

            }
        });

        return root;

    }

    private void onSharehasil() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String value = "Hai Gays!!!, Saya memakai Aplikasi Rumusku Untuk Mengetahui Rumus Matematika "+preferences.getString("datar",null)+" dan hasilnya adalah "+hasilKu+", Yuk Coba aplikasi ini Sayang mudah dan Ringan di gunakan.";
        i.putExtra(Intent.EXTRA_TEXT,value);
        startActivity(i.createChooser(i, "Bagikan Dengan :"));
    }

    private void onShare() {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String value = "Hai Gays!!!, Saya memakai Aplikasi Rumusku Untuk Mengetahui Rumus Matematika "+preferences.getString("datar",null)+" , Yuk Coba aplikasi ini Sayang mudah dan Ringan di gunakan.";
            i.putExtra(Intent.EXTRA_TEXT,value);
            startActivity(i.createChooser(i, "Bagikan Dengan :"));
        }



    private void onView(View root) {
        if (posisi == 0) {
            tvVal1.setText("s");

            val2.setVisibility(root.INVISIBLE);
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 1) {
            tvVal1.setText("p");
            tvVal2.setText("l");
            tvVal3.setText("t");


            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 2) {
            tvVal1.setText("La");
            tvVal2.setText("k");
            tvVal3.setText("t");

            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 3) {

            tvVal1.setText("r");
            tvVal2.setText("t");

            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);


        } else if (posisi == 4) {

            tvVal1.setText("r");
            tvVal2.setText("s");

            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);


        } else if (posisi == 5) {
            tvVal1.setText("r");

            val2.setVisibility(root.INVISIBLE);
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        }
    }

    private void onAction(View view, View root, BottomSheetDialog dialog) {
        TextView tvCara1 = view.findViewById(R.id.tv_cara1);
        TextView tvCara2 = view.findViewById(R.id.tv_cara2);
        TextView tvCara3 = view.findViewById(R.id.tv_cara3);
        TextView tvOps = view.findViewById(R.id.tv_ops);
        TextView tvHasil = view.findViewById(R.id.tv_hasil);
        LinearLayout ll_ops1 = view.findViewById(R.id.ll_ops1);
        LinearLayout ll_ops2 = view.findViewById(R.id.ll_ops2);
        LinearLayout ll_ops3 = view.findViewById(R.id.ll_ops3);

        final TextView vval1 = view.findViewById(R.id.vVal1);
        final TextView vval2 = view.findViewById(R.id.vVal2);
        final TextView vval3 = view.findViewById(R.id.vVal3);
        final TextView vval4 = view.findViewById(R.id.vVal4);

        EditText etVal11 = (EditText) root.findViewById(R.id.et_val1);
        EditText etVal21 = (EditText) root.findViewById(R.id.et_val2);
        EditText etVal31 = (EditText) root.findViewById(R.id.et_val3);
        EditText etVal41 = (EditText) root.findViewById(R.id.et_val4);
        tvRumus = view.findViewById(R.id.tv_rumus);

        String hasil = etVal11.getText().toString();
        String hasil1 = etVal21.getText().toString();
        String hasil2 = etVal31.getText().toString();
        String hasil3 = etVal41.getText().toString();

        try {


            if (posisi == 0) {

                tvRumus.setText(preferences.getString("rumus", null));
                tvCara1.setText("6 x " + hasil + "²");
                tvCara2.setText(String.valueOf((Integer.valueOf(hasil) * Integer.valueOf(hasil)) * 6));
                tvHasil.setText(String.valueOf((Integer.valueOf(hasil) * Integer.valueOf(hasil)) * 6));
                hasilKu = String.valueOf((Integer.valueOf(hasil) * Integer.valueOf(hasil)) * 6);
                ll_ops2.setVisibility(view.GONE);
                ll_ops3.setVisibility(view.GONE);
                vval1.setText("Lp");
                vval2.setText("Lp");
                vval3.setText("Lp");
                vval4.setText("Lp");

            } else if (posisi == 1) {

                tvRumus.setText(preferences.getString("rumus", null));
                tvCara1.setText("2 x {(" + hasil + " x " + hasil1 + ") + (" + hasil + " x " + hasil2 + ") + (" + hasil1 + " x " + hasil2 + ")}");
                tvCara2.setText("2 x {(" + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + " + " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil2)) + " + " + String.valueOf(Integer.valueOf(hasil1) * Integer.valueOf(hasil2)) + ")}");
                tvOps.setText("2 x {(" + String.valueOf((Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + (Integer.valueOf(hasil) * Integer.valueOf(hasil2)) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))) + ")}");
                tvCara3.setText(String.valueOf(((Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + (Integer.valueOf(hasil) * Integer.valueOf(hasil2)) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))) * 2));
                tvHasil.setText(String.valueOf(((Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + (Integer.valueOf(hasil) * Integer.valueOf(hasil2)) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))) * 2));
                hasilKu = String.valueOf(((Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + (Integer.valueOf(hasil) * Integer.valueOf(hasil2)) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))) * 2);
                vval1.setText("Lp");
                vval2.setText("Lp");
                vval3.setText("Lp");
                vval4.setText("Lp");

            } else if (posisi == 2) {
                tvRumus.setText(preferences.getString("rumus", null));
                tvCara1.setText("(2 x " + hasil + ") + (" + hasil1 + " x " + hasil2 + ")");
                tvCara2.setText(String.valueOf(Integer.valueOf(hasil) * 2) + " + " + String.valueOf(Integer.valueOf(hasil1) * Integer.valueOf(hasil2)));
                tvCara3.setText(String.valueOf((Integer.valueOf(hasil) * 2) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))));
                tvHasil.setText(String.valueOf((Integer.valueOf(hasil) * 2) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2))));
                hasilKu = String.valueOf((Integer.valueOf(hasil) * 2) + (Integer.valueOf(hasil1) * Integer.valueOf(hasil2)));
                ll_ops2.setVisibility(view.GONE);
                vval1.setText("Lp");
                vval2.setText("Lp");
                vval3.setText("Lp");
                vval4.setText("Lp");


            } else if (posisi == 3) {
                tvRumus.setText(preferences.getString("rumus", null));
                tvCara1.setText("2 x 3,14 x" + hasil + " x (" + hasil + " + " + hasil2 + ")");
                tvCara2.setText("2 x 3,14 x " + hasil + " x " + String.valueOf(Integer.valueOf(hasil) + Integer.valueOf(hasil1)));
                tvOps.setText("6,28 x " + String.valueOf(Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                tvCara3.setText(String.valueOf(6.28 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                tvHasil.setText(String.valueOf(6.28 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                hasilKu = String.valueOf(6.28 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1))));
                vval1.setText("Lp");
                vval2.setText("Lp");
                vval3.setText("Lp");
                vval4.setText("Lp");

            } else if (posisi == 4) {
                tvCara1.setText("3,14 x" + hasil + " x (" + hasil + " + " + hasil2 + ")");
                tvCara2.setText("3,14 x " + hasil + " x " + String.valueOf(Integer.valueOf(hasil) + Integer.valueOf(hasil1)));
                tvOps.setText("3,14 x " + String.valueOf(Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                tvCara3.setText(String.valueOf(3.14 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                tvHasil.setText(String.valueOf(3.14 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1)))));
                hasilKu = String.valueOf(3.14 * Integer.valueOf(hasil) * ((Integer.valueOf(hasil) + Integer.valueOf(hasil1))));
                vval1.setText("Lp");
                vval2.setText("Lp");
                vval3.setText("Lp");
                vval4.setText("Lp");

            } else if (posisi == 5) {
                tvRumus.setText(preferences.getString("rumus", null));
                tvCara1.setText("4 x 3,14 x " + hasil + "² ");
                tvCara2.setText("12,56 x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                tvCara3.setText(String.valueOf(12.56 * Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                tvHasil.setText(String.valueOf(12.56 * Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                hasilKu = String.valueOf(12.56 * Integer.valueOf(hasil) * Integer.valueOf(hasil));
                ll_ops2.setVisibility(view.GONE);
            }

            dialog.setContentView(view);
            dialog.show();
        } catch (Exception e) {
            etVal11.setError("Tidak Boleh Kosong");
            etVal21.setError("Tidak Boleh Kosong");
            etVal31.setError("Tidak Boleh Kosong");
            etVal41.setError("Tidak Boleh Kosong");
        }
    }

}
