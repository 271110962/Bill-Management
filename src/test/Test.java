package test;

import javax.swing.JButton;
import javax.swing.JPanel;
  
import util.GUIUtil;
  
public class Test {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        JPanel p = new JPanel();
        p.add(new JButton("按钮1"));
        p.add(new JButton("按钮2"));
        GUIUtil.showPanel(p);
    }
}