package ru.netology.colorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner lang;
    Spinner color;
    Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView (){
        lang = findViewById(R.id.language);
        color = findViewById(R.id.color);
        btn_ok = findViewById(R.id.ok);
        initSpinnerLang();
        initSpinnerColor();
    }

    private void initSpinnerLang (){
        ArrayAdapter <CharSequence> adepterLang = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adepterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lang.setAdapter(adepterLang);
        lang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String[] stringLangs = getResources().getStringArray(R.array.languages);
                click(stringLangs[i]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void click (String language){
        switch (language) {
            case "Английский":
                btn_ok.setOnClickListener(clickEng);
                break;
            case "Russian":
                btn_ok.setOnClickListener(clickRu);
                break;
        }
    }
        private void initSpinnerColor () {
            ArrayAdapter<CharSequence> adepterColor = ArrayAdapter.createFromResource(this,
                    R.array.colors, android.R.layout.simple_spinner_item);
            adepterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            color.setAdapter(adepterColor);
            color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    String[] stringColor = getResources().getStringArray(R.array.colors);
                   clickColor(stringColor[i]);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
        private void clickColor(String ourColor){
        switch (ourColor){
            case "Зеленый":
            case "Green" :
               btn_ok.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Utils.changeToTheme(MainActivity.this,Utils.THEME_GREEN);
                   }
               });
                break;
            case "Черный":
            case "Black" :
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.changeToTheme(MainActivity.this,Utils.THEME_BlACK);
                    }
                });
                break;
            case "Синий":
            case "Blue" :
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.changeToTheme(MainActivity.this,Utils.THEME_BLUE);
                    }
                });
                break;
        }
        }

            private View.OnClickListener clickEng = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            };
            private View.OnClickListener clickRu = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            };
}

