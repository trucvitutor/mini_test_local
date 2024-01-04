package service;

import model.CrispyFlour;
import model.Material;
import repository.CrispyFlourRepository;
import repository.ICrispyFlourRepository;

import java.util.List;


public class CrispyFlourService implements ICrispyFlourService {
    private final ICrispyFlourRepository iCrispyFlourRepository=new CrispyFlourRepository();

    @Override
    public void add(CrispyFlour crispyFlour) {
        this.iCrispyFlourRepository.add(crispyFlour);
    }

    @Override
    public List<Material> findAll() {
        return this.iCrispyFlourRepository.findAll();
    }

    @Override
    public void remove(String id) {
         this.iCrispyFlourRepository.remove(id);
    }

    @Override
    public CrispyFlour editCri(String id) {
        return iCrispyFlourRepository.editCri(id);
    }

    @Override
    public void updateCri(CrispyFlour crispyFlour) {
        iCrispyFlourRepository.updateCri(crispyFlour);
    }

    @Override
    public void priceCri() {
        iCrispyFlourRepository.priceCri();
    }

    @Override
    public int sumCri() {
        return iCrispyFlourRepository.sumCri();
    }


}
