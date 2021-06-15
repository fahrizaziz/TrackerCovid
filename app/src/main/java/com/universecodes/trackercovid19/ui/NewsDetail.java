package com.universecodes.trackercovid19.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.model.news.NewsModel;

public class NewsDetail extends AppCompatActivity {
    public static final String PARCELABLE_PARSING_DATA = "parcelable_parsing_data" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        TextView tvTitle = findViewById(R.id.tvNewsTitleDetail);
        TextView tvSource = findViewById(R.id.tvNewsSourceDetail);
        TextView tvAuthor = findViewById(R.id.tvNewsAuthorDetail);
        TextView tvPublished = findViewById(R.id.tvNewsPublishedDetail);
        TextView tvDesc = findViewById(R.id.tvNewsDescDetail);
        TextView tvContent = findViewById(R.id.tvNewsContentDetail);

        ImageView imageView = findViewById(R.id.imageDetailNews);

        Button btnMore = findViewById(R.id.btnMore);

        NewsModel model = getIntent().getParcelableExtra(PARCELABLE_PARSING_DATA);

    }
}