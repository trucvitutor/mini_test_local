package repository;

import data.ReadWriteFile;
import model.Material;
import model.Meat;


import java.util.List;

public class MeatRepository implements IMeatRepository {
    public static final String FILE = "src/util/doc.csv";
    @Override
    public void addM(Meat meat) {
        List<Material> meatList= ReadWriteFile.readDataFromFile(FILE);
        meatList.add(meat);
        ReadWriteFile.writeToFile(FILE,meatList);
    }

    @Override
    public Meat editMeat(String id) {
        List<Material>  materials= ReadWriteFile.readDataFromFile(FILE);
        for (Material material : materials) {
            if (material.getId().equals(id)) {
                return (Meat) material;
           }
        }
        return null;
    }

    @Override
    public void updateMeat(Meat meat) {
        List<Material> meatM = ReadWriteFile.readDataFromFile(FILE);
        for (Material material:meatM) {
            if(material instanceof Meat){
                if(material.getId().equals(meat.getId())){
                    material.setName(meat.getName());
                    material.setCost(meat.getCost());
                    material.setManufacturingDate(meat.getManufacturingDate());
                    ((Meat) material).setWeight(meat.getWeight());
                }
            }
        }
        ReadWriteFile.writeToFile(FILE,meatM);
    }

    @Override
    public void priceMeat() {
        List<Material> meatM = ReadWriteFile.readDataFromFile(FILE);
        for (int i = 0; i < meatM.size(); i++) {
            if (meatM.get(i) instanceof Meat) {
                System.out.println("Gia tien cua " + meatM.get(i).getName() + " la: " + meatM.get(i).getRealMoney());
            }
        }
    }
}
