package com.example.android.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CustomViewHolder> {

    private ArrayList<SampleData> list;

    public RvAdapter(ArrayList<SampleData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RvAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_view_item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(list.get(position).getIv_profile());
        holder.tv_title.setText(list.get(position).getTv_title());
        holder.tv_content.setText(list.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_title.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAbsoluteAdapterPosition());
                return true;
            }
        });
    }

    public void remove(int position) {
        try {
            list.remove(position);
            notifyItemChanged(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
//        return  0;
        return list != null ? list.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_title;
        protected TextView tv_content;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);



        }
    }
}
