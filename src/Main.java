import controll.Menu;
import input.MyScanner;
import model.HomeAppliances;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        HomeAppliances homeAppliances = HomeAppliances.INSTANCE;
        MyScanner scanner = new MyScanner();
        Menu menu = new Menu(menuView,homeAppliances,scanner);
        menu.run();
    }
}
