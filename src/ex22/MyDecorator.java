package ex22;

import ex12.Transport;
import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.NoSuchModelNameException;
import ex38Visitor.Visitor;

public class MyDecorator implements Transport{
    private Transport transport;

    public MyDecorator(Transport transport) {
        this.transport = transport;
    }

    @Override
    public synchronized String getBrand() {
        return transport.getBrand();
    }

    @Override
    public synchronized void setBrand(String brand) {
        transport.setBrand(brand);
    }

    @Override
    public synchronized void setNameModel(String oldNameModel, String newNameModel) throws NoSuchModelNameException, DuplicateModelNameException {
        transport.setNameModel(oldNameModel,newNameModel);
    }

    @Override
    public synchronized String[] getNameAllModel() {
        return transport.getNameAllModel();
    }

    @Override
    public synchronized double getPriceModel(String nameModel) throws NoSuchModelNameException {
        return transport.getPriceModel(nameModel);
    }

    @Override
    public synchronized void setPriceModel(String nameModel, double newPriceModel) throws NoSuchModelNameException {
        transport.setPriceModel(nameModel,newPriceModel);
    }

    @Override
    public synchronized double[] getPriceAllModel() {
        return transport.getPriceAllModel();
    }

    @Override
    public synchronized void addModel(String nameModel, double priceModel) throws DuplicateModelNameException {
        transport.addModel(nameModel,priceModel);
    }

    @Override
    public synchronized void removeModel(String nameModel) throws NoSuchModelNameException {
        transport.removeModel(nameModel);
    }

    @Override
    public synchronized int getCountOfModel() {
        return transport.getCountOfModel();
    }

    @Override
    public void accept(Visitor visitor) {
        transport.accept(visitor);
    }
}
