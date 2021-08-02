package com.vikram.redactorve;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Mainactivity extends AppCompatActivity implements View.OnClickListener {

    ExtendedFloatingActionButton start;
    FloatingActionButton iv_share;
    FloatingActionButton iv_reta;
    FloatingActionButton iv_privecy;
    Dialog closeAppDialog;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT<16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        };
        setContentView(R.layout.activity_startactivity);
        refreshAd();
        initCloseAppDialog();
        iv_share = findViewById(R.id.iv_share);
        iv_share.setOnClickListener(this);
        iv_reta = findViewById(R.id.iv_reta);
        iv_reta.setOnClickListener(this);
        iv_privecy = findViewById(R.id.iv_privecy);
        iv_privecy.setOnClickListener(this);
        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(Mainactivity.this, StartActivity.class));
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override public void onClick(View v) {


        switch (v.getId()) {

            case R.id.iv_share:

                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Redactor VE");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" +"com.vikram.redactorve" + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                }
                break;

            case R.id.iv_reta:

                ratingDialog(Mainactivity.this);
                break;

            case R.id.iv_privecy:

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://bit.ly/3fQyMc1"));
                startActivity(i);
                break;


        }
    }

    public static void ratingDialog(Activity activity) {

        Intent i3 = new Intent(Intent.ACTION_VIEW, Uri
                .parse("market://details?id=" + activity.getPackageName()));
        activity.startActivity(i3);
    }

    @Override public void onBackPressed() {
        closeAppDialog.show();
    }


    public void initCloseAppDialog() {
        closeAppDialog = new Dialog(this);
        closeAppDialog.requestWindowFeature(1);
        closeAppDialog.setContentView(R.layout.dialog_go_back);
        refreshAd(closeAppDialog);
        ((TextView) closeAppDialog.findViewById(R.id.tv_dialog_text)).setText(getString(R.string.sure_close_app));
        Button button = (Button) closeAppDialog.findViewById(R.id.bt_cancel);
        button.setText(getString(R.string.cancel));
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                lambda$initCloseAppDialog$0$MainActivity(view);
            }
        });
        Button button2 = (Button) closeAppDialog.findViewById(R.id.bt_yes);
        button2.setText(getString(R.string.close));
        button2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                lambda$initCloseAppDialog$1$MainActivity(view);
            }
        });

    }

    public  void lambda$initCloseAppDialog$0$MainActivity(View view) {
        closeAppDialog.dismiss();
    }

    public  void lambda$initCloseAppDialog$1$MainActivity(View view) {
        closeAppDialog.dismiss();
        finish();
    }


    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {


        MediaView mediaView = adView.findViewById(R.id.ad_media);
        adView.setMediaView(mediaView);


        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));


        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());



        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }




        adView.setNativeAd(nativeAd);



        VideoController vc = nativeAd.getVideoController();


    }


    private UnifiedNativeAd nativeAd;


    private void refreshAd() {

        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.nativead));

        builder.forUnifiedNativeAd(unifiedNativeAd -> {


            if (nativeAd != null) {
                nativeAd.destroy();
            }
            nativeAd = unifiedNativeAd;
            FrameLayout frameLayout =
                    findViewById(R.id.fl_adplaceholder);
            UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
                    .inflate(R.layout.adunity, null);
            populateUnifiedNativeAdView(unifiedNativeAd, adView);
            frameLayout.removeAllViews();
            frameLayout.addView(adView);
        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(false)
                .build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("TAG", "onAdFailedToLoad:");
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }




    private void refreshAd(final Dialog dialog) {

        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.nativead));

        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {

            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {


                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = unifiedNativeAd;
                FrameLayout frameLayout =
                        dialog.findViewById(R.id.fl_adplaceholder);
                @SuppressLint("InflateParams") UnifiedNativeAdView adView = (UnifiedNativeAdView) getLayoutInflater()
                        .inflate(R.layout.adunity, null);
                populateUnifiedNativeAdView(unifiedNativeAd, adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);
            }

        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(false)
                .build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);

        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("TAG", "onAdFailedToLoad:");
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    public void godevloperDetails(View view) {
        startActivity(new Intent(getApplicationContext(), DeveloperDetails.class));
    }
}
