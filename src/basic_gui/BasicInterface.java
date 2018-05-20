package basic_gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class BasicInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImagePanel contentPane;
	private JTextPane txtpn1;
	private JTextPane txtpn2;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public BasicInterface() throws IOException {

		this.setIconImage(ImageIO.read(getClass().getResource(
   				"../images/Aegons_crown.png")));
		
		//setTitle("Royal Lineage");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);

		setSize(1000, 500);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new ImagePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	public void showLineage(String formattedLineage, String aux, String title) {
		this.setTitle(title);
		
		txtpn1 = new JTextPane();
		// txtpn.setForeground(new Color(178, 34, 34));
		txtpn1.setForeground(Color.BLACK);
		txtpn1.setEditable(false);
		// txtpnYouAreIn.setBackground(new Color(222, 184, 135));
		txtpn1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		txtpn1.setText(formattedLineage);
		contentPane.add(txtpn1, BorderLayout.CENTER);

		txtpn1.setOpaque(false);

		if (aux.length() > 0) {
			
			txtpn2 = new JTextPane();
			txtpn2.setForeground(new Color(255, 255, 255));
			//txtpn2.setForeground(Color.BLACK);
			txtpn2.setEditable(false);
			// txtpnYouAreIn.setBackground(new Color(222, 184, 135));
			txtpn2.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
			txtpn2.setText(aux);
			contentPane.add(txtpn2, BorderLayout.EAST);

			txtpn2.setOpaque(false);
		}
	}

}
