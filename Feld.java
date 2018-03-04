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
        if(fink1!=null){
            toeteFink(fink1);
        }
        else  if(fink2!=null){
            toeteFink(fink2);
        } 
        else  if(fink3!=null){
            toeteFink(fink3);
        } 
    }

    public void setVegetation(int pVegetation)
    {
        vegetation = pVegetation;
    }

    public void toeteFink(Finken pFink){
        if(pFink.istLebendig()==true){
            pFink.erhoeheAlter();
            if(pFink.gibAlter()>4){                
                pFink.toete();
                
            }
        }
        else{
         pFink=null;   
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

