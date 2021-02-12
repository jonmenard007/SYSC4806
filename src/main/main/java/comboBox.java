import javax.swing.*;


public class comboBox extends JComboBox<String> {

    private String text;

    public void init() {

    }

    @Override
    public void addItem(String text) {
        super.addItem(text);
    }

    public void setText(String text) {
        this.text = text;
        super.addItem(text);
    }
}