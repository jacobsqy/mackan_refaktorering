package View;

import Model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //** Map that connects an image to its corresponding car */
    Map<Vehicle, BufferedImage> imageMap = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Remember to right click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            for (Vehicle c : cars) {
                if (c.getClass().getName().equals("Model.Volvo240")) {
                    imageMap.put(c, ImageIO.read(new File("src\\pics\\Model.Volvo240.jpg")));
                }
                else if (c.getClass().getName().equals("Model.Saab95")) {
                    imageMap.put(c, ImageIO.read(new File("src\\pics\\Model.Saab95.jpg")));
                }
                else if (c.getClass().getName().equals("Model.Scania")){
                    imageMap.put(c, ImageIO.read(new File("src\\pics\\Model.Scania.jpg")));
                }
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle key : imageMap.keySet()){
            g.drawImage(imageMap.get(key), (int)key.getPosition().x, (int)key.getPosition().y, null);// see javadoc for more info on the parameters
        }
    }
}