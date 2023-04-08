package src;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class MultiGradientPaint implements Paint {
    private GradientPaint[] gradients;

    public MultiGradientPaint(Color[] colors, Point2D[] points) {
        if (colors.length != points.length) {
            throw new IllegalArgumentException("Colors and points arrays must be the same length");
        }
        gradients = new GradientPaint[colors.length - 1];
        for (int i = 0; i < gradients.length; i++) {
            gradients[i] = new GradientPaint(
                    (float) points[i].getX(), (float) points[i].getY(), colors[i],
                    (float) points[i + 1].getX(), (float) points[i + 1].getY(), colors[i + 1]);
        }
    }

    @Override
    public PaintContext createContext(ColorModel colorModel, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints) {
        PaintContext[] contexts = new PaintContext[gradients.length];
        for (int i = 0; i < contexts.length; i++) {
            contexts[i] = gradients[i].createContext(colorModel, deviceBounds, userBounds, xform, hints);
        }
        return new MultiPaintContext(contexts);
    }

    @Override
    public int getTransparency() {
        return TRANSLUCENT;
    }



    private static class MultiPaintContext implements PaintContext {
        private PaintContext[] contexts;

        private MultiPaintContext(PaintContext[] contexts) {
            this.contexts = contexts;
        }

        @Override
        public void dispose() {
            for (PaintContext context : contexts) {
                context.dispose();
            }
        }

        @Override
        public ColorModel getColorModel() {
            return contexts[0].getColorModel();
        }

        @Override
        public Raster getRaster(int x, int y, int w, int h) {
            WritableRaster[] rasters = new WritableRaster[contexts.length];
            for (int i = 0; i < rasters.length; i++) {
                rasters[i] = (WritableRaster) contexts[i].getRaster(x, y, w, h);
            }
            for (int i = rasters.length - 2; i >= 0; i--) {
                for (int j = 0; j < rasters[i].getWidth(); j++) {
                    for (int k = 0; k < rasters[i].getHeight(); k++) {
                        int[] color = rasters[i].getPixel(j, k, (int[]) null);
                        float alpha = color[3] / 255f;
                        int[] nextColor = rasters[i + 1].getPixel(j, k, (int[]) null);
                        nextColor[0] = (int) (nextColor[0] * alpha + color[0] * (1 - alpha));
                        nextColor[1] = (int) (nextColor[1] * alpha + color[1] * (1 - alpha));
                        nextColor[2] = (int) (nextColor[2] * alpha + color[2] * (1 - alpha));
                        nextColor[3] = Math.max(nextColor[3], color[3]);
                        rasters[i + 1].setPixel(j, k, nextColor);
                    }
                }
            }
            return rasters[rasters.length - 1];
        }
    }
}
