import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.mysql.cj.protocol.Resultset;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Cursor;


class user_detail{
		static String name;
		static String email;
		static String phone_no;
		static String password;
		static String product_name;
		static int product_price;
		static String pay_method;
		static String building_no;
		static String street;
		static String city;
		static String order_det;
}


public class main_code  {
	
	
	    private JFrame frame;
	    
	    public static JTextField text_field_builn;
	    public static JTextField text_field_street;
	    public static JTextField text_field_city;
	    private static JTextField textlogin_email;
		private static  JTextField textlogin_pass;
		private static JTextField txtSearch;
	    public static  JTextField user_panel1_;
	    public static JTextField email_panel1;
	    public static JTextField phone_panel1;
	    public static JTextField password_panel1;
	    
		public static JPanel SIGNIN_PAGE;
		public static JPanel HOME;
		public static JPanel left_panel;
		public static JPanel home_panel;
		public static JPanel prod_3_1;
		public static JPanel prod_1 ;
		public static JPanel prod_2;
		public static JPanel payment_panel;
		public static JPanel  order_panel;

		public static JLayeredPane layeredPane ;
		public static JLayeredPane layeredPane_1;
		
		
		
		
		
		private static JLabel SLIDE_;
		private static JLabel user_namee;
		public static JLabel lblNewLabel_13;
		public static JLabel brand_nlabel;
		public static JLabel lblNewLabel_27;
		public static JLabel lab_rad_1;
		public static JLabel lab_rad_2;
		public static JLabel lab_rad_3;
		public static JLabel pay_var_name;
		public static JLabel pay_var_phone;
		public static JLabel pay_var_email;
		public static JLabel ord_pan_upaym;
		public static JLabel lbl_BUILDING;
		public static JLabel lbl_STREET;
		public static JLabel lbl_CITY;
		public static JLabel cancel_lbl;
		public static JLabel prod2_price_label;
		public static JLabel prod2_brand_nlabel;
		public static JLabel prod3_price_label;
		public static JLabel prod3_brand_nlabel;
		public static JLabel ord_pan_uname;
		public static JLabel ord_pan_uemail;
		public static JLabel ord_pan_uphone;
		public static JLabel ord_pan_ubrand;
		public static JLabel ord_pan_ubprice;
		public static JLabel  ord_pan_orddet;
		public static JLabel price_label;
		public static JRadioButton radio_btn_cod;
		public static JRadioButton radio_btn_pay;
		public static JButton btn_order_can;

		
		final  static String USERNAME="root";
		final  static String PASSWORD="";
		final  static String CONN="jdbc:mysql://localhost:3306/java_shop_gui";
		

		
		static void sign_up(){
			
			
	
				
		

			
				Connection con =null;
				try {
					
						con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
						
						String a="INSERT INTO log_in(USER_NAME,USER_EMAIL,USER_PHONENO,USER_PASSWORD)"+ " VALUES(?,?,?,?)";
						PreparedStatement  pst=con.prepareStatement(a);
				
						pst.setString(1, user_panel1_.getText());
						pst.setString(2, email_panel1.getText());
						pst.setString(3, phone_panel1.getText());
						pst.setString(4, password_panel1.getText());
						
						
						layeredPane.removeAll();
			 			layeredPane.add(SIGNIN_PAGE);
			 			layeredPane.repaint();
			 			layeredPane.revalidate();
			 			pst.executeUpdate();
			 			
				} 
				
			catch (Exception e) {
				}	
		}
		
		
			
		static void sign_in(){
			
			
				
					

		
					Connection con =null;
			   try {
				   
				   
				  con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
				  PreparedStatement  pst=con.prepareStatement("select * from log_in where USER_EMAIL=? and USER_PASSWORD=?");
				  
				  pst.setString(1, textlogin_email.getText());
				  pst.setString(2, textlogin_pass.getText());
				  Resultset r =(Resultset) pst.executeQuery();
				  if(((ResultSet) r).next()) {
					 

					 
				      layeredPane.removeAll();
		 			  layeredPane.add(HOME);
		 			  layeredPane.repaint();
		 			  layeredPane.revalidate();
		 			  
		 			  user_detail.name  = ((ResultSet) r).getString("USER_NAME");
		 			  user_detail.phone_no  = ((ResultSet) r).getString("USER_PHONENO");
		 			  user_detail.email  = ((ResultSet) r).getString("USER_EMAIL");
		 			  user_detail.product_name=((ResultSet) r).getString("PRODUCT_NAME");
		 			  user_detail.product_price=((ResultSet) r).getInt("PRODUCT_PRICE");
		 			  user_detail.pay_method=((ResultSet) r).getString("PAYMENT_METHOD");
		 			  user_detail.building_no=((ResultSet) r).getString("ADD_BUINO");
		 			  user_detail.street=((ResultSet) r).getString("ADD_STREET");
		 			  user_detail.city=((ResultSet) r).getString("ADD_CITY");
		 			  user_detail.order_det=((ResultSet) r).getString("ORDER_DETAIL");

		 			  
		 			  
		 			  
		 			  
		 			  
		 				ord_pan_uname.setText("MR/MISS : "+user_detail.name.toUpperCase());
			    		ord_pan_uphone.setText("PHONE NO : "+String.valueOf(user_detail.phone_no));
			    		ord_pan_uemail.setText("EMAIL : "+user_detail.email);
			    		ord_pan_upaym.setText("PAYMENT TYPE : "+user_detail.pay_method);
			    		ord_pan_ubrand.setText("PRODUCT NAME : "+(user_detail.product_name));
			    		ord_pan_ubprice.setText("PRODUCT PRICE : "+ user_detail.product_price);
			    		lbl_BUILDING.setText("ADDRESS : "+user_detail.building_no);
			    		lbl_STREET.setText(user_detail.street);
			    		lbl_CITY.setText(user_detail.city);
			    		ord_pan_orddet.setText(user_detail.order_det);
			    		user_namee.setText(user_detail.name.toUpperCase());
		 			  
		 			  
		 			  
			    		  if (user_detail.order_det.equals("ORDER CANCEL SUCCEFULLY")) {
				 				 btn_order_can.setVisible(false);
							} else {
								btn_order_can.setVisible(true);

							}
				 			  user_detail.order_det=((ResultSet) r).getString("ORDER_DETAIL");
		 			  
		 			  
		 			  
		 			  
		 			  
					  
					 
			 			
				 }

			} catch (Exception e) {
			}
		
			
		}
		
		

	

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_code  window = new main_code ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	 public main_code () {
	  	initialize();
	 }


	     private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("SHOPPING MANAGEMENT");
		frame.setResizable(false);
		frame.setBounds(100, 100, 1080, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // creation of frame 
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1074, 641);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));              // layer frame ( card layout )
		
//_______________________________________________________________________________________________________________________________________________________________

