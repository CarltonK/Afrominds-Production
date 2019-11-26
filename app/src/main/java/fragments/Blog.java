package fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.afrominds.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Blog extends Fragment {
    private WebView blog;


    public Blog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        blog = view.findViewById(R.id.web_blog);

        WebSettings webSettings = blog.getSettings();
        webSettings.setJavaScriptEnabled(true);

        blog.loadUrl("https://www.skysports.com/football/news");


        return view;
    }

}
