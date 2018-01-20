package com.noes.adeyds.basketscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextView tvSkorA, tvSkorB;
private Button a3,a2,a1, b3,b2,b1, reset;
private int hasilA, hasilB;

    private String SKOR_A = "skorA";
    private String SKOR_B = "skorB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSkorA = findViewById(R.id.tv_skorA);
        tvSkorB = findViewById(R.id.tv_skorB);

        a3=findViewById(R.id.btn_a3);
        a2=findViewById(R.id.btn_a2);
        a1=findViewById(R.id.btn_a1);
        b1=findViewById(R.id.btn_b1);
        b2=findViewById(R.id.btn_b2);
        b3=findViewById(R.id.btn_b3);
        reset=findViewById(R.id.btn_reset);

        clear();
        a3.setOnClickListener(this);
        a2.setOnClickListener(this);
        a1.setOnClickListener(this);
        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);
        reset.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasilA= savedInstanceState.getString(SKOR_A);
            String hasilB= savedInstanceState.getString(SKOR_B);


            tvSkorA.setText(hasilA);
            tvSkorB.setText(hasilB);
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(SKOR_A, tvSkorA.getText().toString());
        outState.putString(SKOR_B, tvSkorB.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        hasilA= Integer.parseInt(savedInstanceState.getString(SKOR_A));
        hasilB = Integer.parseInt(savedInstanceState.getString(SKOR_B));
        super.onRestoreInstanceState(savedInstanceState);
    }

    private int hitung (int hasil, int tambah, TextView skor){

        hasil +=tambah;
        skor.setText(String.valueOf(hasil));
        return hasil;
    }

    private void clear() {
        hasilA=hasilB=0;
        tvSkorA.setText(String.valueOf(hasilA));
        tvSkorB.setText(String.valueOf(hasilB));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_a1 : hasilA=hitung(hasilA,1, tvSkorA); break;
            case R.id.btn_a2 : hasilA=hitung(hasilA,2, tvSkorA); break;
            case R.id.btn_a3 : hasilA=hitung(hasilA,3, tvSkorA); break;

            case R.id.btn_b3 : hasilB=hitung(hasilB,3, tvSkorB); break;
            case R.id.btn_b2 : hasilB=hitung(hasilB,2, tvSkorB); break;
            case R.id.btn_b1 : hasilB=hitung(hasilB,1, tvSkorB); break;


            case R.id.btn_reset : clear(); break;

        }
    }
}
