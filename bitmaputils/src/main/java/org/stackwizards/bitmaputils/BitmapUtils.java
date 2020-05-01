package org.stackwizards.bitmaputils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtils {

    private static Resources Resources;
    private static BitmapUtils Instance;

    public static BitmapUtils setResources(Resources resources){
        Resources = resources;
        return Instance;
    }

    public static Bitmap GetBitmapFromResourceID(int resourceId){
        checkResourcesNotNull();
        return scaleImage(BitmapFactory.decodeResource(Resources, resourceId),120,120);
    }

    public static Bitmap GetBitmapFromResourceID(int resourceId, int w, int h){
        checkResourcesNotNull();
        return scaleImage(BitmapFactory.decodeResource(Resources, resourceId),w,h);
    }

    public static Bitmap scaleImage(Bitmap bitmap, int width, int height){
        checkResourcesNotNull();
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public static Bitmap Crop(Bitmap bmp, int x, int y, int width, int height){
        checkResourcesNotNull();
        return Bitmap.createBitmap(bmp, x,y,width, height);
    }

    private static void checkResourcesNotNull(){
        if(Resources == null){
            throw new NullPointerException("BitmapUtils: Resources were not set");
        }
    }
}