//_______________________________________________________________________________________________________________________________________________________________
		JPanel SIGNUP_page = new JPanel();
		layeredPane.add(SIGNUP_page, "name_654088566372200");
		SIGNUP_page.setLayout(null);                                                //1ST PANEL
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				
			        layeredPane.removeAll();                                 // LOGIN PAGE 
		 			layeredPane.add(SIGNIN_PAGE);
		 			layeredPane.repaint();
		 			layeredPane.revalidate();
		}			@Override
			public void mouseEntered(MouseEvent e) {
			btnNewButton.setBackground(Color.white);
			btnNewButton.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.BLACK);
				btnNewButton.setForeground(Color.WHITE);	
			}
});
		
		JLabel lblNewLabel_22 = new JLabel("ALREADY HAVE ACCOUNT ? JUST SIGN IN");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_22.setBounds(708, 537, 235, 29);
		SIGNUP_page.add(lblNewLabel_22);
		
		JLabel lblNewLabel_4 = new JLabel("OR");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblNewLabel_4.setBounds(803, 504, 46, 29);
		SIGNUP_page.add(lblNewLabel_4);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnSignUp.setForeground(Color.black);
				btnSignUp.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignUp.setForeground(Color.WHITE);
				btnSignUp.setBackground(Color.BLACK);
			}
		});
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_up();
			}
		});
		btnSignUp.setBorderPainted(false);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBounds(718, 454, 97, 29);
		SIGNUP_page.add(btnSignUp);
		btnNewButton.setBounds(825, 454, 97, 29);
		SIGNUP_page.add(btnNewButton);
		
		
		JLabel lblNewLabel_3_1_2 = new JLabel("");
		lblNewLabel_3_1_2.setIcon(new ImageIcon(main_code .class.getResource("/image/password_.png")));
		lblNewLabel_3_1_2.setBounds(658, 381, 46, 35);
		SIGNUP_page.add(lblNewLabel_3_1_2);
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(main_code .class.getResource("/image/phone_.png")));
		lblNewLabel_3_1_1.setBounds(658, 325, 53, 35);
		SIGNUP_page.add(lblNewLabel_3_1_1);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(main_code .class.getResource("/image/gmail_.png")));
		lblNewLabel_3_1.setBounds(658, 272, 46, 35);
		SIGNUP_page.add(lblNewLabel_3_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(main_code .class.getResource("/image/user_.png")));
		lblNewLabel_3.setBounds(658, 221, 46, 35);
		SIGNUP_page.add(lblNewLabel_3);
		
		JLabel signup_panel1 = new JLabel("SIGN UP ");
		signup_panel1.setForeground(Color.DARK_GRAY);
		signup_panel1.setFont(new Font("Georgia", Font.PLAIN, 22));
		 signup_panel1.setBounds(749, 127, 135, 49);
		SIGNUP_page.add(signup_panel1);
		
		
		JLabel fashion_panel1 = new JLabel("FASHION");
		fashion_panel1.setForeground(Color.decode("#333333"));
		fashion_panel1.setFont(new Font("Mongolian Baiti", Font.BOLD, 32));
		fashion_panel1.setBounds(133, 127, 271, 64);
		 SIGNUP_page.add(fashion_panel1);
		
		
		 JLabel lblNewLabel_2 = new JLabel(	 "<html> <br>HAPPINESS <br>IS NOT IN MONEY , <br>BUT IN SHOPPING</html>");
	
		 lblNewLabel_2.setForeground(Color.WHITE);
		 lblNewLabel_2.setForeground(Color.decode("#333333"));
		 lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD, 17));
		 lblNewLabel_2.setBounds(101, 465, 356, 84);
		 SIGNUP_page.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel.setBounds(644, 216, 62, 49);
		SIGNUP_page.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel_1.setBounds(644, 268, 60, 49);
		SIGNUP_page.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel_1_1.setBounds(644, 322, 60, 48);
		SIGNUP_page.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel_1_2.setBounds(644, 376, 60, 52);
		SIGNUP_page.add(lblNewLabel_1_2);
		
		 user_panel1_ = new JTextField();
		 user_panel1_.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));
		 user_panel1_.setName("");
		user_panel1_.setBounds(708, 187, 223, 41);
		SIGNUP_page.add(user_panel1_);
		user_panel1_.setColumns(10);
		user_panel1_.setForeground(Color.DARK_GRAY);
		user_panel1_.setText("      USERNAME");
		 
		user_panel1_.addMouseListener(new MouseAdapter() {
		 	
		 	public void mouseClicked(MouseEvent e) {
		 		user_panel1_.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2));
		 		user_panel1_.setText("");
		 	}
		 	public void mouseExited(MouseEvent e) {
			 	user_panel1_.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));
		 	}
		 });

		user_panel1_.setBounds(708, 222, 223, 35);
		 	SIGNUP_page.add(user_panel1_);
		 	user_panel1_.setColumns(10);
		 	
		 	
			 email_panel1 = new JTextField();
			 email_panel1.setBackground(Color.WHITE);
			 email_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));
			 email_panel1.setForeground(Color.DARK_GRAY);
		 	email_panel1.setText("      EMAIL");
		 	email_panel1.addMouseListener(new MouseAdapter() {
		 		@Override
		 		public void mouseClicked(MouseEvent e) {
		 			email_panel1.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2));
		 			email_panel1.setText("");

		 		}
		 		
		 		@Override
		 		public void mouseExited(MouseEvent e) {
		 		 	email_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));

		 		}
		 		
		 	});
		 	email_panel1.setBounds(708, 276, 223, 35);
		 	SIGNUP_page.add(email_panel1);
		 	email_panel1.setColumns(10);
		

		
		 phone_panel1 = new JTextField();
		 phone_panel1.setForeground(Color.DARK_GRAY);
	 	phone_panel1.setText("      PHONE NO ");
			phone_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));

	 	phone_panel1.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			phone_panel1.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2));
	 			phone_panel1.setText("");


	 		}
	 		@Override
	 		public void mouseExited(MouseEvent e) {
	 		 	phone_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));

	 		}
	 		
	 		
	 	});
	 	
	 	phone_panel1.setBounds(708, 332, 223, 35);
	 	SIGNUP_page.add(phone_panel1);
	 	phone_panel1.setColumns(10);
		

		
		
		
	 	password_panel1 = new JTextField();
	 	password_panel1.setForeground(Color.DARK_GRAY);
	 	password_panel1.setText("      PASSWORD ");
	 	password_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));

	 	password_panel1.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			password_panel1.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2,true));
	 			password_panel1.setText("");

	 		}
	 		@Override
	 		public void mouseExited(MouseEvent e) {
	 		 	password_panel1.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));

	 		}
	 		
	 	});
	 	
	 	password_panel1.setBounds(708, 388, 223, 35);
	 	SIGNUP_page.add(password_panel1);
	 	password_panel1.setColumns(10);
		
		
		
		JLabel bg_panel1 = new JLabel("");
		bg_panel1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/loginvv.png")));
		bg_panel1.setBounds(0, 0, 1074, 641);
		
		SIGNUP_page.add(bg_panel1);
		
		
