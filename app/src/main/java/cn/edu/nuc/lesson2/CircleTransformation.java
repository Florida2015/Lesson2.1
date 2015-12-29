package cn.edu.nuc.lesson2;

import android.graphics.*;
import com.squareup.picasso.Transformation;

/**
 * Created by Flming2015 on 2015/12/29.
 */
public class CircleTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap result = Bitmap.createBitmap(source.getWidth(),source.getHeight(), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP));
        new Canvas(result).drawCircle(source.getWidth() / 2,source.getHeight(),Math.min(source.getWidth(),source.getHeight()),paint);
        source.recycle();
        return result;
    }

    @Override
    public String key() {
        return "circle";
    }
}
