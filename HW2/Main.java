package HW2;

import HW2.client.domain.ClientController;
import HW2.client.ui.ClientGUI;
import HW2.server.domain.ServerController;
import HW2.server.repository.FileStorage;
import HW2.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerWindow(), new FileStorage());

        new ClientController(new ClientGUI(), serverController);
        
    }
}