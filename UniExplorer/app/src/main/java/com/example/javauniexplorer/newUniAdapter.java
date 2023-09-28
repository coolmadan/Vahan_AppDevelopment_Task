//package com.example.javauniexplorer;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebView;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import org.jetbrains.annotations.NotNull;
//import org.w3c.dom.Text;
//
//import java.util.List;
//
//public class newUniAdapter extends RecyclerView.Adapter<newUniAdapter.userHolder> {
//    MainActivity mainActivity;
//    List<UniModel> allUniList;
//    public newUniAdapter(MainActivity mainActivity, List<UniModel> allUniList) {
//        this.mainActivity=mainActivity;
//        this.allUniList=allUniList;
//    }
//
//    @NonNull
//
//    @Override
//    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.university_row,parent,false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull userHolder holder, int position) {
//        holder.name.setText(allUniList.get(position).getName());
//        holder.country.setText(allUniList.get(position).getCountry());
//        List<String>webPages=allUniList.get(position).getWeb_pages();
//        if (webPages != null && !webPages.isEmpty()) {
//            // Assuming you want to display the first web page if available
//            holder.web_pages.setText(webPages.get(0));
//            String webPagesText = new String();
//            webPagesText=webPages.get(0).toString();
//
//            String finalWebPagesText = webPagesText;
//            holder.web_pages.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (!webPages.isEmpty()) {
//                        String url = webPages.get(0);
//                        openUrlInBrowser(url);
//                    }
//                }
//
//                private void openUrlInBrowser(String url) {
//                    //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    if (url != null) {
//                        holder.webView_id.loadUrl(url);
//                    } else {
//                        Toast.makeText(mainActivity, "No app to open the website.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
////            StringBuilder webPagesText = new StringBuilder();
////            for(String link : webPages){
////                webPagesText.append(link).append("\n");
////            }
//            //holder.web_pages.setText(webPagesText.toString());
//        } else {
//            // Handle the case when webPages is null or empty, for example, display a default text
//            holder.web_pages.setText("No website available");
//        }
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return allUniList.size();
//    }
//
//    class userHolder extends RecyclerView.ViewHolder{
//        TextView name;
//        TextView country;
//        public TextView web_pages;
//        public WebView webView_id;
//        public userHolder(@NonNull @NotNull View itemView){
//            super(itemView);
//            name=itemView.findViewById(R.id.university_name);
//            country=itemView.findViewById(R.id.country_name);
//            web_pages=(TextView) itemView.findViewById(R.id.website_link);
//            webView_id=itemView.findViewById(R.id.webView_id);
//        }
//    }
//}
package com.example.javauniexplorer;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class newUniAdapter extends RecyclerView.Adapter<newUniAdapter.userHolder> {
    MainActivity mainActivity;
    List<UniModel> allUniList;


    public newUniAdapter(MainActivity mainActivity, List<UniModel> allUniList) {
        this.mainActivity = mainActivity;
        this.allUniList = allUniList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.university_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.name.setText(allUniList.get(position).getName());
        holder.country.setText(allUniList.get(position).getCountry());
        List<String> webPages = allUniList.get(position).getWeb_pages();

        if (webPages != null && !webPages.isEmpty()) {
            String url = webPages.get(0);
            holder.web_pages.setText(url);

            holder.web_pages.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent intent= new Intent(mainActivity,MainActivity2.class);
                        intent.putExtra("url", url);
                        mainActivity.startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(mainActivity, "Error", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        } else {
            holder.web_pages.setText("No website available");
            // Disable the TextView when there's no URL to open
            holder.web_pages.setEnabled(false);
        }
    }


    @Override
    public int getItemCount() {
        return allUniList.size();
    }

    class userHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView country;
        TextView web_pages;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.university_name);
            country = itemView.findViewById(R.id.country_name);
            web_pages = itemView.findViewById(R.id.website_link);
        }
    }
}