//		____________________________________________________________________________________________________
//		SIGN_UP PANEL
//		
		 SIGNIN_PAGE = new JPanel();
		layeredPane.add(SIGNIN_PAGE, "name_654094273242000");
		SIGNIN_PAGE.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SIGN IN");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.white);
				btnNewButton_1.setForeground(Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_in();
			}
		});
		
		JLabel lblNewLabel_23 = new JLabel("WELCOME HERE !!! NICE TO MEET YOU AGAIN !!");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_23.setBounds(695, 500, 244, 29);
		SIGNIN_PAGE.add(lblNewLabel_23);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(756, 412, 101, 29);
		SIGNIN_PAGE.add(btnNewButton_1);
		
		
		
		JLabel fashion_panel = new JLabel("FASHION");
		fashion_panel.setForeground(Color.decode("#333333"));
		fashion_panel.setFont(new Font("Mongolian Baiti", Font.BOLD, 32));
		fashion_panel.setBounds(133, 127, 271, 64);
		 SIGNIN_PAGE.add(fashion_panel);
		
		
		 JLabel fashion_panel_2 = new JLabel(	 "<html> <br>HAPPINESS <br>IS NOT IN MONEY , <br>BUT IN SHOPPING</html>");
	
		 fashion_panel_2.setForeground(Color.WHITE);
		 fashion_panel_2.setForeground(Color.decode("#333333"));
		 fashion_panel_2.setFont(new Font("Lucida Fax", Font.BOLD, 17));
		 fashion_panel_2.setBounds(115, 469, 356, 84);
		 SIGNIN_PAGE.add(fashion_panel_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(main_code .class.getResource("/image/password_.png")));
		lblNewLabel_3_3.setBounds(664, 312, 36, 46);
		SIGNIN_PAGE.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel_7.setBounds(650, 314, 56, 49);
		SIGNIN_PAGE.add(lblNewLabel_7);
		
		textlogin_pass = new JTextField();
		textlogin_pass.addMouseListener(new MouseAdapter() {
		 	
		 	public void mouseClicked(MouseEvent e) {
		 		textlogin_pass.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2));
		 		textlogin_pass.setText("");
		 	}
		 	public void mouseExited(MouseEvent e) {
		 		textlogin_pass.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));
		 	}
		 });
 		textlogin_pass.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));

		textlogin_pass.setText("     ENTER YOUR PASSWORD");
		textlogin_pass.setPreferredSize(new Dimension(86, 20));
		textlogin_pass.setForeground(Color.DARK_GRAY);
		textlogin_pass.setColumns(10);
		textlogin_pass.setBounds(716, 323, 223, 35);
		SIGNIN_PAGE.add(textlogin_pass);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(main_code .class.getResource("/image/user_.png")));
		lblNewLabel_3_2.setBounds(664, 259, 42, 29);
		SIGNIN_PAGE.add(lblNewLabel_3_2);
		
		textlogin_email = new JTextField();
	
		textlogin_email.addMouseListener(new MouseAdapter() {
		 	
		 	public void mouseClicked(MouseEvent e) {
		 		textlogin_email.setBorder(BorderFactory.createLineBorder(Color.decode("#00AF91"),2));
		 		textlogin_email.setText("");
		 	}
		 	public void mouseExited(MouseEvent e) {
		 		textlogin_email.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.DARK_GRAY));
		 	}
		 });


 		textlogin_email.setBorder(new MatteBorder(0, 5, 0, 0, (Color) Color.GRAY));


		textlogin_email.setText("    ENTER UR EMAIL");
		textlogin_email.setPreferredSize(new Dimension(86, 20));
		textlogin_email.setForeground(Color.DARK_GRAY);
		textlogin_email.setColumns(10);
		textlogin_email.setBounds(716, 257, 223, 35);
		SIGNIN_PAGE.add(textlogin_email);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Ellipse 24.png")));
		lblNewLabel_6.setBounds(650, 252, 56, 49);
		SIGNIN_PAGE.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("SIGN IN");
		lblNewLabel_5.setBounds(745, 133, 120, 43);
		 lblNewLabel_5.setFont(new Font("Georgia", Font.PLAIN, 22));
		 lblNewLabel_5.setBounds(739, 131, 135, 49);
			SIGNIN_PAGE.add(lblNewLabel_5);
				
						
						
						JLabel bg_panel2 = new JLabel("");
						bg_panel2.setIcon(new ImageIcon(main_code .class.getResource("/image_home/loginvv.png")));
						bg_panel2.setBounds(0, 0, 1084, 641);
						SIGNIN_PAGE.add(bg_panel2);
						
						JLabel label = new JLabel("New label");
						label.setBounds(146, 127, 46, 14);
						SIGNIN_PAGE.add(label);
		
		 HOME = new JPanel();
		HOME.setBackground(Color.WHITE);
		layeredPane.add(HOME, "name_654098298310600");
		HOME.setLayout(null);
		
		 layeredPane_1 = new JLayeredPane();
		 layeredPane_1.setBackground(Color.WHITE);
		 layeredPane_1.setBounds(170, 0, 904, 641);
		 HOME.add(layeredPane_1);
		 layeredPane_1.setLayout(new CardLayout(0, 0));
		 
		  home_panel = new JPanel();
		  home_panel.setBackground(Color.WHITE);
		  layeredPane_1.add(home_panel, "name_318122746330000");
		  home_panel.setLayout(null);
		  
		  JLabel lblNewLabel_17 = new JLabel("");
		  lblNewLabel_17.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		SLIDE_.setIcon(new ImageIcon(main_code .class.getResource("/image_home/img2.png")));
		  	}
		  });
		  
		  
		  
		  txtSearch = new JTextField();
		  


		  txtSearch.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {

				  txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(91, 244, 189)));
		  	}
		  	@Override
		  	public void mouseExited(MouseEvent e) {
				  txtSearch.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(91, 244, 189)));
		  	}
		  });
		  
		  JLabel lblfashionIsThe = new JLabel("        \"Fashion is the armor to survive the reality of everyday life.\"");
		  lblfashionIsThe.setForeground(Color.DARK_GRAY);
		  lblfashionIsThe.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		lblfashionIsThe.setBorder(new MatteBorder(0, 8, 0, 0, (Color) new Color(91, 244, 189)));

		  	}
		  	@Override
		  	public void mouseExited(MouseEvent e) {
		  		lblfashionIsThe.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(91, 244, 189)));

		  	}
		  });
		  
		 user_namee = new JLabel("");
		  user_namee.setForeground(Color.DARK_GRAY);
		  user_namee.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		  user_namee.setBounds(694, 72, 141, 26);
		  home_panel.add(user_namee);
		  
		  
		  
		  lblfashionIsThe.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		  lblfashionIsThe.setBounds(96, 560, 689, 37);
		  home_panel.add(lblfashionIsThe);
		  txtSearch.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(91, 244, 189)));
		  txtSearch.setForeground(Color.GRAY);
		  txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  txtSearch.setText("    SEARCH");
		  txtSearch.setBounds(138, 53, 111, 26);
		  home_panel.add(txtSearch);
		  txtSearch.setColumns(10);
		  
		  JLabel lblNewLabel_21 = new JLabel("");
		  lblNewLabel_21.setIcon(new ImageIcon(main_code .class.getResource("/image_home/search_gif.gif")));
		  lblNewLabel_21.setBounds(96, 47, 46, 37);
		  home_panel.add(lblNewLabel_21);
		  
		  JLabel lblNewLabel_20 = new JLabel("");
		  lblNewLabel_20.setIcon(new ImageIcon(main_code .class.getResource("/image_home/ser_btn.png")));
		  lblNewLabel_20.setBounds(78, 38, 228, 60);
		  home_panel.add(lblNewLabel_20);
		  
		  JLabel lblNewLabel_19 = new JLabel("  WELCOME");
		  lblNewLabel_19.setForeground(Color.GRAY);
		  lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  lblNewLabel_19.setBounds(682, 51, 91, 28);
		  home_panel.add(lblNewLabel_19);
		  lblNewLabel_17.setIcon(new ImageIcon(main_code .class.getResource("/image_home/ICON_1.png")));
		  lblNewLabel_17.setBounds(845, 149, 45, 45);
		  home_panel.add(lblNewLabel_17);
		  
		  JLabel lblNewLabel_10 = new JLabel("");
		  lblNewLabel_10.setIcon(new ImageIcon(main_code .class.getResource("/image_home/user_gif.gif")));
		  lblNewLabel_10.setBorder(null);
		  lblNewLabel_10.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		  lblNewLabel_10.setBounds(642, 38, 46, 60);
		  home_panel.add(lblNewLabel_10);
		  
		  JLabel lblNewLabel_17_4 = new JLabel("");
		  lblNewLabel_17_4.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
			  		SLIDE_.setIcon(new ImageIcon(main_code .class.getResource("/image/IMAGE_5.png")));		  	

		  	}
		  });
		  lblNewLabel_17_4.setIcon(new ImageIcon(main_code .class.getResource("/image/img5.png")));
		  lblNewLabel_17_4.setBounds(845, 482, 45, 45);
		  home_panel.add(lblNewLabel_17_4);
		  
		  JLabel lblNewLabel_17_3 = new JLabel("");
		  lblNewLabel_17_3.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
				
				   SLIDE_.setIcon(new ImageIcon(main_code .class.getResource("/image/IMAGE_4.png")));

		  	}
		  });
		  lblNewLabel_17_3.setIcon(new ImageIcon(main_code .class.getResource("/image/img4.png")));
		  lblNewLabel_17_3.setBounds(845, 408, 45, 45);
		  home_panel.add(lblNewLabel_17_3);
		  
		  JLabel lblNewLabel_17_2 = new JLabel("");
		  lblNewLabel_17_2.setIcon(new ImageIcon(main_code .class.getResource("/image_home/img3_icon.png")));
		  lblNewLabel_17_2.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		SLIDE_.setIcon(new ImageIcon(main_code .class.getResource("/image_home/IMAGE_3.png")));		  	

		  	}
		  });

		  lblNewLabel_17_2.setBounds(845, 324, 45, 45);
		  home_panel.add(lblNewLabel_17_2);
		  
		  JLabel lblNewLabel_17_1 = new JLabel("");
		  lblNewLabel_17_1.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		SLIDE_.setIcon(new ImageIcon(main_code .class.getResource("/image_home/IMAGE_2.png")));		  	}
		  });
		  lblNewLabel_17_1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/img2_icon.png")));
		  lblNewLabel_17_1.setBounds(845, 243, 45, 45);
		  home_panel.add(lblNewLabel_17_1);
		  
		  JLabel lblNewLabel_16 = new JLabel("New label");
		  lblNewLabel_16.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {
		  		
		  		layeredPane_1.removeAll();
	 			layeredPane_1.add(prod_1);
	 			layeredPane_1.repaint();
	 			layeredPane_1.revalidate();
				
		  		
		  	}
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		 lblNewLabel_16.setIcon(new ImageIcon(main_code .class.getResource("/image_home/home_HOVER.png")));		  	}
		  	@Override
		  	public void mouseExited(MouseEvent e) {
				  lblNewLabel_16.setIcon(new ImageIcon(main_code .class.getResource("/image_home/home_slidebtn.png")));
		  	}
		  });
		  lblNewLabel_16.setIcon(new ImageIcon(main_code .class.getResource("/image_home/home_slidebtn.png")));
		  lblNewLabel_16.setBounds(10, 258, 160, 160);
		  home_panel.add(lblNewLabel_16);
		  
		  SLIDE_ = new JLabel("");
		  SLIDE_.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
				   SLIDE_.setIcon(new ImageIcon(main_code.class.getResource("/image/brand_img.gif")));

		  	}
		  });
		   SLIDE_.setBorder(null);
		   SLIDE_.setIcon(new ImageIcon(main_code.class.getResource("/image/brand_img.gif")));
		   SLIDE_.setBounds(90, 149, 695, 378);
		   home_panel.add(SLIDE_);
		  
		  
		   JLabel lblNewLabel_9 = new JLabel("New label");
		   lblNewLabel_9.setIcon(new ImageIcon(main_code .class.getResource("/image_home/panel_re.jpg")));
		   lblNewLabel_9.setBounds(-14, 0, 918, 641);
		   home_panel.add(lblNewLabel_9);
		   
		   prod_1 = new JPanel();
		   prod_1.setBackground(Color.WHITE);
		   layeredPane_1.add(prod_1, "name_387067200569400");
		   prod_1.setLayout(null);
		    
		    JButton btnNewButton_2 = new JButton("BUY NOW");
		    btnNewButton_2.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseEntered(MouseEvent e) {
		    		
		    		  
		   		 btnNewButton_2.setForeground(Color.black);
				 btnNewButton_2.setBackground(Color.decode("#168B62"));
		    		
		    	}
		    	@Override
		    	public void mouseExited(MouseEvent e) {
		    		 btnNewButton_2.setForeground(Color.WHITE);
		 		     btnNewButton_2.setBackground(Color.BLACK);
		    	   
		    	}
		    });
		    btnNewButton_2.setForeground(Color.WHITE);
		    btnNewButton_2.setBackground(Color.BLACK);
		    btnNewButton_2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		
		    		 btnNewButton_2.setForeground(Color.WHITE);
		 		     btnNewButton_2.setBackground(Color.BLACK);
		 		     
		    		String a= brand_nlabel.getText();
		    		user_detail.product_name=a;
