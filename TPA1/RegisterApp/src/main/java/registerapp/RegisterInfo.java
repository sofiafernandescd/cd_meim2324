package registerapp;

import java.util.LinkedList;

public class RegisterInfo {

    private int nServers = 0;

    private LinkedList<String> ServersList;

    public RegisterInfo() {
        this.ServersList = new LinkedList<>();
    }

    public void addServerToList(String server) {
        ServersList.add(server);
    }

    public int getNumberOfServers() {
        return ServersList.size();
    }

    public LinkedList<String> getListOfServers() {
        return ServersList;
    }
    public int addNServers(){ return ++nServers; }
    public int getNServers() {
        return nServers;
    }

    public void decrementNServers() {
        --nServers;
    }

}