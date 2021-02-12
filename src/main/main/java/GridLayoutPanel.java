import java.awt.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class GridLayoutPanel extends JPanel {
    /**
     * We can't use "components" as the property name,
     * because it conflicts with an existing property
     * on the Component superclass.
     */
    private List panelComponents;
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {
        setLayout(new GridLayout(height,width));

        for (Iterator iter = panelComponents.iterator();
             iter.hasNext();) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
}
