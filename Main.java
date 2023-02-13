package HelpDesk;

import HelpDesk.Controller.HelpDeskController;
import HelpDesk.View.*;

class Main {
    public static void main(String[] args) {
        HelpDeskController.helpDeskController = new HelpDeskController();
        //Form f = new Form();
        new DashBoard();
    }
}