package com.thoriq.mahasiswasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thoriq.mahasiswasqlite.adapter.MahasiswaAdapter;
import com.thoriq.mahasiswasqlite.helper.DBHandler;
import com.thoriq.mahasiswasqlite.model.Mahasiswa;

import java.util.List;

public class TambahMahasiswaActivity extends AppCompatActivity {
    private EditText et_nama;
    private EditText et_tempatlahir;
    private Button button_tambahdata;

    private DBHandler dbHandler;
    private MahasiswaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents() {
        et_nama = (EditText) findViewById(R.id.et_nama);
        et_tempatlahir = (EditText) findViewById(R.id.et_tempatlahir);
        button_tambahdata = (Button) findViewById(R.id.button_tambahdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }

    private void validasiForm() {
        String form_nama = et_nama.getText().toString();
        String form_tempatlahir = et_tempatlahir.getText().toString();

        if (form_nama.isEmpty()){
            et_nama.setError("Isi nama dulu");
            et_nama.requestFocus();
        } if (form_tempatlahir.isEmpty()){
            et_tempatlahir.setError("Isi tempat lahir dulu");
            et_tempatlahir.requestFocus();
        } else {
            dbHandler.tambahMahasiswa(new Mahasiswa(form_nama, form_tempatlahir));
            List<Mahasiswa> mahasiswaList = dbHandler.getSemuaMahasiswa();
            adapter = new MahasiswaAdapter(mahasiswaList);
            adapter.notifyDataSetChanged();

            Toast.makeText(TambahMahasiswaActivity.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}