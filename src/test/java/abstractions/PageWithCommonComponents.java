package abstractions;

import elements.Sidebar;
import elements.Toolbar;

public abstract class PageWithCommonComponents implements LoadablePage {
    protected Sidebar sidebar;
    protected Toolbar toolbar;

    public PageWithCommonComponents(){
        this.sidebar = new Sidebar();
        this.toolbar = new Toolbar();
    }

    public Sidebar getSidebar(){
        return sidebar;
    }

    public Toolbar getToolbar(){
        return toolbar;
    }
}
