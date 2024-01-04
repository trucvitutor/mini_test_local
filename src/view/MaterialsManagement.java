package view;

import controller.MaterialController;
import data.ReadWriteFile;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaterialsManagement {
    public final Scanner sc = new Scanner(System.in);
    private final MaterialController materialController = new MaterialController();
//    List<Material> materials;
//
//    {
//        Material CrispyFlour1 = new CrispyFlour("01", "bột chiên giòn", LocalDate.parse("2023-09-09"), 35000, 1);
//        Material CrispyFlour2 = new CrispyFlour("02", "bột chiên giòn", LocalDate.parse("2023-09-09"), 35000, 2);
//        Material CrispyFlour3 = new CrispyFlour("03", "bột chiên giòn", LocalDate.parse("2023-09-09"), 35000, 1);
//        Material CrispyFlour4 = new CrispyFlour("04", "bột chiên giòn", LocalDate.parse("2023-09-09"), 35000, 7);
//        Material CrispyFlour5 = new CrispyFlour("05", "bột chiên giòn", LocalDate.parse("2023-09-09"), 35000, 9);
//        Material Meat1 = new Meat("06", "thịt trúc vi", LocalDate.parse("2023-12-26"), 400000, 4.0);
//        Material Meat2 = new Meat("07", "thịt nguội", LocalDate.parse("2023-12-25"), 400000, 4.0);
//        Material Meat3 = new Meat("08", "thịt nóng", LocalDate.parse("2024-01-01"), 400000, 4.0);
//        Material Meat4 = new Meat("09", "thịt heo", LocalDate.parse("2023-12-27"), 400000, 4.0);
//        Material Meat5 = new Meat("10", "thịt bò", LocalDate.parse("2023-12-28"), 400000, 4.0);
//        materials = new ArrayList<>(Arrays.asList(CrispyFlour1, CrispyFlour2, CrispyFlour3, CrispyFlour4, CrispyFlour5,
//                Meat1, Meat2, Meat3, Meat4, Meat5));
//    }

    public void MaterialsManagements() {
        int choice;
      //  int sum = 0;
        while (true) {
            System.out.println("1. thêm " + "\n" +
                    "2.sửa" + "\n" +
                    "3.xóa" + "\n" +
                    "4.số tiền thịt đã được giảm " + "\n" +
                    "5.số tiền bột đã được giảm " + "\n" +
                    "6.tổng của vật liệu. " + "\n" +
                    "7.hien thi");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addMaterial();

                    break;
                case 2:
                    editMaterial();

                    break;
                case 3:
                    deleteMaterial();

                    break;
                case 4:
                    priceMeat();
                    break;
                case 5:
                    priceCrispyFlour();
                    break;
                case 6:
                    sumMaterial();
//                    for (int i = 0; i < materials.size(); i++) {
//                      sum += materials.get(i).getCost();
//                   }
//                    System.out.println("Tổng tiền của 10 vat lieu: " + sum);
                    break;
                case 7:
                    List<Material> materialList = this.materialController.findAll();
                    this.display(materialList);
                    break;

            }
        }
    }

    private void sumMaterial() {
        int crispyFlour=this.materialController.sumCri();
        System.out.println(crispyFlour);

    }

    private void display(List<Material> materialList) {
        for (Material material : materialList) {
            System.out.println(material);
        }
    }

    private void priceCrispyFlour() {
        this.materialController.priceCri();
    }

    private void priceMeat() {
        this.materialController.priceMeat();
    }

    private void deleteMaterial() {
        System.out.println("Input id want delete");
        String id = sc.nextLine();
        System.out.println("bạn chắc chắn muốn xóa không " + "\n" +
                "1.yes" + "\n" +
                "2.no");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                this.materialController.remove(id);
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }

    }

    private void editMaterial() {
        int choice;
        while (true) {
            System.out.println("1.editCrispyFlour" + "\n" +
                    "2.editMeat " + "\n" + "3.thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    editCrispyFlour();
                    break;
                case 2:
                    editMeat();
                    break;
                case 3:
                    return;

            }

        }


    }

    private void editMeat() {
        System.out.println("Input id want edit");
        String id = sc.nextLine();
        Meat meat = this.materialController.editMeat(id);
        if (meat != null) {
            System.out.println("Input name: ");
            String name = sc.nextLine();
            System.out.println("Input manufacturingDate: ");
            LocalDate manufacturingDate = LocalDate.parse(sc.nextLine());
            System.out.println("Input cost: ");
            int cost = Integer.parseInt(sc.nextLine());
            System.out.println("Input Weight");
            double weight = Double.parseDouble(sc.nextLine());
            meat.setName(name);
            meat.setManufacturingDate(manufacturingDate);
            meat.setCost(cost);
            meat.setWeight(weight);
            this.materialController.updateMeat(meat);
        }
    }

    private void editCrispyFlour() {
        System.out.println("Input id want edit");
        String id = sc.nextLine();
        CrispyFlour crispyFlour = this.materialController.editCri(id);
        if (crispyFlour != null) {
            System.out.println("Input name: ");
            String name = sc.nextLine();
            System.out.println("Input manufacturingDate: ");
            LocalDate manufacturingDate = LocalDate.parse(sc.nextLine());
            System.out.println("Input cost: ");
            int cost = Integer.parseInt(sc.nextLine());
            System.out.println("input quantity :");
            int quantity = Integer.parseInt(sc.nextLine());
            crispyFlour.setName(name);
            crispyFlour.setManufacturingDate(manufacturingDate);
            crispyFlour.setCost(cost);
            crispyFlour.setQuantity(quantity);
            this.materialController.updateCri(crispyFlour);
        }
    }

    private void addMaterial() {
        int choice;
        while (true) {
            System.out.println("1.addCrispyFlour" + "\n" +
                    "2.addMeat " + "\n" + "3.thoát");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    CrispyFlour crispyFlour = addCrispyFlour();
                    this.materialController.add(crispyFlour);
                    break;
                case 2:
                    Meat meat = addMeat();
                    this.materialController.addM(meat);
                    break;
                case 3:
                    return;

            }
        }

    }

    private Meat addMeat() {
        System.out.println("Input id: ");
        String id = sc.nextLine();
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input manufacturingDate: ");
        LocalDate manufacturingDate = LocalDate.parse(sc.nextLine());
        System.out.println("Input cost: ");
        int cost = Integer.parseInt(sc.nextLine());
        System.out.println("Input weigth: ");
        double weigth = Double.parseDouble(sc.nextLine());

        return new Meat(id, name, manufacturingDate, cost, weigth);
    }

    private CrispyFlour addCrispyFlour() {
        System.out.println("Input id: ");
        String id = sc.nextLine();
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input manufacturingDate: ");
        LocalDate manufacturingDate = LocalDate.parse(sc.nextLine());
        System.out.println("Input cost: ");
        int cost = Integer.parseInt(sc.nextLine());
        System.out.println("Input quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        return new CrispyFlour(id, name, manufacturingDate, cost, quantity);


    }

}
