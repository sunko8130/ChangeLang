package com.frontiertechnologypartners.changelang;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import static android.content.pm.PackageManager.GET_META_DATA;

public class Utility {

    public static void resetActivityTitle(Activity a) {
        try {
            ActivityInfo info = a.getPackageManager().getActivityInfo(a.getComponentName(), GET_META_DATA);
            if (info.labelRes != 0) {
                a.setTitle(info.labelRes);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAtLeastVersion(int version) {
        return Build.VERSION.SDK_INT >= version;
    }
}