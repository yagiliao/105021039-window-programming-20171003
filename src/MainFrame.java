import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton jbtn1=new JButton("Ex");
    private JButton jbtn2=new JButton("Go");
    private JButton jbtn3=new JButton("Clean");
    private JButton jbtn4=new JButton("Exit");
    private JLabel jlb=new JLabel("Key");
    private JTextField jtfkey =new JTextField("3");
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jspL=new JScrollPane(jtaL);
    private JScrollPane jspR=new JScrollPane(jtaR);
    private JPanel jpn= new JPanel(new GridLayout(6,1,3,3));
    private int count = 0 ;
    public MainFrame() {
        initComp();
    }
    private void initComp() {
    this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jspL,BorderLayout.WEST);
        jtaL.setPreferredSize(new Dimension(200,400));
        jtaL.setLineWrap(true);
        cp.add(jspR,BorderLayout.EAST);
        jtaR.setPreferredSize(new Dimension(200,400));
        jtaR.setLineWrap(true);
        cp.add(jpn,BorderLayout.CENTER);
        jpn.add(jbtn1);
        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jtaL.setText("My favorite activity is playing basketball." +
                        "  I started playing when I was in elementary school." +
                        "  I began playing it because all the other boys in my neighborhood enjoyed it.\n" +
                        " \n" +
                        "Now I play basketball twice a week.  It is good for me both physically and mentally." +
                        "  Physically, it helps me maintain my strength and endurance and keep my weight down." +
                        "  Mentally, it provides me with an interesting challenge and is a good way to relieve any " +
                        "frustrations which I have from school.  I really love basketball.");
            }
        });

        jpn.add(jbtn2);

        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char data[] = jtaL.getText().toCharArray();
                int len = data.length , key=Integer.parseInt(jtfkey.getText());
                for(int i=0 ; i<len ; i++){
                    data[i]+= key;
                }
                jtaR.setText(new String(data));
            }
        });

        jpn.add(jlb);
        jpn.add(jtfkey);
        jpn.add(jbtn3);

        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jtaR.setText("");
                jtaL.setText("");
            }
        });

        jpn.add(jbtn4);

        jbtn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

}
