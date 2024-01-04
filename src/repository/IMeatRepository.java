package repository;

import model.Meat;

public interface IMeatRepository {
    void addM(Meat meat);

    Meat editMeat(String id);

    void updateMeat(Meat meat);

    void priceMeat();

}
