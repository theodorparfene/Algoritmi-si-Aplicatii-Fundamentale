package LinkedList;

public class Town implements Comparable<Town>{
    private String name;
    private int km;

    public Town(String name, int km) {
        this.name = name;
        this.km = km;
    }

    @Override
    public String toString() {
        return name + " " + km;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Town o = (Town)obj;
        if (this.name.equals(o.name) &&
            this.km == o.km) {
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(Town o) {
        if (this.km > o.km) {
            return 1;
        } else if (this.km < o.km) {
            return -1;
        } else {
            return 0;
        }
    }
}
