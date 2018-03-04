/**
 *
 */
public class Gene 
{
    /* Attribute */
    private String[] Gen;
    
    public Gene(String[] pGen){
        Gen=pGen;
    }
    /* Methoden */
    /** @return liefert Gen 
     */
    public String gibGencode(int p){
        //TODO gegebenenfalls ueberarbeiten
        return this.Gen[p];
    }

    /**  */
    public void setzeGencode(String[]  gene){

    }
    
    public int gibLaenge(){
        return Gen.length;
    }

}//Ende Klasse: Gene

