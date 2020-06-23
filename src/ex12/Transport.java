package ex12;

import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.NoSuchModelNameException;
import ex38Visitor.Visitor;

public interface Transport {
    String getBrand();
    void setBrand(String brand);
    void setNameModel (String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException;
    String [] getNameAllModel();
    double getPriceModel (String nameModel) throws NoSuchModelNameException;
    void setPriceModel (String nameModel, double newPriceModel) throws NoSuchModelNameException;
    double [] getPriceAllModel ();
    void addModel (String nameModel, double priceModel) throws DuplicateModelNameException;
    void removeModel (String nameModel) throws NoSuchModelNameException;
    int getCountOfModel ();
    void accept (Visitor visitor);
}
