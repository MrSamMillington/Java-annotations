package deprecated;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Seller s = new Seller();
        s.placeAdInNewspaper("Cheese for sale", 14); //warns its deprecated
        List<Image> imageList = new ArrayList<>();
        s.postInCraigsList("Cheese for sale",imageList ); //
    }
}
