package service;

import model.CrispyFlour;
import model.Material;

import java.util.List;

public interface ICrispyFlourService {

    void add(CrispyFlour crispyFlour);

    List<Material> findAll();

   void remove(String id);

    CrispyFlour editCri(String id);

    void updateCri(CrispyFlour crispyFlour);

    void priceCri();


    int sumCri();



}