//		    		
		    		int b=Integer.parseInt(price_label.getText());
		    		user_detail.product_price=b;
		    		
//		    		
		    		lblNewLabel_27.setText(user_detail.product_name);
		    		
		    		pay_var_name.setText(user_detail.name.toUpperCase());
			   		pay_var_email.setText(user_detail.email);
			   		pay_var_phone.setText(String.valueOf(user_detail.phone_no));
//   		

			  		layeredPane_1.removeAll();
		 			layeredPane_1.add(payment_panel);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
					
		    		
		    	}
		    });
		    
		    JLabel brand_nlabel_1 = new JLabel(" PURE  100 PERCENT COTTON");
		    brand_nlabel_1.setForeground(Color.DARK_GRAY);
		    brand_nlabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		    brand_nlabel_1.setBounds(486, 158, 332, 39);
		    prod_1.add(brand_nlabel_1);
		    btnNewButton_2.setBounds(596, 500, 102, 32);
		    prod_1.add(btnNewButton_2);
		    
		     
		     JLabel lblNewLabel_32_1 = new JLabel("");
		     lblNewLabel_32_1.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     		layeredPane_1.removeAll();
		 			layeredPane_1.add(prod_2);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
		     		
		     		
		     		
		     	}
		     });
		     lblNewLabel_32_1.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/nav_bt_2n_or_pay.png")));
		     lblNewLabel_32_1.setBounds(839, 320, 55, 95);
		     prod_1.add(lblNewLabel_32_1);
		     
		     JLabel lblNewLabel_32 = new JLabel("");
		
		     lblNewLabel_32.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/nav_btn_or_pay.png")));
		     lblNewLabel_32.setBounds(0, 317, 56, 95);
		     prod_1.add(lblNewLabel_32);
		    
		     price_label = new JLabel("800");
		    price_label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		    price_label.setBounds(486, 258, 87, 32);
		    prod_1.add(price_label);
		    
		    JLabel lblNewLabel_31 = new JLabel("<html>DESCRIPTION : <br><br>A multi-coloured striped magic cotton fabric makes it attraction<br>It gives you a slimmer and taller appearance than usual<br>Having a regular collar and tailored fit <br>A slim fit multi colour shirt with a full buttoned half sleeve<html>");
		    lblNewLabel_31.setForeground(Color.DARK_GRAY);
		    lblNewLabel_31.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		    lblNewLabel_31.setBounds(486, 317, 323, 163);
		    prod_1.add(lblNewLabel_31);
		    
		    JLabel lblNewLabel_28 = new JLabel("");
		    lblNewLabel_28.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/prod_1.png")));
		    lblNewLabel_28.setBounds(111, 109, 295, 448);
		    prod_1.add(lblNewLabel_28);
		    
		    JLabel lblNewLabel_26 = new JLabel("RUPEES");
		    lblNewLabel_26.setForeground(Color.DARK_GRAY);
		    lblNewLabel_26.setFont(new Font("Georgia", Font.PLAIN, 20));
		    lblNewLabel_26.setBounds(486, 202, 87, 45);
		    prod_1.add(lblNewLabel_26);
		
		   
		    brand_nlabel = new JLabel("MENS SHIRT ");
		    brand_nlabel.setForeground(Color.DARK_GRAY);
		    brand_nlabel.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		   brand_nlabel.setBounds(486, 126, 332, 39);
		   prod_1.add(brand_nlabel);
		   
		   JLabel lblNewLabel_25 = new JLabel("");
		   lblNewLabel_25.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		   lblNewLabel_25.setIcon(new ImageIcon(main_code .class.getResource("/image_home/prod_bg.png")));

		   lblNewLabel_25.setBounds(56, 34, 789, 596);
		   prod_1.add(lblNewLabel_25);
		   
		   JLabel lblNewLabel_24 = new JLabel("");
		   lblNewLabel_24.setIcon(new ImageIcon(main_code .class.getResource("/image_home/bg_prodd.png")));
		   lblNewLabel_24.setBounds(0, -4, 904, 641);
		   prod_1.add(lblNewLabel_24);
		   
		   JLabel label_1 = new JLabel("New label");
		   label_1.setBounds(10, 257, 46, 14);
		   prod_1.add(label_1);
		   
		    payment_panel = new JPanel();
		    payment_panel.setBackground(Color.WHITE);
		   layeredPane_1.add(payment_panel, "name_3642388970900");
		   payment_panel.setLayout(null);
		    
		     radio_btn_pay = new JRadioButton("PAY NOW");
		     radio_btn_pay.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
		     		if(radio_btn_pay.isSelected()) {
		     			radio_btn_cod.setSelected(false);
		     			user_detail.pay_method="PAYMENT DONE";
		   		     lab_rad_1.setEnabled(true);
		   		  lab_rad_2.setEnabled(true);
		   		  lab_rad_3.setEnabled(true);

		   	   lab_rad_1.setText(user_detail.product_name);
	   		     lab_rad_2.setText("PRODUCT AMOUNT "+user_detail.product_price);
	   		     lab_rad_3.setText(user_detail.pay_method);
		   		

		     		}
		     		
		     	}
		     });
		       
		       JLabel lblNewLabel_38 = new JLabel("");
		       lblNewLabel_38.setIcon(new ImageIcon(main_code .class.getResource("/image_home/ezgif.com-gif-maker.gif")));
		       lblNewLabel_38.setBounds(398, 199, 122, 112);
		       payment_panel.add(lblNewLabel_38);
		      
		       pay_var_phone = new JLabel("");
		       pay_var_phone.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		       pay_var_phone.setForeground(Color.DARK_GRAY);
		      pay_var_phone.setBounds(81, 93, 281, 29);
		       pay_var_phone.setForeground(Color.decode("#168B62"));

		      payment_panel.add(pay_var_phone);
		      
		       pay_var_email = new JLabel("");
		       pay_var_email.setForeground(Color.DARK_GRAY);
		       pay_var_email.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		      pay_var_email.setBounds(81, 114, 281, 33);
		       pay_var_email.setForeground(Color.decode("#168B62"));

		      payment_panel.add(pay_var_email);
		      
		       pay_var_name = new JLabel("");
		       pay_var_name.setForeground(Color.DARK_GRAY);

		      pay_var_name.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		      pay_var_name.setBounds(81, 70, 220, 33);
		      payment_panel.add(pay_var_name);
		      
		      JLabel pay_var_icon = new JLabel("New label");
		      pay_var_icon.setIcon(new ImageIcon(main_code .class.getResource("/image_home/user_gif.gif")));
		      pay_var_icon.setBounds(24, 50, 46, 60);
		      payment_panel.add(pay_var_icon);
		     
		      lab_rad_3 = new JLabel("");
		      lab_rad_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		     lab_rad_3.setEnabled(false);
		     lab_rad_3.setBounds(55, 562, 246, 45);
		     lab_rad_3.setEnabled(false);

		     payment_panel.add(lab_rad_3);
		     
		    lab_rad_2 = new JLabel("");
		    lab_rad_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		     lab_rad_2.setBounds(55, 516, 246, 40);
		     lab_rad_2.setEnabled(false);
		     payment_panel.add(lab_rad_2);
		    
		     lab_rad_1 = new JLabel("");
		     lab_rad_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		     lab_rad_1.setEnabled(false);
		    lab_rad_1.setBounds(55, 450, 246, 55);
		    payment_panel.add(lab_rad_1);
		    
		    JLabel lblNewLabel_30 = new JLabel(" YOUR PAYMNET AMOUNT : ");
		    lblNewLabel_30.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		    lblNewLabel_30.setBounds(55, 401, 246, 33);
		    payment_panel.add(lblNewLabel_30);
		    
		    JButton btnNewButton_3 = new JButton("COMPLETE YOUR PAYMENT");
		    btnNewButton_3.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseEntered(MouseEvent e) {
		    		
		    		 btnNewButton_3.setForeground(Color.black);
					 btnNewButton_3.setBackground(Color.decode("#168B62"));
		    		
		    	}
		    	@Override
		    	public void mouseExited(MouseEvent e) {
		   		 btnNewButton_3.setForeground(Color.white);
				 btnNewButton_3.setBackground(Color.black);
		    	}
		    });
		    btnNewButton_3.setForeground(Color.WHITE);
		    btnNewButton_3.setBackground(Color.BLACK);
		    btnNewButton_3.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		
		    		
		   		    btnNewButton_3.setForeground(Color.black);
				    btnNewButton_3.setBackground(Color.decode("#168B62"));
		    		
		    		ord_pan_uname.setText("MR/MISS : "+user_detail.name.toUpperCase());
		    		ord_pan_uphone.setText("PHONE NO : "+String.valueOf(user_detail.phone_no));
		    		ord_pan_uemail.setText("EMAIL : "+user_detail.email);
		    		ord_pan_upaym.setText("PAYMENT TYPE : "+user_detail.pay_method);
		    		ord_pan_orddet.setText("DELIVRY APPROVED");
		    		
		    		user_detail.building_no=text_field_builn.getText();
		    		user_detail.street=text_field_street.getText();
		    		user_detail.city=text_field_city.getText();
		    		user_detail.order_det=ord_pan_orddet.getText();

		    		
		    		lbl_BUILDING.setText("ADDRESS : "+ user_detail.building_no);
		    		lbl_STREET.setText(user_detail.street);
		    		lbl_CITY.setText(user_detail.city);

		    		ord_pan_ubrand.setText("PRODUCT NAME : "+user_detail.product_name);
		    		ord_pan_ubprice.setText("PRODUCT PRICE : "+ user_detail.product_price);
		    		Connection con =null;
					try {
						
							con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
							
							String a="UPDATE `log_in` SET"
									+ " `PRODUCT_NAME` = ?, `PRODUCT_PRICE` = ?, `PAYMENT_METHOD` = ?, `ADD_BUINO` = ?, `ADD_STREET` = ?, `ADD_CITY` = ?, `ORDER_DETAIL` = ?  "
									+ "WHERE `log_in`.`USER_EMAIL` = ?;";
							PreparedStatement  pst=con.prepareStatement(a);
					
							pst.setString(1, user_detail.product_name);
							pst.setInt(2, user_detail.product_price);
							pst.setString(3, user_detail.pay_method);
							pst.setString(4, user_detail.building_no);
							pst.setString(5, user_detail.street);
							pst.setString(6, user_detail.city);	
							pst.setString(7, user_detail.order_det);
							pst.setString(8, user_detail.email);		

							
				 			pst.executeUpdate();
				 			
					} 
					
				catch (Exception e1) {
						System.out.println(e1);
					}	
			
					 if (user_detail.order_det.equals("ORDER CANCEL SUCCEFULLY")) {
		 				 btn_order_can.setVisible(false);
					} else {
						btn_order_can.setVisible(true);

					}
		 			 
 			  
		    		
		    		layeredPane_1.removeAll();
		 			layeredPane_1.add(order_panel);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
		    		
		    		
		    		
		    		
		    		
		    	}
		    });
		    btnNewButton_3.setBounds(666, 578, 196, 40);
		    payment_panel.add(btnNewButton_3);
		    
		    JLabel lblNewLabel_29_2 = new JLabel("CITY , STATE & ZIP CODE");
		    lblNewLabel_29_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		    lblNewLabel_29_2.setBounds(434, 494, 172, 33);
		    payment_panel.add(lblNewLabel_29_2);
		    
		    JLabel lblNewLabel_29 = new JLabel("BUILDING NAME /FLAT NO");
		    lblNewLabel_29.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		    lblNewLabel_29.setBounds(434, 381, 172, 33);
		    payment_panel.add(lblNewLabel_29);
		    
		    JLabel lblNewLabel_29_1 = new JLabel("STREET NAME/AREA");
		    lblNewLabel_29_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		    lblNewLabel_29_1.setBounds(431, 436, 153, 33);
		    payment_panel.add(lblNewLabel_29_1);
		    
		    text_field_street = new JTextField();
		    text_field_street.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		    text_field_street.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		    text_field_street.setColumns(10);
		    text_field_street.setBounds(622, 438, 233, 33);
		    payment_panel.add(text_field_street);
		    
		    text_field_city = new JTextField();
		    text_field_city.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		    text_field_city.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		    text_field_city.setColumns(10);
		    text_field_city.setBounds(622, 494, 233, 33);
		    payment_panel.add(text_field_city);
		    
		    text_field_builn = new JTextField();
		    text_field_builn.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		    text_field_builn.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		    text_field_builn.setBounds(622, 381, 233, 33);
		    payment_panel.add(text_field_builn);
		    text_field_builn.setColumns(10);
		    radio_btn_pay.setFocusable(false);
		    radio_btn_pay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    radio_btn_pay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		    radio_btn_pay.setBackground(Color.WHITE);
		    radio_btn_pay.setBounds(222, 339, 161, 40);
		    payment_panel.add(radio_btn_pay);
		    
		     radio_btn_cod = new JRadioButton(" CASH ON DELIVERY ");
		     radio_btn_cod.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
		     		if(radio_btn_cod.isSelected()) {
		     			radio_btn_pay.setSelected(false);
		     			user_detail.pay_method=radio_btn_cod.getText();
		     		
			   		     lab_rad_1.setEnabled(true);
			   		  lab_rad_2.setEnabled(true);
			   		  lab_rad_3.setEnabled(true);

			   		     lab_rad_1.setText(user_detail.product_name);
			   		     lab_rad_2.setText("PRODUCT AMOUNT "+user_detail.product_price);
			   		     lab_rad_3.setText(user_detail.pay_method);
		     			
		     		}
		     	
		     		
		     	}
		     });
		    radio_btn_cod.setFocusable(false);
		    radio_btn_cod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    radio_btn_cod.setForeground(Color.BLACK);
		    radio_btn_cod.setFont(new Font("SansSerif", Font.PLAIN, 14));
		    radio_btn_cod.setBorder(null);
		    radio_btn_cod.setBackground(Color.WHITE);
		    radio_btn_cod.setBounds(55, 339, 161, 40);
		    payment_panel.add(radio_btn_cod);
		   
		    lblNewLabel_27 = new JLabel("");
		    lblNewLabel_27.setIcon(new ImageIcon(main_code .class.getResource("/image_home/PAY_PANEL_OR.png")));
		    lblNewLabel_27.setBounds(-5, -10, 904, 641);
		    payment_panel.add(lblNewLabel_27);
		    
		    order_panel = new JPanel();
		    layeredPane_1.add(order_panel, "name_106177915133900");
		    order_panel.setLayout(null);
		        
		         btn_order_can = new JButton("CANCEL ORDER");
		         btn_order_can.addMouseListener(new MouseAdapter() {
		         	@Override
		         	public void mouseEntered(MouseEvent e) {
		         	      btn_order_can.setBackground(Color.white);
		  		        btn_order_can.setForeground(Color.black);
		         	}
		         	@Override
		         	public void mouseExited(MouseEvent e) {
		         	      btn_order_can.setBackground(Color.BLACK);
		  		        btn_order_can.setForeground(Color.WHITE);
		         	}
		         });
		        btn_order_can.setBackground(Color.BLACK);
		        btn_order_can.setForeground(Color.WHITE);
		        btn_order_can.setFont(new Font("Tahoma", Font.PLAIN, 14));
		        btn_order_can.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {

			    		Connection con =null;
						try {
							
								con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
								
								String a="UPDATE `log_in` SET"
										+ " `ORDER_DETAIL` = ?, `PAYMENT_METHOD` = ?"
										+ "WHERE `log_in`.`USER_EMAIL` = ?;";
								PreparedStatement  pst=con.prepareStatement(a);
						
								pst.setString(1, "ORDER CANCEL SUCCEFULLY");
								pst.setString(2, "CANCELED");
								pst.setString(3, user_detail.email);
					 			pst.executeUpdate();

						} 
						
					catch (Exception e1) {
							System.out.println(e1);
						}
						ord_pan_upaym.setText("PAYMENT TYPE : CANCELED ");

				        ord_pan_orddet.setText("ORDER CANCEL SUCCEFULLY");
				        cancel_lbl.setText("YOUR ORDER CANCELED");

			    		
                      
		        	}
		        	

		        });
		        
		         cancel_lbl = new JLabel("");
		         cancel_lbl.setForeground(Color.DARK_GRAY);
		         cancel_lbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		        cancel_lbl.setBounds(111, 570, 406, 43);
		        order_panel.add(cancel_lbl);
		        

		        
		        btn_order_can.setBounds(632, 578, 162, 35);
		        order_panel.add(btn_order_can);
		        
		        JLabel lblNewLabel_37 = new JLabel("MY ORDER");
		        lblNewLabel_37.setForeground(Color.GRAY);
		        lblNewLabel_37.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		        lblNewLabel_37.setBounds(111, 49, 195, 52);
		        order_panel.add(lblNewLabel_37);
		        
		        JLabel lblNewLabel_36 = new JLabel("");
		        lblNewLabel_36.setIcon(new ImageIcon(main_code .class.getResource("/image_home/iv__.gif")));
		        lblNewLabel_36.setBounds(199, 179, 54, 56);
		        order_panel.add(lblNewLabel_36);
		        
		        JLabel lblNewLabel_35 = new JLabel("");
		        lblNewLabel_35.setIcon(new ImageIcon(main_code .class.getResource("/image_home/rtyh.gif")));
		        lblNewLabel_35.setBounds(53, 277, 121, 112);
		        order_panel.add(lblNewLabel_35);
		       
		        lbl_CITY = new JLabel("");
		       lbl_CITY.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		       lbl_CITY.setBounds(509, 439, 224, 35);
		       order_panel.add(lbl_CITY);
		       
		       lbl_STREET = new JLabel("");
		       lbl_STREET.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		       lbl_STREET.setBounds(509, 403, 224, 35);
		       order_panel.add(lbl_STREET);
		       
		        lbl_BUILDING = new JLabel("");
		       lbl_BUILDING.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		       lbl_BUILDING.setBounds(509, 370, 224, 35);
		       order_panel.add(lbl_BUILDING);
		      
		       ord_pan_upaym = new JLabel("");
		       ord_pan_upaym.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		      ord_pan_upaym.setBounds(509, 313, 240, 30);
		      order_panel.add(ord_pan_upaym);
		     
		      ord_pan_ubrand = new JLabel("");
		      ord_pan_ubrand.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		     ord_pan_ubrand.setBounds(509, 212, 224, 43);
		     order_panel.add(ord_pan_ubrand);
		     
		      ord_pan_ubprice = new JLabel("");
		      ord_pan_ubprice.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		     ord_pan_ubprice.setBounds(509, 266, 224, 35);
		     order_panel.add(ord_pan_ubprice);
		    
		     ord_pan_uemail = new JLabel("");
		    ord_pan_uemail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		    ord_pan_uemail.setBounds(203, 427, 220, 25);
		    order_panel.add(ord_pan_uemail);
		    
		     ord_pan_uname = new JLabel("");
		    ord_pan_uname.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		    ord_pan_uname.setBounds(203, 391, 220, 25);
		    order_panel.add(ord_pan_uname);
		    
		    JLabel ord_pan_uicon  = new JLabel("");
		    ord_pan_uicon.setIcon(new ImageIcon(main_code .class.getResource("/image_home/user_gif.gif")));
		    ord_pan_uicon.setBounds(228, 346, 46, 43);
		    order_panel.add(ord_pan_uicon);
		    
		     ord_pan_uphone = new JLabel("");
		    ord_pan_uphone.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		    ord_pan_uphone.setBounds(203, 463, 220, 22);
		    order_panel.add(ord_pan_uphone);
		    
		     ord_pan_orddet = new JLabel("");
		    ord_pan_orddet.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		    ord_pan_orddet.setBounds(247, 192, 195, 43);
		    order_panel.add(ord_pan_orddet);
		    
		    JLabel lblNewLabel_33 = new JLabel("");
		    lblNewLabel_33.setIcon(new ImageIcon(main_code .class.getResource("/image_order_payment/order_d.png")));
		    lblNewLabel_33.setBounds(0, -2, 904, 641);
		    order_panel.add(lblNewLabel_33);
		    
		    
		  
		   
		    prod_2 = new JPanel();
			   prod_2.setBackground(Color.WHITE);
			   layeredPane_1.add(prod_2, "name_387067200569400");
			   prod_2.setLayout(null);
			    
			    JButton prod2_btn = new JButton("BUY NOW");
			    prod2_btn.addMouseListener(new MouseAdapter() {
			    	@Override
			    	public void mouseEntered(MouseEvent e) {
			    		
			    		   prod2_btn.setForeground(Color.BLACK);
			   		    prod2_btn.setBackground(Color.WHITE);
			    		
			    	}
			    	@Override
			    	public void mouseExited(MouseEvent e) {
			    		
			    	    prod2_btn.setForeground(Color.WHITE);
					    prod2_btn.setBackground(Color.BLACK);
			    	}
			    });
			    prod2_btn.setForeground(Color.WHITE);
			    prod2_btn.setBackground(Color.BLACK);
			    prod2_btn.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		String a= prod2_brand_nlabel.getText();
			    		user_detail.product_name=a;
