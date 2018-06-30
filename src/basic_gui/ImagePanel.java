package basic_gui;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

    public ImagePanel() {

		/*image = ImageIO.read(getClass().getResource(
				"../images/Iron_throne.png"));*/
		image = Toolkit.getDefaultToolkit().getImage(
				ImagePanel.class.getResource("/images/Iron_throne.png"));
		
	   
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
