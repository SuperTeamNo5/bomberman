package com.game.bomberman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ImageDAO;

public class TwoPlayersPanel extends JPanel {
		private JPanel pnlOnePlayer, pnlBtn, pnlCenter;
		private JLabel lblName, lblBtnBack, lblBtnGo, lblTitle, lblAvatar, lblHello, lblAvatargif;
		private BufferedImage imgIconBack, imgIconGo, imgAvatar;
		private ImageIcon imgAvatargif;
		private JTextField txtName;
		private Image newLoaderImage;

		public TwoPlayersPanel() {
			// add(pnlView());
		}

		public JPanel pnlView() {
			pnlOnePlayer = new JPanel(new BorderLayout());
			lblTitle = new JLabel("Kho Kho", SwingConstants.CENTER);
			lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblTitle.setForeground(Color.decode("#a71111"));

			pnlCenter = new JPanel();
			pnlCenter.setBackground(new Color(117, 117, 117, 30));
			lblName = new JLabel("Tell me your name:", SwingConstants.CENTER);
			lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblHello = new JLabel("Hi my boss!", SwingConstants.CENTER);
			lblHello.setForeground(Color.decode("#e21b7f"));
			lblHello.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			lblName.setForeground(Color.decode("#e02b2b"));
			lblAvatar = new JLabel();
			txtName = new JTextField(10);
			txtName.setFont(new Font("Times New Roman", Font.BOLD, 25));
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.requestFocusInWindow();
			txtName.setForeground(Color.decode("#217ab5"));
			txtName.setBorder(null);

			pnlCenter.add(lblAvatar);
			pnlCenter.add(lblHello);
			pnlCenter.add(lblName);
			pnlCenter.add(txtName);

			pnlBtn = new JPanel(new BorderLayout());
			lblBtnBack = new JLabel();
			lblBtnGo = new JLabel();
			lblAvatargif = new JLabel();
			lblAvatargif.setHorizontalAlignment(SwingConstants.CENTER);
			try {
				imgIconBack = ImageIO.read(getClass().getResource(ImageDAO.backIcon));
				lblBtnBack.setIcon(new ImageIcon(imgIconBack));

				imgAvatargif = new ImageIcon(getClass().getResource(ImageDAO.avatarKhoKho));
				lblAvatargif.setIcon(imgAvatargif);

				imgIconGo = ImageIO.read(getClass().getResource(ImageDAO.letgoIconIcon));
				lblBtnGo.setIcon(new ImageIcon(imgIconGo));

				imgAvatar = ImageIO.read(getClass().getResource(ImageDAO.avatarkhokhoImage));
				newLoaderImage = imgAvatar.getScaledInstance(200, 208, java.awt.Image.SCALE_SMOOTH);
				lblAvatar.setIcon(new ImageIcon(newLoaderImage));
			} catch (IOException e) {
				e.printStackTrace();
			}
			pnlBtn.add(lblBtnBack, BorderLayout.WEST);
			pnlBtn.add(lblAvatargif, BorderLayout.CENTER);
			pnlBtn.add(lblBtnGo, BorderLayout.EAST);
			pnlOnePlayer.add(lblTitle, BorderLayout.NORTH);
			pnlOnePlayer.add(pnlBtn, BorderLayout.SOUTH);
			pnlOnePlayer.add(pnlCenter, BorderLayout.CENTER);

			pnlBtn.setOpaque(false);
			pnlOnePlayer.setOpaque(false);
			pnlOnePlayer.setBounds(147, 60, 480, 450);
			return pnlOnePlayer;
		}

		public JLabel getLblBtnBack() {
			return lblBtnBack;
		}

		public void setLblBtnBack(JLabel lblBtnBack) {
			this.lblBtnBack = lblBtnBack;
		}

		public JLabel getLblBtnGo() {
			return lblBtnGo;
		}

		public void setLblBtnGo(JLabel lblBtnGo) {
			this.lblBtnGo = lblBtnGo;
		}

		public JTextField getTxtName() {
			return txtName;
		}

		public void setTxtName(JTextField txtName) {
			this.txtName = txtName;
		}
}
