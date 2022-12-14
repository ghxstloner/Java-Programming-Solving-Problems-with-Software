import edu.duke.*;
import java.io.*;
/**
 * Write a description of class BatchInversions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchInversions{
    public static ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getGreen());
            pixel.setBlue(255 - inPixel.getGreen());
        }
        return outImage;
    }
    public static void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource invertedImage = makeInversion(ir);
            String fname = ir.getFileName();
            String newName = "inverted-"+fname;
            invertedImage.setFileName(newName);
            invertedImage.draw();
            invertedImage.save();
        }
    }
    public static void maing(String[] args){
        selectAndConvert();
    }
}
