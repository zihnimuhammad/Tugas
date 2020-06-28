package com.thoriq.mahasiswasqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.thoriq.mahasiswasqlite.adapter.MahasiswaAdapter;
import com.thoriq.mahasiswasqlite.helper.DBHandler;
import com.thoriq.mahasiswasqlite.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MahasiswaAdapter adapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()==true) {
            setTheme(R.style.DarkTheme);
        }
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        initRecyclerView();
        initComponents();
        cekDataRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_mahasiswa);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(ListMahasiswaActivity.this);
        mahasiswaList = dbHandler.getSemuaMahasiswa();
        adapter = new MahasiswaAdapter(mahasiswaList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    private void cekDataRecyclerView(){
        if (adapter.getItemCount() == 0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Mahasiswa mhs = mahasiswaList.get(position);
                            String nama = mhs.getNama();

                            Intent i = new Intent(ListMahasiswaActivity.this, DetailMahasiswaActivity.class);
                            i.putExtra(DetailMahasiswaActivity.EXTRA_MAHASISWA, mhs);
                            startActivity(i);
                        }
                    })
            );
        }
    }


}