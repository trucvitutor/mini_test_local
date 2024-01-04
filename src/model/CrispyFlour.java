package model;

import java.time.LocalDate;

public class CrispyFlour extends Material {

    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost) {
        super(id, name, manufacturingDate, cost);
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "id=" + super.getId() +
                ",name=" + super.getName() +
                ",manufacturingDate=" + super.getManufacturingDate() +
                ",cost=" + super.getCost() +
                "quantity=" + quantity +
                '}';
    }
    public String toVer(){
        return super.getId()+","+super.getName()+","+super.getManufacturingDate()+","+super.getCost()+","+quantity;
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        LocalDate mfDate = super.getManufacturingDate();
        if (now.getYear() == mfDate.getYear()) {
            if (mfDate.getMonthValue() - now.getMonthValue() <= 2) {
                return this.getAmount() * 0.6;
            } else if (mfDate.getMonthValue() - now.getMonthValue() <= 4) {
                return this.getAmount() * 0.8;
            }

        }
        return this.getAmount() * 0.95;
    }
}
