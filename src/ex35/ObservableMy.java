package ex35;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Observer;

public class ObservableMy <T> {

        //private ArrayList <Observer> observers;
        private ArrayList <MouseAdapter> listeners;
        private boolean changed;

        public ObservableMy(){
            //observers = new ArrayList<>();
            listeners = new ArrayList<>();
            changed = false;
        }

    public void addListener(MouseAdapter listener) {
        listeners.add(listener);
    }

    public void removeListener(MouseAdapter listener) {
        listeners.remove(listener);
    }

    public ArrayList<MouseAdapter> getListeners() {
        return listeners;
    }

    public void setListeners(ArrayList<MouseAdapter> listeners) {
        this.listeners = listeners;
    }

}

