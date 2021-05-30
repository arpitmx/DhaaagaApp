package com.india.suidhaga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridBannerAdapter extends BaseAdapter {

    ImageView productImage;
    TextView productBrand;
    TextView productName;
    TextView productPrice;

   List<MultipleProductbannerModel> GridBannerModelList;

    public GridBannerAdapter(List<MultipleProductbannerModel> multipleProductbannerModelList) {
        this.GridBannerModelList = multipleProductbannerModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view ;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multipleproductbanner_item,null);
            productImage = view.findViewById(R.id.item_image);
            productName = view.findViewById(R.id.pname);
            productBrand = view.findViewById(R.id.brand);
            productPrice = view.findViewById(R.id.price);

            productImage.setImageResource(GridBannerModelList.get(position).getPimage());
            productName.setText(GridBannerModelList.get(position).getPname());
            productBrand.setText(GridBannerModelList.get(position).getPbrand());
            productPrice.setText(GridBannerModelList.get(position).getPrice());

        }else{
            view = convertView;
        }

    return view;
    }
}
