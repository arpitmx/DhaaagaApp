package com.india.suidhaga;

import java.util.List;

public class HomePageModel {

    public static final int BANNER_SLIDER = 0;


    private  int type;

    //////////////Banner Slider

    private List<SliderModel> sliderModelList;


    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;


    }

    //////////////Banner Slider


}
