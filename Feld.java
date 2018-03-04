/**
 *
 */
public class Feld 
{
    /* Attribute */
    private int vegetation;
    protected Finken fink1;
    protected Finken fink2;
    protected Finken fink3;
    private int maximalesAlter;

    public Feld(){
       

    }
    /* Methoden */
    /** @return liefert Vegetation 
     */
    public int gibVegetation(){
        //TODO gegebenenfalls ueberarbeiten
        return this.vegetation;
    }

    public void fuegeFinkHinzu(String[] pGene){
        fink1=new Finken(pGene);
    }

    public void bewegeFinkAufFeld(Finken pFink){
        if(fink1==null){
            fink1=pFink;
        }
        else  if(fink2==null){
            fink2=pFink;
        } 
        else  if(fink3==null){
            fink3=pFink;
        } 
    }

    public void toeteFinken(){
        toeteFink(fink1);
        toeteFink(fink2);
        toeteFink(fink3);
    }
    
    public void setVegetation(int pVegetation)
  {
      vegetation = pVegetation;
  }

    public void toeteFink(Finken pFink){
        pFink.erhoeheAlter();
        if(pFink.istLebendig()==true){
            if(pFink.gibAlter()>maximalesAlter){
                pFink.toete();
            }
        }
    }

    public void pruefePaaren(){
        if(fink1!=null&&fink2!=null){
            if(fink1.istLebendig()==true&&fink2.istLebendig()==true){
                fink3=fink1.paare(fink2.gibGencode());
            }
        }
        else if(fink1!=null&&fink3!=null){
            if(fink1.istLebendig()==true&&fink3.istLebendig()==true){
                fink2=fink1.paare(fink3.gibGencode());
            }
        }   
        else if(fink2!=null&&fink3!=null){
            if(fink2.istLebendig()==true&&fink3.istLebendig()==true){
                fink1=fink2.paare(fink3.gibGencode());
            }
        }      
    }
    
    

}//Ende Klasse: Feld

