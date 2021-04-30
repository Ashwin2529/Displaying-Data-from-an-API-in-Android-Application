package com.example.myknot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

public class swipedialogbox  {


    SwipeDismissDialog swipeDismissDialog;

    private Context context;
    private TextView textView;
    private ImageView img;
    private Button success;

    //Constructor to recieve context of Mainactivity
    public swipedialogbox(Context context){
        this.context=context;

    }
    public void method(String title, String imgurl, String succes) {

        //To show dialogbox
        View dialo= LayoutInflater.from(context).inflate(R.layout.dialogbox,null);
        swipeDismissDialog= new SwipeDismissDialog.Builder(context).setView(dialo).build().show();

        textView=dialo.findViewById(R.id.textv);
        img=dialo.findViewById(R.id.imagev);
        success=dialo.findViewById(R.id.success);

        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_VIEW);
                intent.setData(Uri.parse(succes));
                context.startActivity(intent);
            }
        });
        textView.setText(title);

        Glide.with( context).load(imgurl).into(img);

    }
}
