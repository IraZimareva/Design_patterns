package ex12;

import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.ModelPriceOutOfBoundsException;
import ex12.exceptions.NoSuchModelNameException;
import ex13.Prototype;
import ex32.CommandMy;
import ex32.PrintColumn;
import ex32.PrintLine;
import ex38Visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Transport,Cloneable, Prototype, Serializable {
    private String brand; //марка
    private Model[] model;

    public Car(String brand, int length) {
        this.brand = brand;
        model = new Model[length];
        for (int i = 0; i < length; i++) {
            model[i] = new Model("Car" + i, i + 100);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException {
        boolean isNameExist = false;
        for (int i = 0; i < model.length; i++) {
            if (model[i].getName().equals(newNameModel)) {
                throw new DuplicateModelNameException();
            }
            if (model[i].getName().equals(oldNameModel)) {
                model[i].setName(newNameModel);
                isNameExist = true;
            }
        }
        if (isNameExist == false) {
            throw new NoSuchModelNameException();
        }
    }//модификации значения названия модели

    public String[] getNameAllModel() {
        String[] nameAllModel = new String[model.length];
        for (int i = 0; i < model.length; i++) {
            nameAllModel[i] = model[i].getName();
        }
        return nameAllModel;
    } //возвращающий массив названий всех моделей

    public double getPriceModel(String nameModel) throws NoSuchModelNameException {
        double result = 0;
        boolean isNameExist = false;
        for (int i = 0; i < model.length; i++) {
            if (model[i].getName().equals(nameModel)) {
                result = model[i].getPrice();
                isNameExist = true;
                break;
            }
        }
        if (isNameExist == false) {
            throw new NoSuchModelNameException();
        }
        return result;
    } //получения значения цены модели по её названию

    public void setPriceModel(String nameModel, double newPriceModel) throws NoSuchModelNameException {
        boolean isNameExist = false;
        if (newPriceModel >= 0) {
            for (int i = 0; i < model.length; i++) {
                if (model[i].getName().equals(nameModel)) {
                    model[i].setPrice(newPriceModel);
                    isNameExist = true;
                    break;
                }
            }
            if (isNameExist == false) {
                throw new NoSuchModelNameException();
            }
        } else throw new ModelPriceOutOfBoundsException();
    } //модификации значения цены модели по её названию

    public double[] getPriceAllModel() {
        double[] priceAllModel = new double[model.length];
        for (int i = 0; i < model.length; i++) {
            priceAllModel[i] = model[i].getPrice();
        }
        return priceAllModel;
    } //возвращающий массив значений цен моделей

    public void addModel(String nameModel, double priceModel) throws DuplicateModelNameException {
        for (int i = 0; i < model.length; i++) {
            if (model[i].getName().equals(nameModel)) {
                throw new DuplicateModelNameException();
            }
        }
        if (priceModel >= 0) {
            Model[] newModel = Arrays.copyOf(model, model.length + 1);
            newModel[newModel.length - 1] = new Model(nameModel, priceModel);
            model = newModel;
        } else throw new ModelPriceOutOfBoundsException();
    } //добавления названия модели и её цены (путем создания нового массива Моделей)

    public void removeModel(String nameModel) throws NoSuchModelNameException {
        boolean isNameExist = false;
        int indexOfRemoveModel = 0; //номер удаляемой модели
        for (int i = 0; i < model.length; i++) {
            if (model[i].getName().equals(nameModel)) {
                indexOfRemoveModel = i;
                isNameExist = true;
                break;
            }
        }
        if (isNameExist == false) {
            throw new NoSuchModelNameException();
        }
        Model[] newModel = new Model[model.length - 1]; //новый массив с длиной - 1
        System.arraycopy(model, 0, newModel, 0, indexOfRemoveModel);
        System.arraycopy(model, indexOfRemoveModel + 1, newModel, indexOfRemoveModel, newModel.length - indexOfRemoveModel);
        model = newModel;
    }  //метод удаления модели с заданным именем

    public int getCountOfModel() {
        return model.length;
    }//метод для получения размера массива Моделей.

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCar(this);
    }

    @Override
    public Object clone() {
        try {
            Car cloneCar = (Car) super.clone();
            cloneCar.model = (Model[]) model.clone();
            for (int i = 0; i < this.getCountOfModel(); i++) {
                cloneCar.model[i] = (Model) model[i].clone();
            }
            return cloneCar;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError(ex.getMessage());
        }
    }

    public void print(FileWriter fw) {
        CommandMy commandMy = this.setPrintCommand();
        commandMy.print(this, fw);
    }

    public CommandMy setPrintCommand() {
        if (this.getCountOfModel() > 3) {
            return new PrintColumn();
        } else return new PrintLine();
    }

    public Iterator iterator() {
        return new AutoIterator();
    }

    public Memento createMemento() {
        Memento mem = new Memento(this);
        mem.setAuto();
        return mem;
    }//создать снимок

   public void setMemento(Memento memento) {
        //this (memento.getAuto().getBrand(),memento.getAuto().model);
        this.brand = memento.getAuto().getBrand();
        this.model = memento.getAuto().model;
    }//вернуть состояние


    //ИТЕРАТОР
    private class AutoIterator implements Iterator {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < model.length;
        }

        @Override
        public Model next() {
            Model next = model[cursor];
            cursor++;
            return next;
        }
    }

    //МОДЕЛЬ
    protected static class Model implements Cloneable, Serializable {
        private String name; //название модели
        private double price; //цена модели

        private Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private double getPrice() {
            return price;
        }

        private void setPrice(double price) {
            this.price = price;
        }

        public Object clone() {
            try {
                return (Model) super.clone();
            } catch (CloneNotSupportedException ex) {
                throw new InternalError(ex.getMessage());
            }
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(getName() + ":" + getPrice());
            return sb.toString();
        }
    }//Реализовать в нём метод toString(), возвращающий название и цену модели.

    //MEMENTO
    public static class Memento {
        private Car memento;
        private ByteArrayOutputStream bos;

        public Memento (Car car){
            memento = car;
        }

        private void setAuto() {
            try {
                bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new  ObjectOutputStream(bos);
                oos.writeObject(memento);
                //out.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        } //write

        private Car getAuto() {
            try {
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
                memento = (Car) ois.readObject();
                //is.close();
                return memento;
            }
            catch (IOException ex) {
                ex.getMessage();
                return null;
            }
            catch (ClassNotFoundException clas) {
                clas.getMessage();
                return null;
            }
        }// read
    }
}