//			    		
			    		int b=Integer.parseInt(prod2_price_label.getText());
			    		user_detail.product_price=b;
			    		
//			    		
			    		lblNewLabel_27.setText(user_detail.product_name);
			    		
			    		pay_var_name.setText(user_detail.name);
				   		pay_var_email.setText(user_detail.email);
				   		pay_var_phone.setText(String.valueOf(user_detail.phone_no));
//	   		

				  		layeredPane_1.removeAll();
			 			layeredPane_1.add(payment_panel);
			 			layeredPane_1.repaint();
			 			layeredPane_1.revalidate();
						
			    		
			    	}
			    });
			    prod2_btn.setBounds(596, 500, 102, 32);
			    prod_2.add(prod2_btn);
			    
			     
			     JLabel prod2_nav1_label = new JLabel("");
			  
			     prod2_nav1_label.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/nav_bt_2n_or_pay.png")));
			     prod2_nav1_label.setBounds(840, 320, 54, 95);
			     prod_2.add(prod2_nav1_label);
			     
			     JLabel prod2_nav1_label2 = new JLabel("");
			     prod2_nav1_label2.addMouseListener(new MouseAdapter() {
			     	@Override
			     	public void mouseClicked(MouseEvent e) {
			     		layeredPane_1.removeAll();
			 			layeredPane_1.add(prod_1);
			 			layeredPane_1.repaint();
			 			layeredPane_1.revalidate();
			     	}
			     });
			     prod2_nav1_label2.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/nav_btn_or_pay.png")));
			     prod2_nav1_label2.setBounds(0, 317, 56, 95);
			     prod_2.add(prod2_nav1_label2);
			    
			     prod2_price_label = new JLabel("1299");
			    prod2_price_label.setFont(new Font("Tahoma", Font.PLAIN, 21));
			    prod2_price_label.setBounds(486, 258, 87, 32);
			    prod_2.add(prod2_price_label);
			    
			    JLabel prod2_desp = new JLabel("<html>DESCRIPTION : <br><br>A multi-coloured striped magic cotton fabric makes it attraction<br>It gives you a slimmer and taller appearance than usual<br>Having a regular collar and tailored fit <br>A slim fit multi colour shirt with a full buttoned half sleeve<html>");
			    prod2_desp.setForeground(Color.DARK_GRAY);
			    prod2_desp.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
			    prod2_desp.setBounds(486, 317, 323, 163);
			    prod_2.add(prod2_desp);
			    
			    JLabel prod2_img = new JLabel("");
			    prod2_img.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/prod_2.png")));
