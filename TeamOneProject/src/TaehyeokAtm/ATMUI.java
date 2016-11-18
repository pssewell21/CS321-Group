/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ATMUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTabbedPane jTabbedPane = null;

	private JPanel jPanel1 = null;
	
	private JPanel jPanel2 = null;

	private JPanel jPanel3 = null;

	private JPanel jPanel4 = null;

	private JPanel jPanel5 = null;

	private JPanel jPanel6 = null;

	private JLabel jLabel2 = null;

	private JTextField jTextField_openac_salary = null;

	private JTextField jTextField_openac_balance = null;

	private JLabel jLabel4 = null;

	private JComboBox jComboBox_openac_actype = null;

	private JTextField jTextField_openac_name = null;

	private JTextField jTextField_openac_peoplenumber = null;

	private JLabel jLabel7 = null;

	private JTextField jTextField_openac_phonenumber = null;

	private JTextField jTextField_openac_adress = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel_openac_acnumber = null;

	private JButton jButton_openac_btn = null;

	private JLabel jLabel9 = null;

	private JTextField jTextField_deposit_acnumber = null;

	private JTextField jTextField_deposit_trademoney = null;

	private JLabel jLabel10 = null;

	private JButton jdepositButton = null;

	private JLabel jLabel11 = null;

	private JTextField jTextField_drawing_acnumber = null;

	private JLabel jLabel12 = null;

	private JTextField jTextField_drawing_trademoney = null;

	private JButton jdrawingButton = null;

	private JLabel jLabel13 = null;

	private JTextField jTextField_inquirybalance_acnumber = null;

	private JLabel jLabel14 = null;

	private JLabel jLabel_inquirybalance_balance = null;

	private JButton jButton_inquirybalance = null;

	private JLabel jLabel16 = null;

	private JTextField jTextField_inquirytrade_acnumber = null;

	private JRadioButton jRadioButton = null;

	private JRadioButton jRadioButton1 = null;

	private JRadioButton jRadioButton2 = null;

	private JLabel jLabel17 = null;

	private JComboBox jComboBox1 = null;

	private JComboBox jComboBox2 = null;

	private JComboBox jComboBox3 = null;

	private JComboBox jComboBox4 = null;

	private JComboBox jComboBox5 = null;

	private JComboBox jComboBox6 = null;

	private JLabel jLabel18 = null;

	private JLabel jLabel19 = null;

	private JList jList_inquirytrade = null;

	private JButton jButton = null;

	private JLabel jLabel20 = null;

	private JLabel jLabel21 = null;

	private JLabel jLabel22 = null;

	private JButton jexitButton1 = null;
	
        private JButton jexitButton2 = null;
        
	private Accontrol acc = null;
	
	Trade td[];

	private JRadioButton jRadiobutton3 = null;
	
	ButtonGroup group = null;  //  @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public ATMUI() {
		super();
		initialize();
		acc = new Accontrol();
		timecheck();
	}
	
        
 
	private void timecheck() {
		try
		{
			boolean atmtime = acc.openATMTime();
////			if(!atmtime)
////			{
////				Calendar cal = Calendar.getInstance();
////				Date time = new Date(cal.getTimeInMillis());
////				JOptionPane.showMessageDialog(jPanel1,
////				"now " + time.toString() + " ." +
////				"not ATM working time.");
////				acc.saveacc();
////				System.exit(0);
////			}
////			else
////			{
////				
////			}
		}
		catch(Exception ex)
		{
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("ATM Demo");
             
                this.setBounds(new Rectangle(0, 0, 489, 308));
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				try
				{
					acc.saveacc();
					System.exit(0);
				}
				catch(Exception ex)
				{
				}
			}
		});
	}
	
    public class back extends JFrame {
         Image img = null;
 
        back(){
            
        try{
        File image = new File("/Users/taehyeoklee/Pictures/coms309.jpg");
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
         img = ImageIO.read(image);
        }
        catch(IOException e)
        {
        System.out.println("no");
        }


        }
    }
       
     
        
	public String showdetails(Trade td)
	{
		String type;
		if(td.getTradetype()) type = " Deposit";
		else type = " Withdraw";
		String details = "Date: ";
		long times = td.getTradedate();
		Date dt = new Date();
		dt.setTime(times);
		details = details.concat(dt.toString());
		details = details.concat(" Banlance: ");
		details = details.concat(String.valueOf(td.getBalance()));
		details = details.concat(type);
		details = details.concat("amount: ");
		details = details.concat(String.valueOf(td.getTrademoney()));
		return details; 
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setPreferredSize(new Dimension(600, 400));
			jContentPane.setName("ATM_Demo");
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setPreferredSize(new Dimension(9000, 380));
			jTabbedPane.addTab("ATM", null, getJPanel1(), null);
			jTabbedPane.addTab("Create", null, getJPanel2(), null);
			jTabbedPane.addTab("Deposit", null, getJPanel3(), null);
			jTabbedPane.addTab("Withdraw", null, getJPanel4(), null);
			jTabbedPane.addTab("Check balance", null, getJPanel5(), null);
			jTabbedPane.addTab("Trans", null, getJPanel6(), null);
			jTabbedPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					//if ((e.getPropertyName().equals("tabPlacement"))) {
						//timecheck();// TODO Auto-generated property Event stub "tabPlacement" 
					//}
				}
			});
		}
		return jTabbedPane;
	}

        
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
                        GridBagConstraints gridBagConstraints510 = new GridBagConstraints();
			gridBagConstraints510.gridx = 2;
			gridBagConstraints510.gridy = 1;
			GridBagConstraints gridBagConstraints410 = new GridBagConstraints();
			gridBagConstraints410.gridx = 2;
			gridBagConstraints410.gridy = 2;
			GridBagConstraints gridBagConstraints310 = new GridBagConstraints();
			gridBagConstraints310.gridx = 1;
			gridBagConstraints310.gridy = 1;
			jLabel22 = new JLabel();
			jLabel22.setText("");
			jLabel22.setPreferredSize(new Dimension(80, 18));
			GridBagConstraints gridBagConstraints210 = new GridBagConstraints();
			gridBagConstraints210.gridx = 2;
			gridBagConstraints210.gridy = 0;
			jLabel21 = new JLabel();
			jLabel21.setText(" login");
			jLabel21.setPreferredSize(new Dimension(150, 30));
			GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
			gridBagConstraints110.gridx = 0;
			gridBagConstraints110.gridy = 0;
			jLabel20 = new JLabel();
			jLabel20.setText("ATM ");
			jLabel20.setPreferredSize(new Dimension(100, 30));
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(jLabel20, gridBagConstraints110);
			jPanel1.add(jLabel21, gridBagConstraints210);
			jPanel1.add(jLabel22, gridBagConstraints310);
			jPanel1.add(getJexitButton1(), gridBagConstraints410);
                        jPanel1.add(getJexitButton2(), gridBagConstraints510);
                        


		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 2;
			gridBagConstraints17.gridy = 11;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 4;
			gridBagConstraints15.gridy = 1;
			jLabel_openac_acnumber = new JLabel();
			jLabel_openac_acnumber.setText("");
			jLabel_openac_acnumber.setPreferredSize(new Dimension(150, 20));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.gridy = 8;
			jLabel1 = new JLabel();
			jLabel1.setText("Celphone");
			jLabel1.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.gridy = 1;
			jLabel = new JLabel();
			jLabel.setText("Acc num");
			jLabel.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints16.gridy = 9;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.gridx = 4;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints14.gridy = 8;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridx = 4;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 2;
			gridBagConstraints13.gridy = 9;
			jLabel7 = new JLabel();
			jLabel7.setText("Addr");
			jLabel7.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints12.gridy = 7;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridx = 4;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 2;
			gridBagConstraints11.gridy = 7;
			JLabel jLabel6 = new JLabel();
			jLabel6.setText("SSN");
			jLabel6.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints10.gridy = 6;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.gridx = 4;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 2;
			gridBagConstraints9.gridy = 6;
			JLabel jLabel5 = new JLabel();
			jLabel5.setText("Name");
			jLabel5.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints8.gridy = 10;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.gridx = 4;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.gridy = 10;
			jLabel4 = new JLabel();
			jLabel4.setText("Type");
			jLabel4.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints6.gridy = 4;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.gridy = 4;
			JLabel jLabel3 = new JLabel();
			jLabel3.setText("Deposit ");
			jLabel3.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridx = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 3;
			jLabel2 = new JLabel();
			jLabel2.setText("ID");
			jLabel2.setPreferredSize(new Dimension(100, 20));
			((JLabel) jLabel).setText("Acc num");
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setPreferredSize(new Dimension(400, 300));
			jPanel2.add(jLabel2, gridBagConstraints3);
			jPanel2.add(getJTextField_openac_salary(), gridBagConstraints4);
			jPanel2.add(jLabel3, gridBagConstraints5);
			jPanel2.add(getJTextField_openac_balance(), gridBagConstraints6);
			jPanel2.add(jLabel4, gridBagConstraints7);
			jPanel2.add(getJComboBox_openac_actype(), gridBagConstraints8);
			jPanel2.add(jLabel5, gridBagConstraints9);
			jPanel2.add(getJTextField_openac_name(), gridBagConstraints10);
			jPanel2.add(jLabel6, gridBagConstraints11);
			jPanel2.add(getJTextField_openac_peoplenumber(), gridBagConstraints12);
			jPanel2.add(jLabel7, gridBagConstraints13);
			jPanel2.add(getJTextField_openac_phonenumber(), gridBagConstraints14);
			jPanel2.add(getJTextField_openac_adress(), gridBagConstraints16);
			jPanel2.add(jLabel, gridBagConstraints1);
			jPanel2.add(jLabel1, gridBagConstraints2);
			jPanel2.add(jLabel_openac_acnumber, gridBagConstraints15);
			jPanel2.add(getJButton_openac_btn(), gridBagConstraints17);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 1;
			gridBagConstraints22.gridy = 2;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 1;
			jLabel10 = new JLabel();
			jLabel10.setText("Deposit");
			jLabel10.setPreferredSize(new Dimension(100, 25));
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints20.gridy = 1;
			gridBagConstraints20.weightx = 1.0;
			gridBagConstraints20.gridx = 1;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints19.gridy = 0;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 0;
			jLabel9 = new JLabel();
			jLabel9.setText("Acc num");
			jLabel9.setPreferredSize(new Dimension(100, 25));
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.add(jLabel9, gridBagConstraints18);
			jPanel3.add(getJTextField_deposit_acnumber(), gridBagConstraints19);
			jPanel3.add(getJTextField_deposit_trademoney(), gridBagConstraints20);
			jPanel3.add(jLabel10, gridBagConstraints21);
			jPanel3.add(getJdepositButton(), gridBagConstraints22);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 1;
			gridBagConstraints27.gridy = 2;
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints26.gridy = 1;
			gridBagConstraints26.weightx = 1.0;
			gridBagConstraints26.gridx = 1;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 0;
			gridBagConstraints25.gridy = 1;
			jLabel12 = new JLabel();
			jLabel12.setText("Withdraw");
			jLabel12.setPreferredSize(new Dimension(100, 25));
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints24.gridy = 0;
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.gridx = 1;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 0;
			gridBagConstraints23.gridy = 0;
			jLabel11 = new JLabel();
			jLabel11.setText("Acc num");
			jLabel11.setPreferredSize(new Dimension(100, 25));
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.add(jLabel11, gridBagConstraints23);
			jPanel4.add(getJTextField_drawing_acnumber(), gridBagConstraints24);
			jPanel4.add(jLabel12, gridBagConstraints25);
			jPanel4.add(getJTextField_drawing_trademoney(), gridBagConstraints26);
			jPanel4.add(getJdrawingButton(), gridBagConstraints27);
		}
		return jPanel4;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 1;
			gridBagConstraints32.gridy = 2;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.gridy = 1;
			jLabel_inquirybalance_balance = new JLabel();
			jLabel_inquirybalance_balance.setText("");
			jLabel_inquirybalance_balance.setPreferredSize(new Dimension(150, 25));
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.gridx = 0;
			gridBagConstraints30.gridy = 1;
			jLabel14 = new JLabel();
			jLabel14.setText("balance");
			jLabel14.setPreferredSize(new Dimension(100, 25));
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints29.gridy = 0;
			gridBagConstraints29.weightx = 1.0;
			gridBagConstraints29.gridx = 1;
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.gridy = 0;
			jLabel13 = new JLabel();
			jLabel13.setText("Acc num");
			jLabel13.setPreferredSize(new Dimension(100, 25));
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GridBagLayout());
			jPanel5.add(jLabel13, gridBagConstraints28);
			jPanel5.add(getJTextField_inquirybalance_acnumber(), gridBagConstraints29);
			jPanel5.add(jLabel14, gridBagConstraints30);
			jPanel5.add(jLabel_inquirybalance_balance, gridBagConstraints31);
			jPanel5.add(getJButton_inquirybalance(), gridBagConstraints32);
		}
		return jPanel5;
	}

	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 7;
			gridBagConstraints.gridy = 1;
			GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
			gridBagConstraints49.gridx = 7;
			gridBagConstraints49.gridy = 3;
			GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
			gridBagConstraints48.fill = GridBagConstraints.BOTH;
			gridBagConstraints48.gridy = 4;
			gridBagConstraints48.weightx = 1.0;
			gridBagConstraints48.weighty = 1.0;
			gridBagConstraints48.gridwidth = 8;
			gridBagConstraints48.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints48.ipadx = 0;
			gridBagConstraints48.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints48.gridx = 0;
			GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
			gridBagConstraints47.gridx = 0;
			gridBagConstraints47.gridy = 3;
			jLabel19 = new JLabel();
			jLabel19.setText("end day");
			jLabel19.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
			gridBagConstraints46.gridx = 0;
			gridBagConstraints46.gridy = 2;
			jLabel18 = new JLabel();
			jLabel18.setText("start day");
			jLabel18.setPreferredSize(new Dimension(100, 20));
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints45.gridy = 3;
			gridBagConstraints45.weightx = 1.0;
			gridBagConstraints45.gridx = 5;
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints44.gridy = 3;
			gridBagConstraints44.weightx = 1.0;
			gridBagConstraints44.gridx = 4;
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints43.gridy = 3;
			gridBagConstraints43.weightx = 1.0;
			gridBagConstraints43.gridx = 3;
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints42.gridy = 2;
			gridBagConstraints42.weightx = 1.0;
			gridBagConstraints42.gridx = 5;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints41.gridy = 2;
			gridBagConstraints41.weightx = 1.0;
			gridBagConstraints41.gridx = 4;
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints40.gridy = 2;
			gridBagConstraints40.weightx = 1.0;
			gridBagConstraints40.gridx = 3;
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 0;
			gridBagConstraints38.gridy = 1;
			jLabel17 = new JLabel();
			jLabel17.setText("check period");
			jLabel17.setPreferredSize(new Dimension(100, 25));
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 5;
			gridBagConstraints37.gridy = 1;
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.gridx = 4;
			gridBagConstraints36.gridy = 1;
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 3;
			gridBagConstraints35.gridy = 1;
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints34.gridy = 0;
			gridBagConstraints34.weightx = 1.0;
			gridBagConstraints34.gridx = 7;
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 0;
			gridBagConstraints33.gridy = 0;
			jLabel16 = new JLabel();
			jLabel16.setText("Acc num");
			jLabel16.setPreferredSize(new Dimension(100, 25));
			jPanel6 = new JPanel();
			jPanel6.setLayout(new GridBagLayout());
			jPanel6.setPreferredSize(new Dimension(500, 91));
			jPanel6.setName("systems");
			jPanel6.add(jLabel16, gridBagConstraints33);
			jPanel6.add(getJTextField_inquirytrade_acnumber(), gridBagConstraints34);
			group = new ButtonGroup();
			jPanel6.add(getJRadioButton(), gridBagConstraints35);
			jPanel6.add(getJRadioButton1(), gridBagConstraints36);
			jPanel6.add(getJRadioButton2(), gridBagConstraints37);
			jPanel6.add(jLabel17, gridBagConstraints38);
			jPanel6.add(getJComboBox1(), gridBagConstraints40);
			jPanel6.add(getJComboBox2(), gridBagConstraints41);
			jPanel6.add(getJComboBox3(), gridBagConstraints42);
			jPanel6.add(getJComboBox4(), gridBagConstraints43);
			jPanel6.add(getJComboBox5(), gridBagConstraints44);
			jPanel6.add(getJComboBox6(), gridBagConstraints45);
			jPanel6.add(jLabel18, gridBagConstraints46);
			jPanel6.add(jLabel19, gridBagConstraints47);
			jPanel6.add(getJList_inquirytrade(), gridBagConstraints48);
			jPanel6.add(getJButton(), gridBagConstraints49);
			jPanel6.add(getJRadiobutton3(), gridBagConstraints);
		}
		return jPanel6;
	}

	/**
	 * This method initializes jTextField_openac_salary	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_salary() {
		if (jTextField_openac_salary == null) {
			jTextField_openac_salary = new JTextField();
			jTextField_openac_salary.setText("");
			jTextField_openac_salary.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_salary;
	}

	/**
	 * This method initializes jTextField_openac_balance	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_balance() {
		if (jTextField_openac_balance == null) {
			jTextField_openac_balance = new JTextField();
			jTextField_openac_balance.setText("");
			jTextField_openac_balance.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_balance;
	}

	/**
	 * This method initializes jComboBox_openac_actype	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_openac_actype() {
		if (jComboBox_openac_actype == null) {
			jComboBox_openac_actype = new JComboBox();
			jComboBox_openac_actype.setPreferredSize(new Dimension(150, 20));
			jComboBox_openac_actype.addItem("Check");
			jComboBox_openac_actype.addItem("Saving");
		}
		return jComboBox_openac_actype;
	}

	/**
	 * This method initializes jTextField_openac_name	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_name() {
		if (jTextField_openac_name == null) {
			jTextField_openac_name = new JTextField();
			jTextField_openac_name.setText("");
			jTextField_openac_name.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_name;
	}

	/**
	 * This method initializes jTextField_openac_peoplenumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_peoplenumber() {
		if (jTextField_openac_peoplenumber == null) {
			jTextField_openac_peoplenumber = new JTextField();
			jTextField_openac_peoplenumber.setText("");
			jTextField_openac_peoplenumber.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_peoplenumber;
	}

	/**
	 * This method initializes jTextField_openac_phonenumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_phonenumber() {
		if (jTextField_openac_phonenumber == null) {
			jTextField_openac_phonenumber = new JTextField();
			jTextField_openac_phonenumber.setText("");
			jTextField_openac_phonenumber.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_phonenumber;
	}

	/**
	 * This method initializes jTextField_openac_adress	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_openac_adress() {
		if (jTextField_openac_adress == null) {
			jTextField_openac_adress = new JTextField();
			jTextField_openac_adress.setText("");
			jTextField_openac_adress.setPreferredSize(new Dimension(150, 20));
		}
		return jTextField_openac_adress;
	}

	/**
	 * This method initializes jButton_openac_btn	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_openac_btn() {
		if (jButton_openac_btn == null) {
			jButton_openac_btn = new JButton();
			jButton_openac_btn.setPreferredSize(new Dimension(120, 30));
			jButton_openac_btn.setText("Create");
			jButton_openac_btn.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					timecheck();
					try{
						long salary = Long.parseLong(jTextField_openac_salary.getText());
						long balance = Long.parseLong(jTextField_openac_balance.getText());
						String name = jTextField_openac_name.getText();
						String peoplenumber = jTextField_openac_peoplenumber.getText();
						String adress = jTextField_openac_adress.getText();
						String phonenumber = jTextField_openac_phonenumber.getText();
						boolean accounttype = false;
						if(jComboBox_openac_actype.getSelectedItem().equals("Checking")) accounttype = false;
						long acnum = acc.openAccount(salary, balance, accounttype, name, peoplenumber, adress, phonenumber);
						if (acnum != -1)
						{
							jLabel_openac_acnumber.setText(String.valueOf(acnum));
							JOptionPane.showMessageDialog(jPanel2," create acc."
									+"created acc num is " + acnum + " ." );
						}
						else
						{
							JOptionPane.showMessageDialog(jPanel2," error."
									+"check inputs." );
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(jPanel2," fail to create acc."
								+"check inputs." );
					}
				}
			});
		}
		return jButton_openac_btn;
	}

	/**
	 * This method initializes jTextField_deposit_acnumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_deposit_acnumber() {
		if (jTextField_deposit_acnumber == null) {
			jTextField_deposit_acnumber = new JTextField();
			jTextField_deposit_acnumber.setPreferredSize(new Dimension(150, 25));
		}
		return jTextField_deposit_acnumber;
	}

	/**
	 * This method initializes jTextField_deposit_trademoney	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_deposit_trademoney() {
		if (jTextField_deposit_trademoney == null) {
			jTextField_deposit_trademoney = new JTextField();
			jTextField_deposit_trademoney.setText("");
			jTextField_deposit_trademoney.setPreferredSize(new Dimension(150, 25));
		}
		return jTextField_deposit_trademoney;
	}

	/**
	 * This method initializes jdepositButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJdepositButton() {
		if (jdepositButton == null) {
			jdepositButton = new JButton();
			jdepositButton.setText("Deposit");
			jdepositButton.setPreferredSize(new Dimension(120, 30));
			jdepositButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						timecheck();
						
						long acnumber =Long.parseLong( jTextField_deposit_acnumber.getText());
						long trademoney = Long.parseLong(jTextField_deposit_trademoney.getText());
					
						boolean state = acc.deposit(acnumber, trademoney);
						if(state)
						{
							JOptionPane.showMessageDialog(jPanel3,"succ."
									+"current balance" + acc.inquiryBalance(acnumber) + "." );
						}
						else
						{
							JOptionPane.showMessageDialog(jPanel3,"fail."
									+"current balance " + acc.inquiryBalance(acnumber) + "." );
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(jPanel3,"input error."
								+"type again." );
					}
				}
			});
		}
		return jdepositButton;
	}

	/**
	 * This method initializes jTextField_drawing_acnumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_drawing_acnumber() {
		if (jTextField_drawing_acnumber == null) {
			jTextField_drawing_acnumber = new JTextField();
			jTextField_drawing_acnumber.setPreferredSize(new Dimension(150, 25));
		}
		return jTextField_drawing_acnumber;
	}

	/**
	 * This method initializes jTextField_drawing_trademoney	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_drawing_trademoney() {
		if (jTextField_drawing_trademoney == null) {
			jTextField_drawing_trademoney = new JTextField();
			jTextField_drawing_trademoney.setPreferredSize(new Dimension(150, 25));
		}
		return jTextField_drawing_trademoney;
	}

	/**
	 * This method initializes jdrawingButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJdrawingButton() {
		if (jdrawingButton == null) {
			jdrawingButton = new JButton();
			jdrawingButton.setText("Withdraw");
			jdrawingButton.setPreferredSize(new Dimension(120, 30));
			jdrawingButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						timecheck();
						
						long acnumber =Long.parseLong( jTextField_drawing_acnumber.getText());
						long trademoney = Long.parseLong(jTextField_drawing_trademoney.getText());
					
						boolean state = acc.drawing(acnumber, trademoney);
						if(state)
						{
							JOptionPane.showMessageDialog(jPanel4,"succ."
									+"balance" + acc.inquiryBalance(acnumber) + "." );
						}
						else
						{
							JOptionPane.showMessageDialog(jPanel4,"fail."
									+"balance " + acc.inquiryBalance(acnumber) + "." );
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(jPanel4,"input error."
								+"type again." );
					}
				}
			});
		}
		return jdrawingButton;
	}

	/**
	 * This method initializes jTextField_inquirybalance_acnumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_inquirybalance_acnumber() {
		if (jTextField_inquirybalance_acnumber == null) {
			jTextField_inquirybalance_acnumber = new JTextField();
			jTextField_inquirybalance_acnumber.setPreferredSize(new Dimension(150, 25));
		}
		return jTextField_inquirybalance_acnumber;
	}

	/**
	 * This method initializes jButton_inquirybalance	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_inquirybalance() {
		if (jButton_inquirybalance == null) {
			jButton_inquirybalance = new JButton();
			jButton_inquirybalance.setText("balance");
			jButton_inquirybalance.setPreferredSize(new Dimension(120, 30));
			jButton_inquirybalance.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						timecheck();
						
						long acnumber =Long.parseLong( jTextField_inquirybalance_acnumber.getText());
						
						long balance = acc.inquiryBalance(acnumber);
						if(balance == -1)
						{
							JOptionPane.showMessageDialog(jPanel3,"fail to check balance."
									+"check acc num." );
						}
						else
						{
							jLabel_inquirybalance_balance.setText(String.valueOf(balance));
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(jPanel5,"input erro check acc num."
								+"enter again." );
					}
				}
			});
		}
		return jButton_inquirybalance;
	}

	/**
	 * This method initializes jTextField_inquirytrade_acnumber	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_inquirytrade_acnumber() {
		if (jTextField_inquirytrade_acnumber == null) {
			jTextField_inquirytrade_acnumber = new JTextField();
			jTextField_inquirytrade_acnumber.setPreferredSize(new Dimension(120, 25));
		}
		return jTextField_inquirytrade_acnumber;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setName("");
			jRadioButton.setText("1d");
			jRadioButton.setActionCommand("1d");
			jRadioButton.setSelected(true);
			group.add(jRadioButton);
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("1y");
			jRadioButton1.setActionCommand("1y");
			group.add(jRadioButton1);
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("1m");
			jRadioButton2.setActionCommand("1m");
			group.add(jRadioButton2);
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			for (int i=1970;i<2030;i++)
			{
				jComboBox1.addItem(String.valueOf(i));
			}
			jComboBox1.setPreferredSize(new Dimension(60, 20));
			jComboBox1.setToolTipText("year");
			jComboBox1.setName("start y");
		}
		return jComboBox1;
	}

	/**
	 * This method initializes jComboBox2	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			for (int i=1;i<13;i++)
			{
				jComboBox2.addItem(String.valueOf(i));
			}
			jComboBox2.setPreferredSize(new Dimension(40, 20));
			jComboBox2.setToolTipText("start m");
		}
		return jComboBox2;
	}

	/**
	 * This method initializes jComboBox3	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox3() {
		if (jComboBox3 == null) {
			jComboBox3 = new JComboBox();
			jComboBox3.setPreferredSize(new Dimension(40, 20));
			for (int i=1;i<32;i++)
			{
				jComboBox3.addItem(String.valueOf(i));
			}
			jComboBox3.setToolTipText("Start d");
		}
		return jComboBox3;
	}

	/**
	 * This method initializes jComboBox4	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox4() {
		if (jComboBox4 == null) {
			jComboBox4 = new JComboBox();
			jComboBox4.setPreferredSize(new Dimension(60, 20));
			for (int i=1970;i<2030;i++)
			{
				jComboBox4.addItem(String.valueOf(i));
			}
			jComboBox4.setToolTipText("End year");
		}
		return jComboBox4;
	}

	/**
	 * This method initializes jComboBox5	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox5() {
		if (jComboBox5 == null) {
			jComboBox5 = new JComboBox();
			jComboBox5.setPreferredSize(new Dimension(40, 20));
			for (int i=1;i<13;i++)
			{
				jComboBox5.addItem(String.valueOf(i));
			}
			jComboBox5.setToolTipText("End month");
		}
		return jComboBox5;
	}

	/**
	 * This method initializes jComboBox6	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox6() {
		if (jComboBox6 == null) {
			jComboBox6 = new JComboBox();
			jComboBox6.setPreferredSize(new Dimension(40, 20));
			for (int i=1;i<32;i++)
			{
				jComboBox6.addItem(String.valueOf(i));
			}
			jComboBox6.setToolTipText("End day");
		}
		return jComboBox6;
	}

	/**
	 * This method initializes jList_inquirytrade	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_inquirytrade() {
		if (jList_inquirytrade == null) {
			jList_inquirytrade = new JList();
		}
		return jList_inquirytrade;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setPreferredSize(new Dimension(200, 20));
			jButton.setText("transactional information");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						timecheck();
						
						String command = group.getSelection().getActionCommand();
						Calendar lastday = Calendar.getInstance();
						Calendar startday = Calendar.getInstance();
						if(command.equals("1d")) startday.roll(Calendar.DATE, false);
						else if(command.equals("1y")) startday.roll(Calendar.DATE, -7);
						else if(command.equals("1m")) startday.roll(Calendar.MONTH , false);
						else
						{
							startday.set(Integer.parseInt((String)jComboBox1.getSelectedItem()),jComboBox2.getSelectedIndex(),jComboBox3.getSelectedIndex()+1);
							lastday.set(Integer.parseInt((String)jComboBox4.getSelectedItem()),jComboBox5.getSelectedIndex(),jComboBox6.getSelectedIndex()+1);
						}
						//Date time = startday.getTime();
						//System.out.println(time.toString());
						long acnumber = Long.parseLong(jTextField_inquirytrade_acnumber.getText());
						int size = acc.findDetailsnum(acnumber,startday.getTimeInMillis(),lastday.getTimeInMillis());
						td = new Trade[size];
						td = acc.inquiryDetails(acnumber,startday.getTimeInMillis(),lastday.getTimeInMillis());
						String detail[] = new String[size];
						for(int i=0;i<size;i++) detail[i] = showdetails(td[i]);
						jList_inquirytrade.setListData(detail);
					}
					catch(Exception ex)
					{
						
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jexitButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJexitButton1() {
		if (jexitButton1 == null) {
			jexitButton1 = new JButton();
			jexitButton1.setText("Quit ATM");
			jexitButton1.setPreferredSize(new Dimension(120, 30));
			jexitButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						int n = JOptionPane.showConfirmDialog(jPanel1,
			                       "Quit ATM?","RI?",
			                       JOptionPane.OK_CANCEL_OPTION );
						if (n == JOptionPane.YES_OPTION) {
							acc.saveacc();
							System.exit(0);
						}
			            else 
			            {
			         
			            }
					}
					catch(Exception ex)
					{
					}
				}
			});
		}
		return jexitButton1;
	}

        private JButton getJexitButton2()
	{
		if (jexitButton2 == null) {
			jexitButton2 = new JButton();
			jexitButton2.setText("loggin");
			jexitButton2.setPreferredSize(new Dimension(120, 30));
			jexitButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						int n = JOptionPane.showConfirmDialog(jPanel1,
			                       "Quit ATM?","RI?",
			                       JOptionPane.OK_CANCEL_OPTION );
						if (n == JOptionPane.YES_OPTION) {
							acc.saveacc();
							System.exit(0);
						}
			            else 
			            {
			         
			            }
					}
					catch(Exception ex)
					{
					}
				}
			});
		}
		return jexitButton2;
	}

	private JRadioButton getJRadiobutton3() {
		if (jRadiobutton3 == null) {
			jRadiobutton3 = new JRadioButton();
			jRadiobutton3.setPreferredSize(new Dimension(100, 20));
			jRadiobutton3.setText("input");
			jRadiobutton3.setActionCommand("input");
			group.add(jRadiobutton3);
		}
		return jRadiobutton3;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"

