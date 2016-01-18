package picoledelimao.github.io.instadog.utils;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import java.io.File;

/**
 * Utility class for image manipulation
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class ImageUtils {

    public static final int REQUEST_CAMERA = 9000;
    public static final int REQUEST_GALLERY = 9001;

    /**
     * Get a circular area centered in the center of bitmap
     * @param bitmap Bitmap from which the circular area will be extracted
     * @return A circular area centered in the center of bitmap
     */
    public static Bitmap getCroppedBitmap(Bitmap bitmap) {
        // Credits to Altaf (http://stackoverflow.com/a/12089127)
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

}
