package ru.yarobot.android.utils;

import android.content.Context;

import ru.yarobot.android.R;
import ru.yarobot.entities.model.Status;

/**
 * Created by Nixy on 12.06.2016.
 */
public class ColorConstans {



    public static int getStatusColor(Context context, Status status){
        if(status.equals(Status.OK)){
            return context.getResources().getColor(R.color.status_ok);
        } else {
            return context.getResources().getColor(R.color.status_fail);
        }
    }
}
