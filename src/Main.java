import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
    NorthPanel() {
        setLayout(new GridLayout(1,2,50,0));
        setPreferredSize(new Dimension(100,120));
//        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray));
        add(getLeftPanel());
        add(getRightPanel());
    }
    private JPanel getLeftPanel() {
        JPanel left = new JPanel();
        JTextField fileFormat = new JTextField();
        JTextField location = new JTextField();
        fileFormat.setPreferredSize(new Dimension(200,5));
        location.setPreferredSize(new Dimension(200,5));
        left.setLayout(new GridLayout(5,1));
        left.add(new JLabel("File Format"));
        left.add(fileFormat);
        left.add(new JLabel("Destination"));
        left.add(location);
        return left;
    }

    private JPanel getRightPanel() {
        JPanel right = new JPanel();
        JPanel p1 = new JPanel();
        JTextField location = new JTextField();
        ButtonGroup groupRadio = new ButtonGroup();
        JCheckBox specificLoc = new JCheckBox("Specific Location");
        JRadioButton file = new JRadioButton("File");
        JRadioButton date = new JRadioButton("Date");
        right.setLayout(new GridLayout(5,1));
        p1.setLayout(new GridLayout(1,3,20,0));
        p1.add(file);
        p1.add(new JButton("Save"));
        p1.add(new JButton("Load"));
        right.add(specificLoc);
        right.add(location);
        right.add(date);
        right.add(p1);
        groupRadio.add(file);
        groupRadio.add(date);
        return right;
    }
}

class SouthPanel extends JPanel {
    SouthPanel() {
        setPreferredSize(new Dimension(100,30));
//        setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.lightGray));
        add(new JLabel("All rights reserved©"));
    }
}

class LeftPanel extends JPanel {
    LeftPanel() {
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};
        JList<String> list = new JList<>(week);
        list.setPreferredSize(new Dimension(330,600));
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setCellRenderer(getRenderer());
        list.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.lightGray));
//        setBackground(Color.green);
        add(list);
    }

    private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
                return listCellRendererComponent;
            }
        };
    }

}

class RightPanel extends JPanel {
    RightPanel() {
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};
        JList<String> list = new JList<>(week);
        list.setPreferredSize(new Dimension(330,600));
        list.setCellRenderer(getRenderer());
        list.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.lightGray));
//        setBackground(Color.magenta);
        add(list);
    }
    private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.lightGray));
                return listCellRendererComponent;
            }
        };
    }


}

class CenterPanel extends JPanel {
    JButton addButton,removeButton,removeAll,sort;
    JPanel p1,p2,p3;
    CenterPanel() {
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        removeAll = new JButton("Remove All");
        sort = new JButton("Sort");
        addButton.setPreferredSize(new Dimension(100,30));
        removeButton.setPreferredSize(new Dimension(100,30));
        removeAll.setPreferredSize(new Dimension(100,30));
        sort.setPreferredSize(new Dimension(100,30));
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        setLayout(new GridLayout(3,1,0,10));
        setPreferredSize(new Dimension(100,600));
        p1.add(addButton);
        p2.add(removeButton);
        p2.add(removeAll);
        p3.add(sort);
        add(p1);
        add(p2);
        add(p3);
    }
}

class Window extends JFrame {
    Window() {
        setSize(800,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("File Sorter");
        setLayout(new BorderLayout());

        add(new NorthPanel(),BorderLayout.NORTH);
        add(new SouthPanel(),BorderLayout.SOUTH );
        add(new LeftPanel(),BorderLayout.WEST);
        add(new RightPanel(),BorderLayout.EAST);
        add(new CenterPanel(),BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        new Window();
    }
}