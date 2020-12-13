package com.example.kinomap;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //private Context context;
    private ArrayList<Vehicles> vcs;
   //private ItemListener itemListener;

    public RecyclerViewAdapter(ArrayList<Vehicles> vcs){ //Context context, ItemListener itemListener
        //this.context = context;
        this.vcs = vcs;
        //this.itemListener = itemListener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nom2.setText(vcs.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return vcs != null ? vcs.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public ImageView icon;
        private TextView nom2;

        //public View layout;
        public ViewHolder(View view) {
            super(view);
            nom2 = (TextView) view.findViewById(R.id.nom2);

        }
    }




    public void addIntPosition(int position, Vehicles vehicles){
        vcs.add(position, vehicles);
        notifyItemInserted(position);
    }

    public void removeIntPosition(int position){
        vcs.remove(position);
        notifyItemRemoved(position);
    }

}
