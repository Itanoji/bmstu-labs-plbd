import java.util.Objects;

public class Drob {
    private Chislo chisl;
    private Chislo znam;

    public Drob(Chislo chisl, Chislo znam) {
        this.chisl = chisl;
        this.znam = znam;
    }

    public Drob add(Drob other) {
        int newChisl = this.chisl.getValue() * other.znam.getValue() + other.chisl.getValue() * this.znam.getValue();
        int newZn = this.znam.getValue() * other.znam.getValue();
        return new Drob(new Chislo(newChisl), new Chislo(newZn));
    }

    public Drob sub(Drob other) {
        int newChisl = this.chisl.getValue() * other.znam.getValue() - other.chisl.getValue() * this.znam.getValue();
        int newZn = this.znam.getValue() * other.znam.getValue();
        return new Drob(new Chislo(newChisl), new Chislo(newZn));
    }

    public Drob mult(Drob other) {
        int newChisl = this.chisl.getValue() * other.chisl.getValue();
        int newZn = this.znam.getValue() * other.znam.getValue();
        return new Drob(new Chislo(newChisl), new Chislo(newZn));
    }

    public Drob div(Drob other) {
        if (other.chisl.getValue() == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        int newChisl = this.chisl.getValue() * other.znam.getValue();
        int newZn = this.znam.getValue() * other.chisl.getValue();
        return new Drob(new Chislo(newChisl), new Chislo(newZn));
    }

    public Chislo getChisl() {
        return chisl;
    }

    public void setChisl(Chislo chisl) {
        this.chisl = chisl;
    }

    public Chislo getZnam() {
        return znam;
    }

    public void setZnam(Chislo znam) {
        this.znam = znam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drob drob = (Drob) o;
        return Objects.equals(chisl, drob.chisl) && Objects.equals(znam, drob.znam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chisl, znam);
    }

    @Override
    public String toString() {
        return chisl.toString() + "/" + znam.toString();
    }
}
