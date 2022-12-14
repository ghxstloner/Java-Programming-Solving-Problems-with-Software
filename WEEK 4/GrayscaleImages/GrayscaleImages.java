import edu.duke.*;
import java.io.*;

/**
 * Write a description of class GrayscaleImages here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GrayscaleImages{
    public static ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    public static void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }
    public static void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            String fname = ir.getFileName();
            String newName = "copy-" + fname;
            ir.setFileName(newName);
            ir.draw();
            ir.save(); 
        }
    }
}