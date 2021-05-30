package com.india.suidhaga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultipleProductbannerAdapter extends RecyclerView.Adapter<MultipleProductbannerAdapter.ViewHolder> {


    private List<MultipleProductbannerModel> MPList;

    public MultipleProductbannerAdapter(List<MultipleProductbannerModel> MPList) {
        this.MPList = MPList;


    }

    @NonNull
    @Override
    public MultipleProductbannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multipleproductbanner_item,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleProductbannerAdapter.ViewHolder holder, int position) {
           int resource = MPList.get(position).getPimage();
           String title = MPList.get(position).getPname();
           String brandname = MPList.get(position).getPbrand();
           String price = MPList.get(position).getPrice();

           holder.setprImage(resource);
           holder.setprBrand(brandname);
           holder.setProduct_title(title);
           holder.setprPrice(price);
    }

    @Override
    public int getItemCount() {
        return MPList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pImage;
        private TextView product_title;
        private TextView product_brand;
        private TextView product_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pImage = itemView.findViewById(R.id.item_image);
            product_title = itemView.findViewById(R.id.pname);
            product_brand = itemView.findViewById(R.id.brand);
            product_price = itemView.findViewById(R.id.price);

        }

        private void setprImage(int resource){
            pImage.setImageResource(resource);

        }
        private void setProduct_title(String title){
            product_title.setText(title);

        }
        private void setprBrand(String brand){
            product_brand.setText(brand);

        }private void setprPrice(String price){
            product_price.setText(price);

        }

    }
}