//			    prod2_img.setIcon(new ImageIcon(main_code.class.getResource("/image_prod/prod_2.png")));
			    prod2_img.setBounds(111, 109, 295, 448);
			    prod_2.add(prod2_img);
			    
			    JLabel prod2_rupees = new JLabel("RUPEES");
			    prod2_rupees.setForeground(Color.DARK_GRAY);
			    prod2_rupees.setFont(new Font("Georgia", Font.PLAIN, 20));
			    prod2_rupees.setBounds(486, 202, 87, 45);
			    prod_2.add(prod2_rupees);
			
			   
			    prod2_brand_nlabel = new JLabel("WOMEN SHIRT");
			    prod2_brand_nlabel.setForeground(Color.DARK_GRAY);
			    prod2_brand_nlabel.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
			   prod2_brand_nlabel.setBounds(486, 119, 332, 63);
			   prod_2.add(prod2_brand_nlabel);
			   
			   JLabel prod2_bg1 = new JLabel("");
			   prod2_bg1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			   prod2_bg1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/prod_bg.png")));
			   prod2_bg1.setBounds(56, 34, 789, 596);
			   prod_2.add(prod2_bg1);
			   
			   JLabel prod2_bg2 = new JLabel("");
			   prod2_bg2.setIcon(new ImageIcon(main_code .class.getResource("/image_home/bg_prodd.png")));
			   prod2_bg2.setBounds(0, -4, 904, 641);
			   prod_2.add(prod2_bg2);
			   
			   JPanel prod_3_1;
		   

	           prod_3_1 = new JPanel();
			   prod_3_1.setBackground(Color.WHITE);
			   layeredPane_1.add(prod_3_1, "name_387067200569400");
			   prod_3_1.setLayout(null);
			    
			    JButton prod3_btn = new JButton("BUY NOW");
			    prod3_btn.addMouseListener(new MouseAdapter() {
			    	@Override
			    	public void mouseEntered(MouseEvent e) {
			    		
			    		   prod3_btn.setForeground(Color.BLACK);
			   		    prod3_btn.setBackground(Color.WHITE);
			    		
			    	}
			    	@Override
			    	public void mouseExited(MouseEvent e) {
			    		
			    	    prod3_btn.setForeground(Color.WHITE);
					    prod3_btn.setBackground(Color.BLACK);
			    	}
			    });
			    prod3_btn.setForeground(Color.WHITE);
			    prod3_btn.setBackground(Color.BLACK);
			    prod3_btn.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		String a= prod3_brand_nlabel.getText();
			    		user_detail.product_name=a;
