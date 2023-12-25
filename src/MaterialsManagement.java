import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaterialsManagement {
    public final Scanner sc = new Scanner(System.in);
    List<Material> materials;

    {
        Material CrispyFlour1 = new CrispyFlour("01", "bột chiên giòn", LocalDate.now(), 35000, 1);
        Material CrispyFlour2 = new CrispyFlour("02", "bột chiên giòn", LocalDate.now(), 35000, 2);
        Material CrispyFlour3 = new CrispyFlour("03", "bột chiên giòn", LocalDate.now(), 35000, 1);
        Material CrispyFlour4 = new CrispyFlour("04", "bột chiên giòn", LocalDate.now(), 35000, 7);
        Material CrispyFlour5 = new CrispyFlour("05", "bột chiên giòn", LocalDate.now(), 35000, 9);
        Material Meat1 = new Meat("06", "thịt trúc vi", LocalDate.parse("2023-12-26"), 400000, 4.0);
        Material Meat2 = new Meat("07", "thịt nguội", LocalDate.parse("2023-12-25"), 400000, 4.0);
        Material Meat3 = new Meat("08", "thịt nóng", LocalDate.parse("2024-01-01"), 400000, 4.0);
        Material Meat4 = new Meat("09", "thịt heo", LocalDate.parse("2023-12-27"), 400000, 4.0);
        Material Meat5 = new Meat("10", "thịt bò", LocalDate.parse("2023-12-28"), 400000, 4.0);
        materials = new ArrayList<>(Arrays.asList(CrispyFlour1, CrispyFlour2, CrispyFlour3, CrispyFlour4, CrispyFlour5,
                Meat1, Meat2, Meat3, Meat4, Meat5));
    }

    public void MaterialsManagements() {
        int choice;
        while (true) {
            System.out.println(materials);
            System.out.println("1. thêm " + "\n" +
                    "2.sửa" + "\n" +
                    "3.xóa" +"\n" +
                    "4.số tiền thịt đã được giảm ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addMaterial();
                    System.out.println(materials);
                    break;
                case 2:
                    editMaterial();
                    System.out.println(materials);
                    break;
                case 3:
                    deleteMaterial();
                    System.out.println(materials);
                    break;
                case 4:
                    for (int i = 0; i < materials.size(); i++) {
                        if(materials.get(i) instanceof Meat){
                            System.out.println("Gia tien cua " + materials.get(i).getName() + " la: " + materials.get(i).getRealMoney());
                        }
                    }
                    break;
            }
        }
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
                for (int i = 0; i < materials.size(); i++) {
                    if (materials.get(i).getId().equals(id)) {
                        materials.remove(materials.get(i));
                    }
                }
                System.out.println("xóa thành công");
                break;
            case 2:
                break;
        }

    }

    private void editMaterial() {
        System.out.println("Input id want edit");
        String id1 = sc.nextLine();
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id1)) {
                System.out.println("Input name: ");
                String name = sc.nextLine();
                System.out.println("Input manufacturingDate: ");
                LocalDate manufacturingDate = LocalDate.parse(sc.nextLine());
                System.out.println("Input cost: ");
                int cost = Integer.parseInt(sc.nextLine());
                materials.get(i).setName(name);
                materials.get(i).setManufacturingDate(manufacturingDate);
                materials.get(i).setCost(cost);
            }
        }

    }

    private void addMaterial() {
        int choice;
        while (true) {
            System.out.println("1.addCrispyFlour" + "\n" +
                    "2.addMeat ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCrispyFlour();
                    break;
                case 2:
                    addMeat();
                    break;

            }
        }

    }

    private void addMeat() {
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
        Material material = new Meat(id, name, manufacturingDate, cost, weigth);
        materials.add(material);
    }

    private void addCrispyFlour() {
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
        Material material = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
        materials.add(material);

    }

}
