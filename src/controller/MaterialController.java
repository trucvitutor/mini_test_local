package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;
import service.CrispyFlourService;
import service.ICrispyFlourService;
import service.IMeatService;
import service.MeatService;

import java.util.List;

public class MaterialController {
private final ICrispyFlourService crispyFlourService= new CrispyFlourService();
private final IMeatService iMeatService =new MeatService();

    public void add(CrispyFlour crispyFlour) {
        this.crispyFlourService.add(crispyFlour);
    }

    public List<Material> findAll() {
        return this.crispyFlourService.findAll();
    }

    public void addM(Meat meat) {
        this.iMeatService.addM(meat);
    }

    public void remove(String id) {
       crispyFlourService.remove(id);
    }

    public CrispyFlour editCri(String id) {

        return crispyFlourService.editCri(id);
    }

    public void updateCri(CrispyFlour crispyFlour) {
        this.crispyFlourService.updateCri(crispyFlour);
    }

    public Meat editMeat(String id) {

        return iMeatService.editMeat(id);
    }

    public void updateMeat(Meat meat) {
        iMeatService.updateMeat(meat);
    }

    public void priceCri() {
        crispyFlourService.priceCri();
    }

    public void priceMeat() {
        iMeatService.priceMeat();
    }

    public int sumCri() {
        return crispyFlourService.sumCri();
    }
}
