package com.india.suidhaga;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class ProductsFirebase extends AppCompatActivity {
    private final String TAG = "ProductsFirebase";
    DatabaseReference reff;
    LinearLayout layout;
    TextView textView;
    TextView subtitlev;
    TextView cmpnyname;
    ImageView imagev ;
    Button fetcher;
    TextView price;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteref = db.collection("NewProductCollection").document("New_Product_Details");
    private final String PRODUCT_TYPE = "Product Type";
    private final String TITLE = "Product Title";
    private final String DETAILS = "Product Details";
    private final String PRICE = "PRICE";
    private final String COMPANY = "Company";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReferenceFromUrl("gs://dhagaa-e8ab3.appspot.com").child("images").child("images.jpg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_firebase);

        fetcher = findViewById(R.id.fetch);
        cmpnyname = findViewById(R.id.companyname);
        imagev = (ImageView) findViewById(R.id.image);
        subtitlev = findViewById(R.id.subtitle);
        textView = findViewById(R.id.title);
        price = findViewById(R.id.price);
        layout = findViewById(R.id.LayoutTouch);
        fetcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadnote(v);
            }
        });

    }

    public void loadnote(View v){

noteref.get()
        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){

                String title = documentSnapshot.getString(TITLE);
                String details = documentSnapshot.getString(DETAILS);
                String ptype = documentSnapshot.getString(COMPANY);
                String pprice = documentSnapshot.getString(PRICE);
                 textView.setText(title);
                 subtitlev.setText(details);
                 cmpnyname.setText(ptype);
                 price.setText(pprice);

                    try {
                        File file = File.createTempFile("image","jpg");
                        storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                                imagev.setImageBitmap(bitmap);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ProductsFirebase.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }else{
                    Toast.makeText(ProductsFirebase.this, "No Collection Exists", Toast.LENGTH_SHORT).show();
                    Crashlytics.log("No Collection seen");
                }
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ProductsFirebase.this, "Failed to fetch from firestore", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Failed to fetch");


            }
        });


    }



}