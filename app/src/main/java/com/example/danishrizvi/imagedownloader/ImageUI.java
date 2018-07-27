package com.example.danishrizvi.imagedownloader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;

class ImageUI {

    private Context context;
    private ArrayList<String> urls = new ArrayList<>();

    private ImageView imageView;
    private ProgressBar progressBar;
    private LinearLayout linearLayoutScrollView;

    public ImageUI(Context context, ArrayList<String> urls, LinearLayout linearLayoutScrollView) {
        this.context = context;
        this.urls = urls;
        this.linearLayoutScrollView = linearLayoutScrollView;
    }

    private void buildUI() {
        System.out.println("Error # 1");
        imageView = new ImageView(context);
        imageView.setVisibility(View.GONE);

        System.out.println("Error # 2");
        progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.GONE);

        System.out.println("Error # 3");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(1);
        relativeLayout.addView(imageView);
        relativeLayout.addView(progressBar);
//
//        System.out.println("Error # 4");
//        linearLayoutScrollView = (LinearLayout) linearLayoutScrollView.findViewById(R.id.linearLayoutScrollView);
        linearLayoutScrollView.addView(relativeLayout);
//        System.out.println("Error # 5");

    }

    void downloadImages() {
        int i = 0;
        while (i < urls.size()) {

            buildUI();

            ImageDownloader imageDownloader = new ImageDownloader(imageView, progressBar/*,imageDownloader*/);

            progressBar.setVisibility(View.VISIBLE);

            imageDownloader.execute(urls.get(i));


            imageDownloader = null;

            i++;
        }
    }

}
