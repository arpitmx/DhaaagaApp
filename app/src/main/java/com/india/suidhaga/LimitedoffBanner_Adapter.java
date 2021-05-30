package com.india.suidhaga;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class LimitedoffBanner_Adapter extends PagerAdapter {

    private List<LimitedoffBanner_Model> LimitedoffBannerList;

    public LimitedoffBanner_Adapter(List<LimitedoffBanner_Model> LimitedoffBannerList) {
        this.LimitedoffBannerList = LimitedoffBannerList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.limitedoffbanner_viewpageritem,container,false);
        ImageView LOBimageview  = view.findViewById(R.id.viewpagerimageslider);
        TextView LOBproductname = view.findViewById(R.id.ProductNamemain);
        TextView LOBpriceNow = view.findViewById(R.id.pricenowmain);
        TextView LOBsavedprice = view.findViewById(R.id.yousavedmain);
        TextView LOBtimeleft = view.findViewById(R.id.timeleft);
        TextView LOBoldprice = view.findViewById(R.id.oldprice);


        LOBimageview.setImageResource(LimitedoffBannerList.get(position).getProductImage());
        LOBproductname.setText(LimitedoffBannerList.get(position).getProductName());
        LOBpriceNow.setText(LimitedoffBannerList.get(position).getProductPrice_Now());
        LOBsavedprice.setText(LimitedoffBannerList.get(position).getProductPrice_Before());
        LOBtimeleft.setText(LimitedoffBannerList.get(position).getTimeleft());
        LOBoldprice.setText(LimitedoffBannerList.get(position).getOldPrice());
        LOBoldprice.setPaintFlags(LOBoldprice.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 3 ;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object ;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container , int Position,@NonNull Object obj) {
        container.removeView((View) obj);

    }
}

