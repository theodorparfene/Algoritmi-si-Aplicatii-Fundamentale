package architect;

public class Architecture {  //polimorfism static
    public void move(Drawer drawer, double positionX, double positionY) {
        drawer.setPositionX(positionX);
        drawer.setPositionY(positionY);
    }

    public void move(Chair chair, double positionX, double positionY) {
        chair.setPositionX(positionX);
        chair.setPositionY(positionY);
    }

    public void move(Table table, double positionX, double positionY) {
        table.setPositionX(positionX);
        table.setPositionY(positionY);
    }

    public void move(Bed bed, double positionX, double positionY) {
        bed.setPositionX(positionX);
        bed.setPositionY(positionY);
    }

    public void move(Dresser dresser, double positionX, double positionY) {
        dresser.setPositionX(positionX);
        dresser.setPositionY(positionY);
    }
}
