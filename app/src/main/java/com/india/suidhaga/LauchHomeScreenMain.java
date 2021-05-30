package com.india.suidhaga;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LauchHomeScreenMain extends AppCompatActivity {

    CardView card;
    TextView themeChange;
    LinearLayout layout;
    LayoutInflater inflaterx;
    ConstraintLayout relativeLayout;
   CardView fox;
    boolean themechange = false;
    Button btn;
    ConstraintLayout c;
  private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;


    //////////////////////BannerSlider//////////////////

    ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    int CurrentPage = 0;
    Timer timer;
    int DELAY_TIME = 1000;
    int PERIOD_TIME = 1000;

    //////////////////////BannerSlider//////////////////




//////////////////////////StripAdView/////////////////////////////////////////////

private RelativeLayout relay;
private ImageView stripAdImage;

//////////////////////////StripAdView////////////


//////////////////////////MultiproductBanner////////////////////////////////////////////

    private TextView layoutTitle ;
    private Button ViewAll;
    private RecyclerView HorizontalRecyclerView;

//////////////////////////MultiProductBanner////////////


//////////////////////////GridBannerLayout///////////////////////////////////////////////

GridView gridView ;
GridView gridView2s;
///////////////////GridBannerLayout//////////////////////////////////////////////




//////////////////////////LimitedTimeSaleOffer///////////////////////////////////////////////

    GridView limitedtimesaleofferGridView ;
    ViewPager limitedtimesaleofferViewPager;
    ArrayList<LimitedoffBanner_Model> vList;




///////////////////LimitedTimeSaleOffer//////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        themeChange = findViewById(R.id.Dhaaga);
        layout = findViewById(R.id.linlay);
        card = findViewById(R.id.card);
       relativeLayout = (ConstraintLayout)findViewById(R.id.relay);
        btn = findViewById(R.id.Realtime);
        categoryRecyclerView = findViewById(R.id.CategoryResc);
        c = (ConstraintLayout) findViewById(R.id.SliderConstaint);
        LayoutInflater layoutInflater;


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauchHomeScreenMain.this, RecyclerAct.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LauchHomeScreenMain.this, ProductsFirebase.class);
                startActivity(i);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(LauchHomeScreenMain.this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        List<Category_Model> categorymodelList = new ArrayList<>();
        categorymodelList.add(new Category_Model("link", "Cart"));
        categorymodelList.add(new Category_Model("link", "Discount"));
        categorymodelList.add(new Category_Model("link", "Reward"));
        categorymodelList.add(new Category_Model("link", "Sales"));
        categorymodelList.add(new Category_Model("link", "Decoratives"));
        categorymodelList.add(new Category_Model("link", "Specials"));
        categorymodelList.add(new Category_Model("link", "Hots"));
        categorymodelList.add(new Category_Model("link", "Best"));

        categoryAdapter = new CategoryAdapter(categorymodelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();





//////////////////////////BannerSlider/////////////////////////////////////////////

inflaterx = getLayoutInflater();
Start(inflaterx,relativeLayout);

//////////////////////////BannerSlider///////////////////////////////////////////




//////////////////////////StripAdView/////////////////////////////////////////////

        stripAdImage = findViewById(R.id.stripadimage);
        relay = findViewById(R.id.strip_ad_container);
        stripAdImage.setImageResource(R.drawable.s1);



//////////////////////////StripAdView////////////









//////////////////////////MultiproductBanner////////////////////////////////////////////

        layoutTitle = findViewById(R.id.txt);
        ViewAll = findViewById(R.id.viewallbtn);
        HorizontalRecyclerView = findViewById(R.id.RCview);
        List<MultipleProductbannerModel> list = new ArrayList<>();
        list.add(new MultipleProductbannerModel(R.drawable.sb4,"Armani Bond.","Emporio Armani","$409.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb5,"Armani Fibre.","Emporio Armani","$509.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb6,"Armani Class.","Emporio Armani","$309.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb7,"Armani Nebula.","Emporio Armani","$809.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb8,"Armani Flame.","Emporio Armani","$609.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb9,"Armani Succi.","Emporio Armani","$509.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb6,"Armani Medona.","Emporio Armani","$1009.99"));
        list.add(new MultipleProductbannerModel(R.drawable.sb4,"Armani Elite.","Emporio Armani","$709.99"));

       try {
           MultipleProductbannerAdapter adapter = new MultipleProductbannerAdapter(list);
           LinearLayoutManager LM = new LinearLayoutManager(LauchHomeScreenMain.this);
           LM.setOrientation(LinearLayoutManager.HORIZONTAL);
           HorizontalRecyclerView.setLayoutManager(LM);

           HorizontalRecyclerView.setAdapter(adapter);
           adapter.notifyDataSetChanged();
       }catch (Exception e ){
           Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
           e.printStackTrace();
       }

//////////////////////////MultiProductBanner////////////



//////////////////////////GridBannerLayout///////////////////////////////////////////////

 gridView= findViewById(R.id.gridproductlayout);

        List<MultipleProductbannerModel> gridlist = new ArrayList<>();
        gridlist.add(new MultipleProductbannerModel(R.drawable.sh1,"Nike Bond.","Nike","$349.99"));
        gridlist.add(new MultipleProductbannerModel(R.drawable.sh2,"Reebok Fibre.","Reebok","$309.99"));
        gridlist.add(new MultipleProductbannerModel(R.drawable.sh7,"Furo Air.","Furo","$239.99"));
        gridlist.add(new MultipleProductbannerModel(R.drawable.sh10,"Addidas Nebula.","Addidas","$309.99"));


        gridView.setAdapter(new GridBannerAdapter(gridlist));

gridView2s = findViewById(R.id.gridproductlayout2);

        List<MultipleProductbannerModel> g = new ArrayList<>();
        g.add(new MultipleProductbannerModel(R.drawable.st1,"Nike Studd.","Nike","$349.99"));
        g.add(new MultipleProductbannerModel(R.drawable.st2,"Reebok Nebula.","Reebok","$309.99"));
        g.add(new MultipleProductbannerModel(R.drawable.st3,"Furo Fire.","Furo","$239.99"));
        g.add(new MultipleProductbannerModel(R.drawable.st4,"Addidas Mocker.","Addidas","$309.99"));


gridView2s.setAdapter(new GridBannerAdapter(g));

///////////////////GridBannerLayout//////////////////////////////////////////////


///////////////////LimitedTimeSaleOffer//////////////////////////////////////////////
        vList = new ArrayList<LimitedoffBanner_Model>();
       limitedtimesaleofferViewPager = findViewById(R.id.limitedsaleBannerViwPager);

        vList.add(new LimitedoffBanner_Model(R.drawable.sh1,"PumaX 360","$240.99/-","$800","12:22:12","$400"));
        vList.add(new LimitedoffBanner_Model(R.drawable.sh2,"Nike  260","$321.99/-","$800","12:22:12","$400"));
        vList.add(new LimitedoffBanner_Model(R.drawable.sh7,"Puma Shot","$399.00/-","$800","12:22:12","$400"));
        vList.add(new LimitedoffBanner_Model(R.drawable.st2,"Puma Mana","$324.99/-","$800","12:22:12","$400"));

        LimitedoffBanner_Adapter LOBadapter = new LimitedoffBanner_Adapter(vList);
        limitedtimesaleofferViewPager.setAdapter(LOBadapter);
        limitedtimesaleofferViewPager.setClipToPadding(false);
        limitedtimesaleofferViewPager.setPageMargin(20);


        limitedtimesaleofferGridView = findViewById(R.id.limitedsaleannerGridview);
        limitedtimesaleofferGridView.setAdapter(new GridBannerAdapter(g));

///////////////////LimitedTimeSaleOffer//////////////////////////////////////////////


//////////////////////////////RecylerBannerLoader////////////////////////////////////

        RecyclerView testing = findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(LauchHomeScreenMain.this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);



/////////////////////////////RecylerBannerLoader////////////////////////////////////


    }



    public View Start(LayoutInflater inflater, ViewGroup container) {


        View view = inflater.inflate(R.layout.activity_home_screen,container,false);

        bannerSliderViewPager = findViewById(R.id.banner_slider_viewpager);
        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.d11));
        sliderModelList.add(new SliderModel(R.drawable.d12));

        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.d2));
        sliderModelList.add(new SliderModel(R.drawable.d3));
        sliderModelList.add(new SliderModel(R.drawable.d4));
        sliderModelList.add(new SliderModel(R.drawable.d5));
        sliderModelList.add(new SliderModel(R.drawable.d6));
        sliderModelList.add(new SliderModel(R.drawable.d7));
        sliderModelList.add(new SliderModel(R.drawable.d8));
        sliderModelList.add(new SliderModel(R.drawable.d9));
        sliderModelList.add(new SliderModel(R.drawable.d10));
        sliderModelList.add(new SliderModel(R.drawable.d11));
        sliderModelList.add(new SliderModel(R.drawable.d12));

        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.d2));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onpageL = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CurrentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if  ( state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };



        bannerSliderViewPager.addOnPageChangeListener(onpageL);


        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event){

                pageLooper();
                StopBannerSlider();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });





        return view;

    }





    private void pageLooper(){

        if(CurrentPage == (sliderModelList.size()-2)){

            CurrentPage = 2;
            bannerSliderViewPager.setCurrentItem(CurrentPage,false);

        }
        if(CurrentPage == 1 ){

            CurrentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(CurrentPage,false);
        }

    }

    private void startBannerSlideShow(){
        Handler handler = new Handler();
        Runnable update = new Runnable(){
            @Override
            public void run(){
                if (CurrentPage >= sliderModelList.size()){
                    CurrentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(CurrentPage++,true);

            }

        };

        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                handler.post(update);
            }},DELAY_TIME,PERIOD_TIME);

    }


    private void StopBannerSlider(){
        timer.cancel();
    }
}














