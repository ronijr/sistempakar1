package com.example.apps.com.sistempakar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RONIJR on 8/2/18.
 */

public class AdapterDiagnosa extends RecyclerView.Adapter<AdapterDiagnosa.ViewHolder> {
    private Context context;
    private List<Diagnosa> objectList;
    private Button btnadd;
    private Map<String, String> map = new HashMap<>();
    private List<String> arr = new ArrayList<>();
    public AdapterDiagnosa(Context context, List<Diagnosa> items, Button btnadd){
        this.context = context;
        this.objectList = items;
        this.btnadd = btnadd;
        for(int i=0; i<getItemCount(); i++){
            arr.add("");
        }
        Log.i("TAG","COUNT "+items.size());
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_checkbox, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Diagnosa obj = objectList.get(position);
        holder.ceklis.setText(obj.getName());
        holder.ceklis.setTag(position);
        holder.ceklis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(holder.ceklis.isChecked()){
                    holder.ceklis.setChecked(true);
                    arr.remove(position);
                    arr.add(position, obj.getId());
                } else {
                    holder.ceklis.setChecked(false);
                    arr.remove(position);
                    arr.add("");
                }
            }
        });


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ceklis)
        CheckBox ceklis;
        ICheckdeChangeListener iCheckdeChangeListener;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }




    public List<String> getCeklis(){
        return arr;
    }

    public void AddAllitem(List<Diagnosa> diagnosas){
        objectList.addAll(diagnosas);
        notifyDataSetChanged();
    }
}
