package com.vikram.redactorve;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.AppBarLayout;
import com.vikram.redactorve.listmusicandmymusic.ListMusicAndMyMusicActivity;
import com.vikram.redactorve.listvideoandmyvideo.ListVideoAndMyAlbumActivity;
import com.vikram.redactorve.listvideowithmymusic.ListVideoAndMyMusicActivity;
import com.vikram.redactorve.phototovideo.SelectImageAndMyVideoActivity;

import java.util.Objects;

public class StartActivity extends AppCompatActivity{
    static final boolean a = true;
    private Toolbar toolbar;
    CardView iv_reta;


    @SuppressLint("SetTextI18n")
    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
        }
        setContentView( R.layout.startactivity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText("Dashboard");
        AppBarLayout appbarLayout = (AppBarLayout) findViewById(R.id.mainappbar);
        ImageView mProfileImage = (ImageView) findViewById(R.id.mainbackdrop);
        iv_reta = findViewById(R.id.iv_reta);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onBackPressed();

            }
            public void rating() {


            }
        });
        iv_reta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.iv_reta:

                        rating(StartActivity.this);
                        break;
                }
            }
        });
/*
        appbarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appbarLayout.getTotalScrollRange();

 */
    }

    private void rating(StartActivity startActivity) {
        Intent i3 = new Intent(Intent.ACTION_VIEW, Uri
                .parse("market://details?id=" + startActivity.getPackageName()));
        startActivity.startActivity(i3);
    }

    @SuppressLint("WrongConstant")
    public void videocutter(View view) {
        Helper.ModuleId = 1;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videocompress(View view) {
        Helper.ModuleId = 2;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videotomp3(View view) {
        Helper.ModuleId = 3;
        Intent intent = new Intent(this, ListVideoAndMyMusicActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void audiovideomixer(View view) {
        Helper.ModuleId = 4;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videomute(View view) {
        Helper.ModuleId = 5;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videojoin(View view) {
        Helper.ModuleId = 6;
        Intent intent = new Intent(this, com.vikram.redactorve.videojoiner.ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videotoimg(View view) {
        Helper.ModuleId = 7;
        Intent intent = new Intent(this, com.vikram.redactorve.videotogif.ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videoformatchange(View view) {
        Helper.ModuleId = 8;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void fastmotion(View view) {
        Helper.ModuleId = 9;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void slowmotion(View view) {
        Helper.ModuleId = 10;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videocrop(View view) {
        Helper.ModuleId = 11;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videotogif(View view) {
        Helper.ModuleId = 12;
        Intent intent = new Intent(this, com.vikram.redactorve.videotogif.ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videorotate(View view) {
        Helper.ModuleId = 13;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videomirror(View view) {
        Helper.ModuleId = 14;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videosplit(View view) {
        Helper.ModuleId = 15;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videoreverse(View view) {
        Helper.ModuleId = 16;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }


    @SuppressLint("WrongConstant")
    public void audiocompress(View view) {
        Helper.ModuleId = 18;
        Intent intent = new Intent(this, ListMusicAndMyMusicActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void audiojoiner(View view) {
        Helper.ModuleId = 19;
        Intent intent = new Intent(this, ListMusicAndMyMusicActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void audiocutter(View view) {
        Helper.ModuleId = 20;
        Intent intent = new Intent(this, ListMusicAndMyMusicActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void phototovideo(View view) {
        Helper.ModuleId = 21;
        Intent intent = new Intent(this, SelectImageAndMyVideoActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @SuppressLint("WrongConstant")
    public void videowatermark(View view) {
        Helper.ModuleId = 22;
        Intent intent = new Intent(this, ListVideoAndMyAlbumActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return a;
    }

   @Override public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.shareapp) {
            StringBuilder sb = new StringBuilder();
            sb.append(Helper.share_string);
            sb.append(Helper.package_name);
            String sb2 = sb.toString();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", sb2);
            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.moreapp) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Helper.account_string)));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(getApplicationContext(), " unable to find market app", Toast.LENGTH_LONG).show();
            }
        } else if (menuItem.getItemId() == R.id.rateus) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Helper.package_name)));
            } catch (ActivityNotFoundException unused2) {
                Toast.makeText(getApplicationContext(), " unable to find market app", Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }


    /*
    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;
    private int mMaxScrollSize = 1;
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = 0;
        try {
            percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;

            toolbar.setTitle("");

        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;
            toolbar.setTitle("Video Editor");


        }
    }
*/


}
