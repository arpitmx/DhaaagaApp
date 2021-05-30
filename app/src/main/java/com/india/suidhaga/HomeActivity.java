package com.india.suidhaga;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HomeActivity extends Activity {
    RatingBar ratingBar;
    TextView sub;
    ImageView myIntentmaker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        myIntentmaker = findViewById(R.id.intentamore);
        setContentView(R.layout.productview);


        String[] title = {"Summer Hits!", "Gloomy Jeans", "Outing Busters", "Purest Silk."};
        String[] subtitle = {"Starting at just party wear,etc.", "Known for the Bliss.Promise from us,It will rock the party!", "You will love it,We know you will.Outing outfits From Motilal!", "We mean it when we say purest."};
        Integer[] image = {R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2};
        String[] price = {"25$-179.99$", "29.99$ onwards", "18.99$ onwards", "40.99$ onwards"};
        int[] rating = {4, 3, 4, 3};
        String[] Companyname = {"TusharNsons", "SuiDhaaga,Kanpur.", "MotilalCO.", "SaiyamKapdeWale"};

      MyAdapter adapter = new MyAdapter(HomeActivity.this,title,subtitle,image,price,Companyname);
        ListView listView = findViewById(R.id.ListViewID);
        listView.setAdapter(adapter);

       //For the Fuctions
        sub = findViewById(R.id.subtitle);


        for (int i =0;i<= (Companyname.length)-1;i++){
            Companyname[i]+=("@dhaaga.in");}

for(int i = 0;i<(subtitle.length);i++) {
    String textSub = subtitle[i];
    if(textSub.trim().length() >60) {
        String showTemp = textSub.substring(0, 50);
        showTemp += "...";
       subtitle[i] = showTemp;
    }}

//rating bar



















    }
}







