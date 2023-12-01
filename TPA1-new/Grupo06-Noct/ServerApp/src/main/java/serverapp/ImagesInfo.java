package serverapp;

import java.util.HashMap;
import java.util.Map;

import clientserverstubs.ImageBlock;

public class ImagesInfo {

  
    private int nImages = 0;

    // ImagesList dictionary with string as keys and ImageBlocks as values
    private Map<String, ImageBlock> ImagesList; 


    public ImagesInfo() {
        this.ImagesList = new HashMap<>();
    }

    public void addImageToList(ImageBlock img) {
        // Add to HashMap
        ImagesList.put(img.getImageId(), img);
    }

    public int getNumberOfImages() {
        return ImagesList.size();
    }

    public Map<String, ImageBlock> getListOfImages() {
        return ImagesList;
    }

    public ImageBlock getImage(String id) {
        return ImagesList.get(id);
    }

    public int addNImages(){ 
        return ++nImages; 
    
    }

    public void decrementNImages() {
        --nImages;
    }

    public int getNImages() {
        return nImages;
    }

  

}
    

