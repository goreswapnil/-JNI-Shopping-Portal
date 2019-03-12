import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class App
{
    	public static native int calcBill(int[] params);
	
	static
	{
	   System.loadLibrary("calc");
	}
	public static void main(String args[])
	{
		MarvellousLogin mf = new MarvellousLogin();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}

class AppFrame extends Frame
{
	public static final int DEFAULT_WIDTH = 500; 							  		public static final int DEFAULT_HEIGHT = 600;

	private Hashtable<String,Integer> processors;
	private Hashtable<String,Integer> ram;
	private Hashtable<String,Integer> graphicsCard;
        private Hashtable<String,Integer> harddisk;
        private Hashtable<String,Integer> monitor;
	private Hashtable<String,Integer> cabinet;
	JLabel resultLabel2;

	public AppFrame()
	{
		setTitle("Marvellous Computer Shopping Portal");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setLayout(new GridLayout(8,2));

		processors = new Hashtable<String,Integer>();
		processors.put("i3",10000);
		processors.put("i5",15000);
		processors.put("i7",20000);
		processors.put("--",00);

		JPanel panel1 = new JPanel();
		JLabel processorLabel = new JLabel("Select Processor :");
		panel1.add(processorLabel);

		JPanel panel2 = new JPanel();
		Set<String> processorKeys = processors.keySet();
		JComboBox processorComboBox =new JComboBox(processorKeys.toArray());
		panel2.add(processorComboBox);

		ram = new Hashtable<String,Integer>();
		ram.put("4 GB",5000);
		ram.put("2 GB",3000);
		ram.put("--",00);
		ram.put("8 GB",8000);

		JPanel panel3 = new JPanel();
                JLabel ramLabel = new JLabel("Select RAM :");
                panel3.add(ramLabel);

                JPanel panel4 = new JPanel();
                Set<String> ramKeys = ram.keySet();
                JComboBox ramComboBox =new JComboBox(ramKeys.toArray());
		panel4.add(ramComboBox);

		graphicsCard = new Hashtable<String,Integer>();
		graphicsCard.put("4 GB",5000);
		graphicsCard.put("--",00);
               	graphicsCard.put("2 GB",3000);
                graphicsCard.put("8 GB",8000);

                JPanel panel5 = new JPanel();
                JLabel graphicsCardLabel = new JLabel("Select Graphics Card :");
                panel5.add(graphicsCardLabel);

                JPanel panel6 = new JPanel();
                Set<String> graphicsCardKeys = graphicsCard.keySet();
                JComboBox graphicsCardComboBox =new JComboBox(graphicsCardKeys.toArray());
                panel6.add(graphicsCardComboBox);

	        harddisk = new Hashtable<String,Integer>();
		harddisk.put("--",00);
                harddisk.put("1 TB",5000);
		harddisk.put("500GB",2500);                
                harddisk.put("2 TB",6500);

                JPanel panel11 = new JPanel();
                JLabel harddiskLabel = new JLabel("Select HardDisk :");
                panel11.add(harddiskLabel);

                JPanel panel12 = new JPanel();
                Set<String> harddiskKeys = harddisk.keySet();
                JComboBox harddiskComboBox =new JComboBox(harddiskKeys.toArray());
                panel12.add(harddiskComboBox);

                monitor = new Hashtable<String,Integer>();
		monitor.put("--",00);
                monitor.put("21.5inch LED",7800);
                monitor.put("20.0inch LCD",5000);
                monitor.put("23.6inch LED",10200);
		monitor.put("15.1inch LCD",2780);

                JPanel panel13 = new JPanel();
                JLabel monitorLabel = new JLabel("Select Monitor :");
                panel13.add(monitorLabel);

                JPanel panel14 = new JPanel();
                Set<String> monitorKeys = monitor.keySet();
                JComboBox monitorComboBox =new JComboBox(monitorKeys.toArray());
                panel14.add(monitorComboBox);

		cabinet = new Hashtable<String,Integer>();
		cabinet.put("--",00);
		cabinet.put("Chiptronix",2099);
		cabinet.put("BBC",2799);
	
		JPanel panel15 = new JPanel();
		JLabel cabinetLabel = new JLabel("Select CPU Cabinet :");
		panel15.add(cabinetLabel);

		JPanel panel16 = new JPanel();
		Set<String> cabinetKeys = cabinet.keySet();
		JComboBox cabinetComboBox = new JComboBox(cabinetKeys.toArray());
		panel16.add(cabinetComboBox);		

  		JPanel panel7 =new JPanel();
		JButton calculateButton = new JButton("Calculate Bill");
		calculateButton.addActionListener(new ActionListener()
		{
		   public void actionPerformed(ActionEvent evet)
	            {
			int processorPrice = processors.get((String)processorComboBox.getSelectedItem());
			int ramPrice = ram.get((String)ramComboBox.getSelectedItem());
		int graphicsCardPrice = graphicsCard.get((String)graphicsCardComboBox.getSelectedItem());
			int harddiskPrice = harddisk.get((String)harddiskComboBox.getSelectedItem());
			int monitorPrice = monitor.get((String)monitorComboBox.getSelectedItem());
			int cabinetPrice = cabinet.get((String)cabinetComboBox.getSelectedItem());
			int params[] = new int[6];
			params[0] = processorPrice;
			params[1] = ramPrice;
			params[2] = graphicsCardPrice;
			params[3] = harddiskPrice;
			params[4] = monitorPrice;
			params[5] = cabinetPrice;

			int result = App.calcBill(params);
			resultLabel2.setText(""+result);
		    }
	       });

		panel7.add(calculateButton);
		JPanel panel8 = new JPanel();

		JPanel panel9 = new JPanel();
		JLabel resultLabel = new JLabel("Your estimated amount:");
		panel9.add(resultLabel);

		JPanel panel10 = new JPanel();
		resultLabel2 = new JLabel("");
		panel10.add(resultLabel2);
		
		add(panel1);
                add(panel2);
                add(panel3);
                add(panel4);
                add(panel5);
                add(panel6);
		add(panel11);
		add(panel12);
		add(panel13);
		add(panel14);
		add(panel15);
		add(panel16);
                add(panel7);
                add(panel8);
                add(panel9);
                add(panel10);
	}
}

class MarvellousLogin extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField tf1;
	JPasswordField tf2;
	JButton b;
	public static int Cnt=3;

    public MarvellousLogin()
{
super("Marvellous E Shopping Portal");
setContentPane(new JLabel(new ImageIcon("/home/swapnil/Desktop/Project/MarvellousLogo.jpg")));

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

l1=new JLabel("Username");
l1.setBounds(50,70,150,20);

tf1 = new JTextField();
tf1.setBounds(50,100,200,20);
tf1.setToolTipText("Enter your username");

l2 = new JLabel("Password");
l2.setBounds(50,130,150,20);

tf2 = new JPasswordField();
tf2.setBounds(50,160,200,20);
tf2.setToolTipText("Enter your password");

b = new JButton("Login");
b.setBounds(90,200,80,30);

b.addActionListener(this);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(b);

setSize(300,300);
setLayout(null);
setVisible(true);
}


public void actionPerformed(ActionEvent e)
{
String username = tf1.getText();
String password = tf2.getText();

if((username.equals("admin")) && (password.equals("admin123")))
{
AppFrame af = new AppFrame();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
af.setVisible(true);
dispose();
}
else
{
--Cnt;

if(Cnt == 0)
{
JOptionPane.showMessageDialog(this,"Number of attempts finished. ");
dispose();
}
else
{
JOptionPane.showMessageDialog(this,"Marvellous AUthentication failed.");
tf1.setText("");
tf2.setText("");
}
}
}
}

