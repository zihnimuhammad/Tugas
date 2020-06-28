package com.thoriq.mahasiswasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.thoriq.mahasiswasqlite.model.Mahasiswa;

public class DetailMahasiswaActivity extends AppCompatActivity {
    public static final String EXTRA_MAHASISWA = "extra_mahasiswa";
    TextView txtNama, txtTempatLahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        txtNama = findViewById(R.id.txt_nama);
        txtTempatLahir = findViewById(R.id.txt_tempatlahir);

        Mahasiswa mahasiswa = getIntent().getParcelableExtra(EXTRA_MAHASISWA);

        txtNama.setText(mahasiswa.getNama());
        txtTempatLahir.setText(mahasiswa.getTempat_lahir());
    }
}