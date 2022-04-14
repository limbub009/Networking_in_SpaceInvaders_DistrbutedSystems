package spaceinvaders.game;

import spaceinvaders.utility.Couple;

/** Everything that the user can interact with. */
public class Entity implements Cloneable {
  private EntityEnum type;
  private Integer id;
  // Upper-left corner coordinates.
  private Couple<Integer,Integer> pos;
  private Couple<Integer,Integer> lastPos;
  private Couple<Integer,Integer> posb4DR;




  /**
   * @param type the type of the entity.
   * @param id the id of the entity.
   * @param posX x coordinate.
   * @param posY y coordinate.
   *
   * @throws NullPointerException if an argument is {@code null}.
   */
  public Entity(EntityEnum type, int id, int posX, int posY) {
    if (type == null) {
      throw new NullPointerException();
    }
    this.type = type;
    this.id = id;
    this.pos = new Couple<>(posX,posY);

    //DEAD RECKONING ADDITIONS
    this.lastPos = new Couple<>(posX,posY);
    this.posb4DR = new Couple<>(posX,posY);
  }

  /**
   * @param type the type of the entity.
   * @param posX x coordinate.
   * @param posY y coordinate.
   *
   * @throws NullPointerException - if an argument is {@code null}.
   */
  public Entity(EntityEnum type, int posX, int posY) {
    if (type == null) {
      throw new NullPointerException();
    }
    this.type = type;
    id = hashCode();
    this.pos = new Couple<>(posX,posY);
    this.lastPos = new Couple<>(posX,posY);
    this.posb4DR = new Couple<>(posX,posY);
  }

  @Override
  public Entity clone() throws CloneNotSupportedException {
    return (Entity) super.clone();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public EntityEnum getType() {
    return type;
  }

  public int getX() {
    return pos.getFirst();
  }

  public int getY() {
    return pos.getSecond();
  }

  public int posb4DRX() {
    return posb4DR.getFirst();
  }

  public int posb4DRY() {
    return posb4DR.getSecond();
  }

  public int lastX() {
    return lastPos.getFirst();
  }

  public int lastY() {
    return lastPos.getSecond();
  }

  public void setPos(int posX, int posY) {
    pos.setFirst(posX);
    pos.setSecond(posY);
  }

  public void lastPos(int posX, int posY) {
  lastPos.setFirst(posX);
  lastPos.setSecond(posY);
}

  public void posb4DR(int posX, int posY) {
    posb4DR.setFirst(posX);
    posb4DR.setSecond(posY);
}
//  GETTERS AND SETTERS FOR STOPS
  private boolean Stopped = false;
  public boolean getStopped() {
    return Stopped;
  }
  public void setStopped(boolean Stopped) {
    this.Stopped = Stopped;
  }
}
