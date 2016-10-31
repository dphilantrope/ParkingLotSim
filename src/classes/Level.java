package classes;

public abstract class Level{
  protected Level _nextLevel,
                  _previousLevel;
  protected int _floor;

  protected Level(){
  }
  protected Level(Level nextLevel, Level previousLevel, int floor){
    _nextLevel=nextLevel;
    _previousLevel=previousLevel;
    _floor=floor;
  }

  public int getFloor(){
    return _floor;
  }
  protected void setLevel(Level nextLevel, Level previousLevel, int floor){
    _nextLevel=nextLevel;
    _previousLevel=previousLevel;
    _floor=floor;
  }

  protected void enter(Parker parker){
    parker.advanceTo(_nextLevel);
  }
  protected void exit(Parker parker){
    parker.exitTo(_previousLevel);
  }
}