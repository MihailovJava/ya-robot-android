package ru.yarobot.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.yarobot.android.R;
import ru.yarobot.android.fragments.CampaignsListFragment;

/**
 * Created by Nixy on 05.06.2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, CampaignsListFragment.newInstance())
                .commit();
    }
}
