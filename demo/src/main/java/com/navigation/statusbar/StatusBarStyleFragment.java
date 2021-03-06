package com.navigation.statusbar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.navigation.androidx.BarStyle;
import com.navigation.androidx.Style;
import com.navigation.androidx.ToolbarButtonItem;


/**
 * Created by listen on 2018/1/13.
 */

public class StatusBarStyleFragment extends TestStatusBarFragment {

    private BarStyle barStyle = BarStyle.DarkContent;

    @NonNull
    @Override
    protected BarStyle preferredStatusBarStyle() {
        return barStyle;
    }

    @Override
    protected void onCustomStyle(@NonNull Style style) {
        super.onCustomStyle(style);
        style.setStatusBarStyle(BarStyle.DarkContent);
        style.setStatusBarColor(Color.WHITE);
        style.setToolbarBackgroundColor(Color.WHITE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ToolbarButtonItem.Builder builder = new ToolbarButtonItem.Builder();
        builder.title("切换").tintColor(Color.RED).listener(view -> {
            if (preferredStatusBarStyle() == BarStyle.DarkContent) {
                barStyle = BarStyle.LightContent;
            } else {
                barStyle = BarStyle.DarkContent;
            }
            setNeedsStatusBarAppearanceUpdate();
        });
        setRightBarButtonItem(builder.build());
    }

}
