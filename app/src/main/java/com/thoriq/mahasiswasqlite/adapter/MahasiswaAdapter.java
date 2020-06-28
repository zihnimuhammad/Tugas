package com.thoriq.mahasiswasqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thoriq.mahasiswasqlite.DetailMahasiswaActivity;
import com.thoriq.mahasiswasqlite.R;
import com.thoriq.mahasiswasqlite.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private Context context;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList, Context context) {
        this.mahasiswaList = mahasiswaList;
        this.context = context;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public MahasiswaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_resultnama.setText(mahasiswaList.get(position).getNama());
        holder.txt_resulttempatlahir.setText(mahasiswaList.get(position).getTempat_lahir());
    }

    @Override
    public int getItemCount() {
        return getMahasiswaList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_resultnama,  txt_resulttempatlahir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_resultnama = (TextView) itemView.findViewById(R.id.txt_resultnama);
            txt_resulttempatlahir = (TextView) itemView.findViewById(R.id.txt_resulttempatlahir);


        }
    }
}
