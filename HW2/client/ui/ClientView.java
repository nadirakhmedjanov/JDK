package HW2.client.ui;

import HW2.client.domain.ClientController;

public interface ClientView {

   
    void showMessage(String message);

   
    void disconnectedFromServer();

    
    void setClientController(ClientController clientController);
}