package service;

import model.Meat;
import repository.IMeatRepository;
import repository.MeatRepository;

public class MeatService implements IMeatService{
    private final IMeatRepository meatRepository=new MeatRepository();

    @Override
    public void addM(Meat meat) {
        meatRepository.addM(meat);
    }

    @Override
    public Meat editMeat(String id) {
        return meatRepository.editMeat(id);
    }

    @Override
    public void updateMeat(Meat meat) {
        meatRepository.updateMeat(meat);
    }

    @Override
    public void priceMeat() {
        meatRepository.priceMeat();
    }
}
