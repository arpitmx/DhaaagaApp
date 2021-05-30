package com.india.suidhaga;/////Banner Slider For Dhaaaga

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MiddleSliderMain{

	ViewGroup container;
ViewPager bannerSliderViewPager;
private List<SliderModel> sliderModelList;
int CurrentPage = 0;
Timer timer;
int DELAY_TIME = 3000;
ConstraintLayout c ;
int PERIOD_TIME = 3000;

public View Start(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


	 View view = inflater.inflate(R.layout.activity_home_screen,container,false);

	bannerSliderViewPager = view.findViewById(R.id.banner_slider_viewpager);
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
	sliderModelList.add(new SliderModel(R.drawable.d13));
	sliderModelList.add(new SliderModel(R.drawable.d14));
	sliderModelList.add(new SliderModel(R.drawable.d15));
	sliderModelList.add(new SliderModel(R.drawable.d16));
	sliderModelList.add(new SliderModel(R.drawable.d17));


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
	   public boolean onTouch(View v,MotionEvent event){

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

