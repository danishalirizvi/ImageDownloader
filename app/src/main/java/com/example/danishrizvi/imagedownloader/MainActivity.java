package com.example.danishrizvi.imagedownloader;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayoutScrollView;
    ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutScrollView = (LinearLayout) findViewById(R.id.linearLayoutScrollView);
        addUrls();
    }

    public void downloadImages(View view) {
        ImageUI imageUI = new ImageUI(MainActivity.this, urls, linearLayoutScrollView);
        imageUI.downloadImages();
    }

    public void reset(View view) {
        linearLayoutScrollView.removeAllViews();
    }


    public void addUrls() {

        urls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXEZRoYOhIJxL5foNz_NlatDlgYStzZgVIiKuo6vtRtz2wY-8b4Q");
        urls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFL3WYbqNOX-dwjtT1LroBlY5W-3YuwSIuCMRaLpnjMXbVPEJy");
        urls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiwgrJeAJN-7lcy92N51uP7XzccK_p-fTSJNCXPLPSVih8wqPf");
        urls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT19dYLCEZlMRqojedJB-05jTrflD74nasvkXs-SdVeyM2BEpCSFA");
        urls.add("http://wallpaperswide.com/download/high_tech_earth-wallpaper-2880x1800.jpg");
        urls.add("https://www.gettyimages.ca/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg");
        urls.add("https://images.unsplash.com/photo-1418489098061-ce87b5dc3aee?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=2f033882f3c25404e3f904fbfe2351be&w=1000&q=80");
        urls.add("https://techcrunch.com/wp-content/uploads/2018/03/gettyimages-705351545.jpg?w=730&crop=1");

    }
}


