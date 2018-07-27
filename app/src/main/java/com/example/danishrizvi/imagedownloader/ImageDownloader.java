package com.example.danishrizvi.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private ProgressBar progressBar;

    public ImageDownloader(ImageView imageView, ProgressBar progressBar/*, ImageDownloader imageDownloader*/) {
        this.imageView = imageView;
        this.progressBar = progressBar;
        //ImageDownloader imageDownloader1 = imageDownloader;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            System.out.println("Content Type = " + connection.getContentType());
            if (connection.getContentType().contains("image")) {
                InputStream inputStream = connection.getInputStream();
                return BitmapFactory.decodeStream(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            imageView.setImageBitmap(bitmap);
            progressBar.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
