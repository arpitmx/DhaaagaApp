package com.india.suidhaga;

import android.app.Activity;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

class MyAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] title;
    private final String[] subtitle;
    private final Integer[] imageId;
    private final String[] price;
    private final String[] companyname;


    public MyAdapter(Activity context, String[] titles, String[] subtitles, Integer[] imageidsp, String[] price, String[] companyname){
        super (context,R.layout.listrow,titles);

        this.context = context;
        this.imageId= imageidsp;
        this.title=titles;
        this.subtitle = subtitles;
        this.price = price;
        this.companyname = companyname;


    }

    public View getView (int Position, View view, ViewGroup Parent){

        LayoutInflater inflater= context.getLayoutInflater();
        View myrowVIEW = inflater.inflate(R.layout.listrow,null,true);

        TextView titles = myrowVIEW.findViewById(R.id.title);
        TextView subtitles = myrowVIEW.findViewById(R.id.subtitle);
        ImageView images = myrowVIEW.findViewById(R.id.image);
        TextView prices = myrowVIEW.findViewById(R.id.price);
TextView companynameview = myrowVIEW.findViewById(R.id.companyname);

        titles.setText(title[Position]);
        subtitles.setText(subtitle[Position]);
        images.setImageResource(imageId[Position]);
        prices.setText(price[Position]);
        companynameview.setText(companyname[Position]);


        return myrowVIEW;






    }




}
