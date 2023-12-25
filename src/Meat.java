import java.time.LocalDate;

public class Meat extends Material{
    private double weight;
    public Meat(String id, String name, LocalDate manufacturingDate, int cost) {
        super(id, name, manufacturingDate, cost);
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public String toString() {
        return "Meat{" +
                "id=" + super.getId() +
                ",name=" + super.getName() +
                ",manufacturingDate=" + super.getManufacturingDate() +
                ",cost=" + super.getCost() +
                "weight=" + weight +
                '}';
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        LocalDate mfDate = super.getManufacturingDate();
        if (now.getYear() == mfDate.getYear()) {
            if (now.getMonth() == mfDate.getMonth()) {
                if (mfDate.getDayOfMonth() - now.getDayOfMonth() <= 5) {
                    return this.getAmount() * 0.7;
                }
            }
        }
        return this.getAmount() * 0.9;
    }
}
