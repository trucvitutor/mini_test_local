package service;

import model.Meat;

public interface IMeatService {

    void addM(Meat meat);

    Meat editMeat(String id);

    void updateMeat(Meat meat);

    void priceMeat();

    int sumMeat();

}
