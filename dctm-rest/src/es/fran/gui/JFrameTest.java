package es.fran.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class JFrameTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTest frame = new JFrameTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTree tree_1 = new JTree();
		tree_1.setBackground(Color.ORANGE);
		tree_1.setVisibleRowCount(100);
		tree_1.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree-in") {
				{
					
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("colors");
							node_1.add(new DefaultMutableTreeNode("blue"));
							node_1.add(new DefaultMutableTreeNode("violet"));
							node_1.add(new DefaultMutableTreeNode("red"));
							node_1.add(new DefaultMutableTreeNode("yellow"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("sports");
							node_1.add(new DefaultMutableTreeNode("basketball"));
							node_1.add(new DefaultMutableTreeNode("soccer"));
							node_1.add(new DefaultMutableTreeNode("football"));
							node_1.add(new DefaultMutableTreeNode("hockey"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("food");
							node_1.add(new DefaultMutableTreeNode("hot dogs"));
							node_1.add(new DefaultMutableTreeNode("pizza"));
							node_1.add(new DefaultMutableTreeNode("ravioli"));
							node_1.add(new DefaultMutableTreeNode("bananas"));
						add(node_1);
					
				}
			}
		));
		//tree_1.setBounds(217, 46, 70, 64);
		//contentPane.add(tree_1);
		
		JScrollPane scrollPane = new JScrollPane(tree_1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(97, 72, 100, 120);
		contentPane.add(scrollPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree-out") {

			}
		));
		tree.setBounds(695, 72, 70, 64);
		contentPane.add(tree);
		
		JTree tree_2 = new JTree();
		tree_2.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				
				
			}
		));
		tree_2.setBounds(125, 316, 70, 64);
		contentPane.add(tree_2);
		

		
		contentPane.revalidate();
		contentPane.repaint();
	
	}
}

	