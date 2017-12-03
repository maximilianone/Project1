package controll;

public interface Patterns {
    String MAIN_MENU_PATTERN = "^[1-8]$";
    String ADD_MENU_PATTERN = "^[1-4]$";
    String DOUBLE_PATTERN = "^(0|[1-9][0-9]*).?[0-9]*$";
    String APPLIANCE_PATTERN = "^[0-9a-zA-Z]+[, 0-9a-zA-Z]*";
    String NAME_PATTERN = "";
    String DELIMIT = ", ";
}