//			    		
			    		int b=Integer.parseInt(prod3_price_label.getText());
			    		user_detail.product_price=b;
			    		
//			    		
			    		lblNewLabel_27.setText(user_detail.product_name);
			    		
			    		pay_var_name.setText(user_detail.name);
				   		pay_var_email.setText(user_detail.email);
				   		pay_var_phone.setText(String.valueOf(user_detail.phone_no));
//	   		

				  		layeredPane_1.removeAll();
			 			layeredPane_1.add(payment_panel);
			 			layeredPane_1.repaint();
			 			layeredPane_1.revalidate();
						
			    		
			    	}
			    });
			    prod3_btn.setBounds(596, 500, 102, 32);
			    prod_3_1.add(prod3_btn);
			    
			     prod3_price_label = new JLabel("5000");
			    prod3_price_label.setFont(new Font("Tahoma", Font.PLAIN, 21));
			    prod3_price_label.setBounds(486, 258, 87, 32);
			    prod_3_1.add(prod3_price_label);
			    
			    JLabel prod3_desp = new JLabel("<html>DESCRIPTION : <br><br> Primary Material: Stainless Steel ; Case Shape: Circle ; Clasp type: Strap buckle.<br> \r\nStrap Type:Two Piece Strap.<br>  Occasion : Sports\r\nWatch Movement Type: Quartz, Watch Display Type: Chronograph<br> \r\n\r\nWarranty type:Manufacturer; 2 Years International Warranty<html>");
			    prod3_desp.setForeground(Color.DARK_GRAY);
			    prod3_desp.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
			    prod3_desp.setBounds(486, 317, 323, 163);
			    prod_3_1.add(prod3_desp);
			    
			    JLabel prod3_img = new JLabel("");
			    prod3_img.setIcon(new ImageIcon(main_code .class.getResource("/image_prod/prod_3.png")));
			    prod3_img.setBounds(111, 109, 295, 448);
			    prod_3_1.add(prod3_img);
			    
			    JLabel prod3_rupees = new JLabel("RUPEES");
			    prod3_rupees.setForeground(Color.DARK_GRAY);
			    prod3_rupees.setFont(new Font("Georgia", Font.PLAIN, 20));
			    prod3_rupees.setBounds(486, 202, 87, 45);
			    prod_3_1.add(prod3_rupees);
			
			   
			    prod3_brand_nlabel = new JLabel("PREMIUM WATCH ");
			    prod3_brand_nlabel.setForeground(Color.DARK_GRAY);
			    prod3_brand_nlabel.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
			   prod3_brand_nlabel.setBounds(486, 119, 332, 81);
			   prod_3_1.add(prod3_brand_nlabel);
			   
			   JLabel prod3_bg1 = new JLabel("");
			   prod3_bg1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			   prod3_bg1.setIcon(new ImageIcon(main_code .class.getResource("/image_home/prod_bg.png")));

			   prod3_bg1.setBounds(56, 34, 789, 596);
			   prod_3_1.add(prod3_bg1);
			   
			   JLabel prod3_bg2 = new JLabel("");
			   prod3_bg2.setIcon(new ImageIcon(main_code .class.getResource("/image_home/bg_prodd.png")));
			   prod3_bg2.setBounds(0, -4, 904, 641);
			   prod_3_1.add(prod3_bg2);
		   
			   
			   
			   
			   
			   
		   
		   
		   
		   
		   
		  
		   left_panel = new JPanel();
		   left_panel.setForeground(SystemColor.activeCaptionBorder);
			left_panel.setBackground(Color.WHITE);
			left_panel.setBounds(0, 0, 170, 641);
			HOME.add(left_panel);
			left_panel.setLayout(null);
		  
		  
			JLabel lblNewLabel_15 = new JLabel("   MY ORDER");
			lblNewLabel_15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					layeredPane_1.removeAll();
		 			layeredPane_1.add(order_panel);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
			
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
					lblNewLabel_15.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.decode("#5BF4BD")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_15.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.decode("#5BF4BD")));
				}
				
			});
			lblNewLabel_15.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_15.setBounds(15, 404, 114, 27);
			left_panel.add(lblNewLabel_15);
			
			JLabel lblNewLabel_14 = new JLabel("   TRENDING ");
			lblNewLabel_14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					layeredPane_1.removeAll();
		 			layeredPane_1.add(prod_3_1);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel_14.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.decode("#5BF4BD")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_14.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.decode("#5BF4BD")));
				}
			});
			
			
			lblNewLabel_14.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_14.setBounds(15, 353, 114, 27);
			left_panel.add(lblNewLabel_14);
			
			 lblNewLabel_13 = new JLabel("   SHOPPING ");
			lblNewLabel_13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					layeredPane_1.removeAll();
		 			layeredPane_1.add(prod_1);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel_13.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.decode("#5BF4BD")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_13.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.decode("#5BF4BD")));
				}
				
			});
			lblNewLabel_13.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_13.setBounds(15, 302, 114, 27);
			left_panel.add(lblNewLabel_13);
			
			JLabel lblNewLabel_12 = new JLabel("   HOME");
			lblNewLabel_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					layeredPane_1.removeAll();
		 			layeredPane_1.add(home_panel);
		 			layeredPane_1.repaint();
		 			layeredPane_1.revalidate();
					
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel_12.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.decode("#5BF4BD")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_12.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.decode("#5BF4BD")));
				}
			});
		
		
			lblNewLabel_12.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel_12.setBounds(15, 250, 119, 27);
			left_panel.add(lblNewLabel_12);
			
			JLabel lblNewLabel_11 = new JLabel("FASHION");
			lblNewLabel_11.setForeground(Color.decode("#42B088"));
			lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			lblNewLabel_11.setBounds(31, 35, 111, 38);
			left_panel.add(lblNewLabel_11);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setBounds(-14, 0, 189, 660);
			left_panel.add(lblNewLabel_8);
			lblNewLabel_8.setIcon(new ImageIcon(main_code .class.getResource("/image_home/Gro.png")));
			
			JLabel lblNewLabel_18 = new JLabel("New label");
			lblNewLabel_18.setBounds(35, 311, 46, 14);
			left_panel.add(lblNewLabel_18);
		  
		  
		  
		  
	}

}
