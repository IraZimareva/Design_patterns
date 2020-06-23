package ex12;

import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.ModelPriceOutOfBoundsException;
import ex12.exceptions.NoSuchModelNameException;
import ex13.Prototype;
import ex38Visitor.Visitor;

public class Motorcycle implements Transport, Cloneable, Prototype {
    private String brand; //марка
    private int size = 0;
    private Model head = new Model();
    {
        head.setPrev(head);
        head.setNext(head);
    }

    public Motorcycle (String brand,int length) throws DuplicateModelNameException {
        this.brand=brand;
        size = length;
        for (int i=0;i<length;i++){
            addModel("Mot" + i, i + 100);
            this.size=length;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNameModel (String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException {
        boolean isNameExist = false;
        Model current = head.getNext();
        while (current != head){
            if (current.getName().equals(newNameModel)) {
                throw new DuplicateModelNameException();
            }
            if (current.getName().equals(oldNameModel)) {
                current.setName(newNameModel);
                isNameExist = true;
                //break;
            }
            current = current.getNext();
        }
        if (isNameExist==false) {
            throw new NoSuchModelNameException();
        }
    }//модификации значения названия модели

    public String [] getNameAllModel(){
        String [] nameAllModel = new String[size] ;
        Model current = head.getNext();
        int i=0;
        while (current != head){
            nameAllModel[i] = current.getName();
            current = current.getNext();
            i++;
        }
        return nameAllModel;
    } //возвращающий массив названий всех моделей

    public double getPriceModel (String nameModel)throws NoSuchModelNameException{
        double result=0;
        boolean isNameExist = false;
        Model current = head.getNext();
        while (current != head){
            if (current.getName().equals(nameModel)) {
                result = current.getPrice();
                isNameExist = true;
                break;
            }
            current = current.getNext();
        }
        if (isNameExist==false){
            throw new NoSuchModelNameException();
        }
        return result;
    } //получения значения цены модели по её названию

    public void setPriceModel (String nameModel, double newPriceModel) throws NoSuchModelNameException{
        boolean isNameExist = false;
        Model current = head.getNext();
        if (newPriceModel >= 0) {
            while (current != head) {
                if (current.getName().equals(nameModel)) {
                    current.setPrice(newPriceModel);
                    isNameExist = true;
                    break;
                }
                current = current.getNext();
            }
            if (isNameExist == false) {
                throw new NoSuchModelNameException();
            }
        }
        else throw new ModelPriceOutOfBoundsException();
    } //модификации значения цены модели по её названию

    public double [] getPriceAllModel () {
        Model current = head.getNext();
        double [] priceAllModel = new double [size];
        int i=0;
        while (current != head){
            priceAllModel[i] = current.getPrice();
            current = current.getNext();
            i++;
        }
        return priceAllModel;
    } //возвращающий массив значений цен моделей

    public void addModel (String nameModel, double priceModel)throws DuplicateModelNameException{
        Model current = head.getNext();
        while (current != head){
            if (current.getName().equals(nameModel)) {
                throw new DuplicateModelNameException();
            }
            current = current.getNext();
        }

        if (priceModel >= 0) {
            Model newModel = new Model(nameModel, priceModel);
            Model tmpPrev = head.getPrev();
            head.setPrev(newModel);
            newModel.setNext(head);
            newModel.setPrev(tmpPrev);
            tmpPrev.setNext(newModel);
            size++;
        }
        else throw new ModelPriceOutOfBoundsException();
    } //добавления названия модели и её цены (в конец списка)

    public void removeModel (String nameModel) throws NoSuchModelNameException{
        boolean isNameExist = false;
        Model current = head.getNext();
        while (current != head){
            if (current.getName().equals(nameModel)){
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
                isNameExist = true;
                break;
                }
            current=current.getNext();
        }
        if (isNameExist == false) {
            throw new NoSuchModelNameException();
        }
    }  //метод удаления модели с заданным именем

    public int getCountOfModel (){
        return size;
    }//метод для получения размера массива Моделей.

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMoto(this);
    }

    @Override
    public Object clone() {
        try {
            Motorcycle clone = (Motorcycle) super.clone();
            clone.head = new Model();
            clone.head.setPrev(clone.head);
            clone.head.setNext(clone.head);
            clone.size = 0;
            Model current = head.getNext();
            while (current != head) {
                clone.addModel(current.getName(),current.getPrice());
                current = current.getNext();
            }
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            throw new InternalError(ex.getMessage());
        }
        catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
        return null;
    }


    private class Model implements Cloneable{ //типо класс узла списка
        private String name = null; //название модели
        private double price = Double.NaN; //цена модели
        private Model prev = null;
        private Model next = null;

        private Model(String name, double price) {
            this.name = name;
            this.price = price;
        }
        private Model() {
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

        private Model getPrev() {
            return prev;
        }

        private void setPrev(Model prev) {
            this.prev = prev;
        }

        private Model getNext() {
            return next;
        }

        private void setNext(Model next) {
            this.next = next;
        }

        public Object clone() {
            try{
                return (Model) super.clone();
            }
            catch (CloneNotSupportedException ex){
                throw new InternalError(ex.getMessage());
            }
        }
    }
}
