package me.day25.smartstore.menu;

import me.day25.smartstore.customers.Customers;
import me.day25.smartstore.exception.InputEmptyException;
import me.day25.smartstore.exception.InputRangeException;
import me.day25.smartstore.groups.Group;
import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.groups.Groups;
import me.day25.smartstore.groups.Parameter;
import me.day25.smartstore.util.Message;

import java.util.InputMismatchException;
public class GroupMenu extends Menu {

    ////////////// singleton ////////////////
    private static GroupMenu groupMenu;

    public static GroupMenu getInstance() {
        if (groupMenu == null) {
            groupMenu = new GroupMenu();
        }
        return groupMenu;
    }
    /////////////////////////////////////////


    Groups allGroups = Groups.getInstance();
    Customers allCustomers = Customers.getInstance();


    public String chooseGroup() {
        while (true) {
            try {
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which group (GENERAL (G), VIP (V), VVIP (VV))? ");
                String choice = scanner.next().toUpperCase();

                if (choice == null || choice.equals("")) throw new InputEmptyException();
                return choice;

            } catch (InputEmptyException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_NULL);
            } catch (IllegalArgumentException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

//public int dispManageParameterMenu() {
//        while (true) {
//            try {
//                System.out.println();
//                System.out.println("==============================");
//                System.out.println(" 1. Set Parameter");
//                System.out.println(" 2. View Parameter");
//                System.out.println(" 3. Update Parameter");
//                System.out.println(" 4. Back");
//                System.out.println("==============================");
//                System.out.print("Choose One: ");
//                int choice = Integer.parseInt(Menu.scanner.next());
//                if (choice >= 1 && choice <= 4) {
//                    return choice;
//                }
//
//                throw new InputRangeException();
//            } catch (NumberFormatException e) {
//                System.out.println(Message.ERR_MSG_INVALID_INPUT_FORMAT);
//            } catch (InputRangeException e) {
//                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
//            }
//        }
//    }

    public void manageParameterMenu() {
        while (true) {
            int choice = dispMenu(new String[] {"Set Parameter", "View Parameter", "Update Parameter", "Back"});

            if (choice == 1) { setParameter(); }
            else if (choice == 2) { viewParameter(); }
            else if (choice == 3) { updateParameter(); }
            else if (choice == 4) { break; }
            else { System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE); }
        }
    }

    public void setParameter() {
        while (true) {
            String strGroup = chooseGroup();
            if (strGroup.equals(Message.END_MSG)) return;

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                continue;
            }

            Group grp = allGroups.find(groupType);
            if (grp != null && grp.getParam() != null) {
                System.out.println("\n" + strGroup + " group already exists.");
                System.out.println("\n" + grp);
            } else {
                Parameter param = new Parameter();

                while ( true ) {
                    int choice = dispMenu(new String[] {"Minimum Spent Time", "Minimum Total Pay", "Back"});
                    if (choice == 1) setParameterMinimumSpentTime(param);
                    else if (choice == 2) setParameterMinimumTotalPay(param);
                    else if (choice == 3) break;
                    else System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                }

                allGroups.add(new Group(groupType, param));
                allCustomers.refresh(allGroups);
            }
        }
    }

    public void viewParameter() {
        while ( true ) {
            String strGroup = chooseGroup();
            if (strGroup.equals(Message.END_MSG)) {
                return;
            }

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_TYPE);
                continue;
            }

            Group grp = allGroups.find(groupType);
            System.out.println();
            System.out.println(grp);
        }
    }

    public void updateParameter() {
        while (true) {
            String strGroup = chooseGroup();
            if (strGroup.equals(Message.END_MSG)) {
                return;
            }

            GroupType groupType;
            try {
                groupType = GroupType.valueOf(strGroup).replaceFullName();
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
                return;
            }

            Group grp = allGroups.find(groupType);
            if (grp.getParam() == null) {
                System.out.println("\nNo parameter. Set the parameter first.");
            } else {
                System.out.println("\n" + grp);
                Parameter param = grp.getParam();

                while (true) {
                    int choice = dispMenu(new String[] {"Minimum Spent Time", "Minimum Total Pay", "Back"});
                    if (choice == 1) { setParameterMinimumSpentTime(param); }
                    else if (choice == 2) { setParameterMinimumTotalPay(param); }
                    else if (choice == 3) { break; }
                    else { System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE); }
                }


                allCustomers.refresh(allGroups);
                System.out.println("\n" + grp);
            }
        }
    }

//    public int setParameterMenu() {
//        while (true) {
//            try {
//                System.out.println();
//                System.out.println("==============================");
//                System.out.println(" 1. Minimum Spent Time");
//                System.out.println(" 2. Minimum Total Pay");
//                System.out.println(" 3. Back");
//                System.out.println("==============================");
//                System.out.print("Choose One: ");
//                int choice = Integer.parseInt(scanner.next());
//                if (choice >= 1 && choice <= 3) {
//                    return choice;
//                }
//
//                throw new InputRangeException();
//            } catch (NumberFormatException e) {
//                System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
//            } catch (InputRangeException e) {
//                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
//            }
//        }
//    }

    public void setParameterMinimumSpentTime(Parameter param) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Spent Time: ");
                int minimumSpentTime = Integer.parseInt(scanner.next());
                if (minimumSpentTime < 0) throw new InputRangeException();

                param.setMinimumSpentTime(minimumSpentTime);
                return;
            } catch (NumberFormatException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
            } catch (InputRangeException e) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }

    public void setParameterMinimumTotalPay(Parameter param) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Input Minimum Total Pay: ");
                int minimumTotalPay = Integer.parseInt(scanner.next());
                if (minimumTotalPay < 0) throw new InputRangeException();

                param.setMinimumTotalPay(minimumTotalPay);
                return;
            } catch ( NumberFormatException e ) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_TYPE);
            } catch ( InputRangeException e ) {
                System.out.println(Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
}
