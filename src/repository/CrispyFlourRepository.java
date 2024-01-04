package repository;

import data.ReadWriteFile;
import model.CrispyFlour;
import model.Material;

import java.util.List;

public class CrispyFlourRepository implements ICrispyFlourRepository {
    public static final String FILE = "src/util/doc.csv";

    @Override
    public void add(CrispyFlour crispyFlour) {
        List<Material> crispyFlourRepositories = ReadWriteFile.readDataFromFile(FILE);
        crispyFlourRepositories.add(crispyFlour);
        ReadWriteFile.writeToFile(FILE, crispyFlourRepositories);
    }

    @Override
    public List<Material> findAll() {
        return ReadWriteFile.readDataFromFile(FILE);
    }

    @Override
    public void remove(String id) {
        List<Material> materials = ReadWriteFile.readDataFromFile(FILE);
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.remove(materials.get(i));
                System.out.println("thành công");
            }
        }
        ReadWriteFile.writeToFile(FILE, materials);
    }

    @Override
    public CrispyFlour editCri(String id) {
        List<Material> crispyFlours = ReadWriteFile.readDataFromFile(FILE);
        for (Material material : crispyFlours) {
            if (material.getId().equals(id)) {
                return (CrispyFlour) material;
            }
        }
        return null;
    }

    @Override
    public void updateCri(CrispyFlour crispyFlour) {
        List<Material> crispyFlours = ReadWriteFile.readDataFromFile(FILE);
        for (Material material : crispyFlours) {
            if (material instanceof CrispyFlour) {
                if (material.getId().equals(crispyFlour.getId())) {
                    material.setName(crispyFlour.getName());
                    material.setManufacturingDate(crispyFlour.getManufacturingDate());
                    material.setCost(crispyFlour.getCost());
                    ((CrispyFlour) material).setQuantity(crispyFlour.getQuantity());
                    break;
                }
            }
        }
        ReadWriteFile.writeToFile(FILE,crispyFlours);
    }

    @Override
    public void priceCri() {
        List<Material> crispyFlours = ReadWriteFile.readDataFromFile(FILE);
        for (int i = 0; i < crispyFlours.size(); i++) {
           if (crispyFlours.get(i) instanceof CrispyFlour) {
               System.out.println("Gia tien cua " + crispyFlours.get(i).getName() + " la: " + crispyFlours.get(i).getRealMoney());
          }
        }
    }

    @Override
    public int sumCri() {
        List<Material> crispyFlours = ReadWriteFile.readDataFromFile(FILE);
        int sum=0;
        for (Material material:crispyFlours) {
            if(material instanceof CrispyFlour){
               sum+=material.getCost();
            }
        }
        return  sum;
    }
}
