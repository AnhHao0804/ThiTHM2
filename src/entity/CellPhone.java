package entity;

public class CellPhone extends Phone{
    private String status;
    private String national;
    public CellPhone(int id, String name, double price, int quantity, String producer, String status, String national) {
        super(id, name, price, quantity, producer);
        this.status = status;
        this.national = national;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
}
