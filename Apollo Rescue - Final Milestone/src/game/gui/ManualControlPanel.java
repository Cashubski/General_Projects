//package game;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ManualControlPanel extends JPanel {
//    public ManualControlPanel(){
//        JPanel section1 = new JPanel();
//        JButton section1MainButton = new JButton("Menu");
//
//        JPanel section1Contents = new JPanel();
//        JLabel section1Label = new JLabel("Sec1");
//        JButton section1Button = new JButton("Menu");
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(section1);
//
//        section1.setLayout(new BoxLayout(section1, BoxLayout.Y_AXIS));
//        section1.add(section1MainButton);
//        section1.add(section1Contents);
//
//        section1Contents.setLayout(new BoxLayout(section1Contents, BoxLayout.Y_AXIS));
//        section1Contents.add(section1Label);
//        section1Contents.add(section1Button);
//
//        section1MainButton.addActionListener(new ActionListener() {
//            private boolean visible = true;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (visible){
//                    section1.remove(section1Contents);
//                    visible = false;
//                    revalidate();
//                }
//                else {
//                    section1.add(section1Contents);
//                    visible = true;
//                    revalidate();
//                }
//            }
//        }
//        );
//        JPanel section2 = new JPanel();
//        JButton section2MainButton = new JButton("Options");
//
//        JPanel section2Contents = new JPanel();
//        JLabel section2Label = new JLabel("Sec2");
//        JButton section2Button = new JButton("Menu");
//
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(section2);
//
//        section2.setLayout(new BoxLayout(section2, BoxLayout.Y_AXIS));
//        section2.add(section2MainButton);
//        section2.add(section2Contents);
//
//        section2Contents.setLayout(new BoxLayout(section2Contents, BoxLayout.Y_AXIS));
//        section2Contents.add(section2Label);
//        section2Contents.add(section2Button);
//
//        section2MainButton.addActionListener(new ActionListener() {
//            private boolean visible = true;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (visible){
//                    section2.remove(section2Contents);
//                    visible = false;
//                    revalidate();
//                }
//                else {
//                    section2.add(section2Contents);
//                    visible = true;
//                    revalidate();
//                }
//            }
//        }
//        );
//
//    }
//}
