package basic_gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Dynasties;
import model.Main;
import model.Royal;

public class LineageSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6345581665543710575L;
	private JPanel contentPane;
	private static ArrayList<Royal> options;

	/**
	 * Create the frame.
	 */
	public LineageSelector(Dynasties dynasty) {
		

			/*this.setIconImage(ImageIO.read(getClass().getResource(
					"../images/Aegons_crown.png")));*/
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(
					LineageSelector.class.getResource("/images/Aegons_crown.png")));

		
		this.setVisible(true);
		
		try {
			switch(dynasty){
				case TARGARYEN: options = Main.targaryens();
							break;
				default: options = Main.currentRoyalFamily();
					break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		setTitle("Select a royal to show lineage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 450, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox<Royal> comboBox = new JComboBox<>();
		for (Royal t : options){
			if (!t.isInvalid()) {
				comboBox.addItem(t);
			}
		}
		
		contentPane.add(comboBox, BorderLayout.CENTER);
		
		JButton btnShow = new JButton("Show");
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Royal t : options){
					t.setVisited(false);
				}
				try {
					switch(dynasty){
					case TARGARYEN: Main.getRecursiveLoDDMP((Royal)comboBox.getSelectedItem());;
								break;
					default: Main.getRecursiveLoDDP((Royal)comboBox.getSelectedItem());;
						break;
				}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnShow, BorderLayout.WEST);
	}
}
