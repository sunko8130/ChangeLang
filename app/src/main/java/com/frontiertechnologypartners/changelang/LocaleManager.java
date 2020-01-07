package com.frontiertechnologypartners.changelang;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import java.util.Locale;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

public class LocaleManager {

    private static final String LANGUAGE_ENGLISH = "en";
    private static final String LANGUAGE_MYANMAR = "my";
    private static final String LANGUAGE_KEY = "lang";
    private PreferenceUtils prefs;

    LocaleManager(Context context) {
        prefs = new PreferenceUtils(context);
    }

    Context setLocale(Context c) {
        return updateResources(c, getLanguage());
    }

    private String getLanguage() {
        return prefs.fromPreference(LANGUAGE_KEY, LANGUAGE_MYANMAR);
    }

    void persistLanguage(String language) {
        prefs.toPreference(LANGUAGE_KEY, language);
    }

    private Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Utility.isAtLeastVersion(JELLY_BEAN_MR1)) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }
}