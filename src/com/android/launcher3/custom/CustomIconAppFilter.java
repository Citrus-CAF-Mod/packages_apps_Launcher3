package com.android.launcher3.custom;

import android.content.ComponentName;
import android.content.Context;

import com.android.launcher3.Utilities;

public class CustomIconAppFilter extends CustomAppFilter {
    private final Context mContext;
    private final boolean hasIconPack;

    public CustomIconAppFilter(Context context) {
        super(context);
        mContext = context;
        hasIconPack = !Utilities.getPrefs(context).getString(CustomSettingsActivity.ICON_PACK_PREF, "").isEmpty();
    }

    @Override
    public boolean shouldShowApp(ComponentName componentName) {
        return super.shouldShowApp(componentName) &&
                (!hasIconPack || !CustomIconUtils.isPackProvider(mContext, componentName.getPackageName()));
    }
}
