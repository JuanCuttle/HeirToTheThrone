package basic_gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Dynasties;
import model.Main;

public class DynastySelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6345581665543710575L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynastySelector frame = new DynastySelector();
					frame.setVisible(true);
					
					Main.interfaceMode = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DynastySelector() {

			/*this.setIconImage(ImageIO.read(getClass().getResource(
					"../images/Aegons_crown.png")));*/
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				DynastySelector.class.getResource("/images/Aegons_crown.png")));

		
		setTitle("Select a dynasty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ImagePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Targaryen");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new LineageSelector(Dynasties.TARGARYEN);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JCheckBox chckbxFullLineage = new JCheckBox("Full lineage");
		chckbxFullLineage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Main.fullLineage){
					Main.fullLineage = false;
				} else {
					Main.fullLineage = true;
				}
			}
		});
		GridBagConstraints gbc_chckbxFullLineage = new GridBagConstraints();
		gbc_chckbxFullLineage.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFullLineage.gridx = 5;
		gbc_chckbxFullLineage.gridy = 0;
		contentPane.add(chckbxFullLineage, gbc_chckbxFullLineage);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnWindsor = new JButton("Windsor");
		btnWindsor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new LineageSelector(Dynasties.WINDSOR);
			}
		});
		GridBagConstraints gbc_btnWindsor = new GridBagConstraints();
		gbc_btnWindsor.gridx = 7;
		gbc_btnWindsor.gridy = 3;
		contentPane.add(btnWindsor, gbc_btnWindsor);

	}

}
