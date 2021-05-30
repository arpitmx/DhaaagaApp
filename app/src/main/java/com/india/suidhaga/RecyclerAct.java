package com.india.suidhaga;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class RecyclerAct extends AppCompatActivity {
    private static final String TAG = VideoEntryActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List < String > adapterData;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        Integer[] image = {R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2,R.drawable.p5, R.drawable.p3, R.drawable.img1, R.drawable.p2};
        handler = new Handler();

        linearLayoutManager = new LinearLayoutManager(RecyclerAct.this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // return the data object

        adapterData = getFirstData();
        recyclerView.setLayoutManager(linearLayoutManager);

        //setted the adapter here...

        recyclerViewAdapter = new RecyclerViewAdapter(RecyclerAct.this, adapterData, recyclerView,image);
        recyclerView.setAdapter(recyclerViewAdapter);

        //Loading items on the recyler view....

        recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                adapterData.add(null);

                System.out.println(adapterData.size());

                recyclerViewAdapter.notifyItemInserted(adapterData.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapterData.remove(adapterData.size() - 1);
                        recyclerViewAdapter.notifyItemRemoved(adapterData.size());
                        {
                        for (int i = 0; i < 4; i++) {
                            adapterData.add("Item" + (adapterData.size() + 1));
                            recyclerViewAdapter.notifyItemInserted(adapterData.size());
                        }
                        recyclerViewAdapter.setLoaded();

                        }
                    }
                }, 500);
                System.out.println("loading more items.");
            }
        });
    }
    private List < String > getFirstData() {
        List < String > listObject = new ArrayList < String > ();
        listObject.add("Item1");
        return listObject;
    }
}