import java.util.*;
/**
*
*/
public class Insel 
{
  /* Attribute */
	protected Feld[][] felder;
	private int hoehe;
	private int breite;
	private String name;
	
  /* Konstruktoren */
  /**  */
  public Insel(int  pGroesseX,int  pGroesseY,String pName)
  {
      name = pName;
      felder = new Feld[pGroesseX][pGroesseY];
      breite=pGroesseX;
      hoehe=pGroesseY;
      generiereFelder();
  }

  /* Methoden */
  /**  */
 public void generiereFelder()
  {
      Random r = new Random();
      for(int i=0; i<felder.length;i++)
      {
          for(int j=0;j<felder[i].length;j++)
          {
              if(i==0 || j==0 || i==felder.length-1 || j==felder[i].length-1)
              {
                 
                  felder[i][j]=new Feld();
                  felder[i][j].setVegetation(0); 
              }
              else
              {
                felder[i][j]=new Feld();
                  felder[i][j].setVegetation(r.nextInt(4)+1);
              }
          }
      }
  }

  /**  */
  public void fuegeFeldHinzu(int  pPositionX,int  pPositionY){
  }
  
  public int gibBreite(){
     return breite   ;
    }
  
     public String gibName ()
  {
      return name;
  }

  public Feld gibFeld(int  pPositionX,int  pPositionY)
  {
    return felder[pPositionX][pPositionY];
  }

   public int gibHoehe(){
    return hoehe   ;
   }

}//Ende Klasse: Insel

