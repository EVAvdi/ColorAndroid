package ru.netology.colorandroid;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_BlACK = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;


    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_BlACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;
        }
    }
}
