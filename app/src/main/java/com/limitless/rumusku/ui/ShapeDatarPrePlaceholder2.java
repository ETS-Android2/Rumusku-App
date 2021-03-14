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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.limitless.rumusku.OnDoneListener;
import com.limitless.rumusku.R;

import static android.view.View.GONE;


public class ShapeDatarPrePlaceholder2 extends Fragment {
    private LinearLayout val1, val2, val3, val4;
    private TextView tvVal1, tvVal2, tvVal3, tvVal4, tvRumus, tvPos;
    EditText etVal1, etVal2, etVal3, etVal4;
    private SharedPreferences preferences;
    private Button btnResult,btnShare,btnShare2;
    private int posisi;
    private String hasilKu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.item_pre_shape, container, false);

        tvRumus = root.findViewById(R.id.textView2);
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

        btnResult = root.findViewById(R.id.btn_count);
        btnShare = root.findViewById(R.id.btn_share_load);

        etVal1.setGravity(Gravity.CENTER);
        etVal2.setGravity(Gravity.CENTER);
        etVal3.setGravity(Gravity.CENTER);
        etVal4.setGravity(Gravity.CENTER);

        etVal1.setOnEditorActionListener(new OnDoneListener());
        etVal2.setOnEditorActionListener(new OnDoneListener());
        etVal3.setOnEditorActionListener(new OnDoneListener());
        etVal4.setOnEditorActionListener(new OnDoneListener());

        posisi = preferences.getInt("posisi", 0);
        tvRumus.setText(preferences.getString("luas", null));
        tvPos.setText("luas");

        onView(root);

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

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShare();
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
        String value = "Hai Gays!!!, Saya memakai Aplikasi Rumusku Untuk Mengetahui Rumus Matematika "+preferences.getString("datar",null)+" dan hasilnya adalah "+hasilKu+", Yuk Coba aplikasi ini Sayang mudah dan Ringan di gunakan.";
        i.putExtra(Intent.EXTRA_TEXT,value);
        startActivity(i.createChooser(i, "Bagikan Dengan :"));
    }


    private void onView(View root) {

        if (posisi == 0) {
            tvVal1.setText("s");

            //code
            val2.setVisibility(root.INVISIBLE);
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 1) {
            tvVal1.setText("p");
            tvVal2.setText("l");

            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 2) {
            tvVal1.setText("a");
            tvVal2.setText("t");
            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 3) {

            tvVal1.setText("a");
            tvVal2.setText("t");
            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 4) {

            tvVal1.setText("S");
            tvVal2.setText("t");
            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);

        } else if (posisi == 5) {
            tvVal1.setText("d1");
            tvVal2.setText("d2");
            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);
        } else if (posisi == 6) {
            tvVal1.setText("d1");
            tvVal2.setText("d2");
            //code
            val3.setVisibility(root.INVISIBLE);
            val4.setVisibility(root.INVISIBLE);
        } else {
            tvVal1.setText("r");
            //code
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


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onShare();
                Toast.makeText(getContext(),"test",Toast.LENGTH_SHORT).show();
            }
        });


        tvRumus.setText(preferences.getString("luas", null));
        try {


            if (posisi == 0) {

                tvCara1.setText(hasil + " x" + hasil);
                tvCara2.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil));
                ll_ops2.setVisibility(GONE);
                ll_ops3.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");

            } else if (posisi == 1) {
                tvCara1.setText(hasil + " x " + hasil1);
                tvCara2.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                hasilKu=String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1));
                ll_ops3.setVisibility(GONE);
                ll_ops2.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 2) {
                tvCara1.setText("½ x " + hasil + " x " + hasil1);
                tvCara2.setText("½ x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                tvCara3.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5);
                ll_ops2.setVisibility(GONE);

                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 3) {
                tvCara1.setText("½ x " + hasil + " x " + hasil1);
                tvCara2.setText("½ x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                tvCara3.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5);
                ll_ops2.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 4) {
                tvCara1.setText("½ x " + hasil + " x " + hasil1);
                tvCara2.setText("½ x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                tvCara3.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5);
                ll_ops2.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 5) {
                tvCara1.setText("½ x " + hasil + " x " + hasil1);
                tvCara2.setText("½ x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)));
                tvCara3.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5);
                ll_ops2.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 6) {
                tvCara1.setText("½ x " + hasil + " x " + hasil1);
                tvCara2.setText("½ x (" + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1)) + ")");
                tvCara3.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil1) * 0.5);
                ll_ops2.setVisibility(GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
            } else if (posisi == 7) {
                tvCara1.setText("3.14 x " + hasil + " X " + hasil);
                tvCara2.setText("3.14 x " + String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil)));
                tvHasil.setText(String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil) * 3.14));
                hasilKu = String.valueOf(Integer.valueOf(hasil) * Integer.valueOf(hasil) * 3.14);
                ll_ops2.setVisibility(view.GONE);
                ll_ops3.setVisibility(view.GONE);
                vval1.setText("L");
                vval2.setText("L");
                vval3.setText("L");
                vval4.setText("L");
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
