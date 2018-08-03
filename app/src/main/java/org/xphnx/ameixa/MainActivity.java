package org.xphnx.ameixa;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        createLayout();
    }

    private void createLayout() {

        // main centered layout

        LinearLayout.LayoutParams smallLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        float scale = IceScreenUtils.densityScale(getApplicationContext());
        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(Math.round(48 * scale), Math.round(48 * scale));

        LinearLayout frameLayout = new LinearLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        frameLayout.setBackgroundColor(0xffffffff);
        frameLayout.setGravity(Gravity.CENTER);
        setContentView(frameLayout);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        baseLayout.setGravity(Gravity.START);
        frameLayout.addView(baseLayout);

        // source code button

        LinearLayout sourceLayout = new LinearLayout(this);
        sourceLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceLayout.setLayoutParams(smallLayoutParams);
        sourceLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(sourceLayout);

        LinearLayout sourceClickLayout = new LinearLayout(this);
        sourceClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        sourceClickLayout.setGravity(Gravity.CENTER);
        sourceLayout.addView(sourceClickLayout);
        sourceClickLayout.setOnClickListener((View v) -> gitLink(v));

        Button sourceButton = new Button(this);
        sourceButton.setLayoutParams(buttonParams);
        sourceButton.setBackground(new BitmapDrawable(getResources(), IceImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_source_button, Math.round(48 * scale), Math.round(48 * scale))));
        sourceButton.setClickable(false);
        sourceClickLayout.addView(sourceButton);

        TextView sourceText = new TextView(this);
        sourceText.setText(R.string.sourcecodetext);
        sourceText.setTextSize(24);
        sourceText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        sourceText.setPadding(64, 64, 64, 64);
        sourceClickLayout.addView(sourceText);

        // license button

        LinearLayout aboutLayout = new LinearLayout(this);
        aboutLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutLayout.setLayoutParams(smallLayoutParams);
        aboutLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(aboutLayout);

        LinearLayout aboutClickLayout = new LinearLayout(this);
        aboutClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        aboutClickLayout.setGravity(Gravity.CENTER);
        aboutLayout.addView(aboutClickLayout);
        aboutClickLayout.setOnClickListener((View v) -> licenseShow(v));

        Button aboutButton = new Button(this);
        aboutButton.setLayoutParams(buttonParams);
        aboutButton.setBackground(new BitmapDrawable(getResources(), IceImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_license_button, Math.round(48 * scale), Math.round(48 * scale))));
        aboutButton.setClickable(false);
        aboutClickLayout.addView(aboutButton);

        TextView aboutText = new TextView(this);
        aboutText.setText(R.string.licensetext);
        aboutText.setTextSize(24);
        aboutText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        aboutText.setPadding(64, 64, 64, 64);
        aboutClickLayout.addView(aboutText);
    }

    public void gitLink(View v) {

        Uri uri = Uri.parse(getString(R.string.sourcecodelink));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void licenseShow(View v) {
        Intent intent = new Intent(this, LicenseActivity.class);
        startActivity(intent);
    }
}
