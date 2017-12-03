package controll;

import input.MyScanner;
import model.*;
import model.entity.*;
import service.FilterAppliances;
import service.PowerComparator;
import view.MenuView;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu implements Patterns{
    private MenuView menuView;
    private HomeAppliances homeAppliances;
    private MyScanner scanner;
    private Comparator comparator;
    private FilterAppliances filterAppliances;
    private FileController fileController=new FileController();

    private boolean menu;

    private enum MenuOption{ADD_APPLIANCE, TURN_ON_APPLIANCES, TURN_OFF_APPLIANCES, FIND_POWER,
        SORT_APPLIANCES, FIND_APPLIANCE, SHOW_ALL, EXIT}
    private enum AddMenuOption{KITCHEN, CLEANER, VIDEO, COMPUTER}

    public Menu(MenuView menuView, HomeAppliances homeAppliances, MyScanner myScanner){
        this.menuView=menuView;
        this.homeAppliances=homeAppliances;
        this.scanner = myScanner;
        this.comparator = new PowerComparator();
        this.filterAppliances = new FilterAppliances();
    }

    public void run() {
        menu = true;
        fileController.loadFile(homeAppliances.getAllAppliances());
        while (menu) {
            menuView.showMenu();
            processInput(inputValue(MenuView.COMMAND, MAIN_MENU_PATTERN));
        }
    }

    private void processInput(String statement) {
        MenuOption menuOption = MenuOption.values()[Integer.parseInt(statement)-1];
        switch (menuOption) {
            case ADD_APPLIANCE:
                addApplianceMenu();
                break;
            case TURN_ON_APPLIANCES:
                switchAppliances(true);
                break;
            case TURN_OFF_APPLIANCES:
                switchAppliances(false);
                break;
            case FIND_POWER:
                findPower();
            case SORT_APPLIANCES:
                sortAppliances();
                break;
            case FIND_APPLIANCE:
                findAppliance();
                break;
            case SHOW_ALL:
                showAll();
                break;
            case EXIT:
                exit();
                break;
            default:
                break;
        }
    }

    private String inputValue(String request, String patt){
        while(true){
            menuView.displayMessage(request);
            String input = scanner.readInput();
            Pattern pattern = Pattern.compile(patt);
            Matcher m = pattern.matcher(input);
            if (m.find()){
                return input;
            }
            menuView.displayMessage(MenuView.INVALID_INPUT);
        }
    }

    private void addApplianceMenu(){
        menuView.showAddMenu();
        AddMenuOption addMenuOption = AddMenuOption.values()[Integer.parseInt(inputValue(MenuView.COMMAND, ADD_MENU_PATTERN))-1];
        switch (addMenuOption){
            case KITCHEN:
                addAppliance(new KitchenAppliance());
                break;
            case CLEANER:
                addAppliance(new CleaningAppliance());
                break;
            case VIDEO:
                addAppliance(new VideoAppliance());
                break;
            case COMPUTER:
                addAppliance(new ComputerAppliance());
                break;
        }
    }

    private void addAppliance(ElectricalAppliance electricalAppliance){
        String name = inputValue(MenuView.REQUEST_NAME, NAME_PATTERN);
        electricalAppliance.setName(name);
        String size = inputValue(MenuView.REQUEST_SIZE, DOUBLE_PATTERN);
        electricalAppliance.setSize(Double.parseDouble(size));
        String power = inputValue(MenuView.REQUEST_POWER, DOUBLE_PATTERN);
        electricalAppliance.setDocumentedPower(Double.parseDouble(power));
        homeAppliances.addAppliance(electricalAppliance);
    }

    private void switchAppliances(boolean command){
        String[] appliances = inputValue(MenuView.REQUEST_APPLIANCES, APPLIANCE_PATTERN).split(DELIMIT);
        homeAppliances.switchAppliances(command, appliances);
    }

    private void findPower(){
        menuView.displayMessage(MenuView.POWER + homeAppliances.getPowerUsage());
    }

    @SuppressWarnings("unchecked")
    private void sortAppliances(){
        homeAppliances.getAllAppliances().sort(comparator);
    }

    private void findAppliance(){
        double[] sizeBorders = inputBorders(MenuView.REQUEST_SIZE);
        double[] powerBorders = inputBorders(MenuView.REQUEST_POWER);
        menuView.showAppliances((filterAppliances.findAppliance(sizeBorders,powerBorders,homeAppliances)));
    }

    private double[] inputBorders(String request){
        menuView.displayMessage(request);
        double left = Double.parseDouble(inputValue(MenuView.REQUEST_LEFT,DOUBLE_PATTERN));
        double right;
        while (true){
            right = Double.parseDouble(inputValue(MenuView.REQUEST_RIGHT,DOUBLE_PATTERN));
            if(left<=right){
                return new double[]{left,right};
            }
            menuView.displayMessage(MenuView.INVALID_BORDER);
        }
    }

    private void showAll(){
        menuView.showAppliances(homeAppliances.getAllAppliances());
    }

    private void exit() {
        menu = false;
//        fileController.saveToFile(homeAppliances.getAllAppliances());
    }
}
