import java.util.*;
/**
 *
 */
public class Finken 
{
    /* Attribute */
    private Gene gencode;
    private int schnabel;
    private int alter;
    private boolean lebendig;
    
    /** Konstruktor
     */
    public Finken (String[] pGene){
        gencode=new Gene(pGene);
        alter=0;
        berechneSchnabel();
        lebendig=true;
    }
    /* Methoden */
    /** @return liefert Alter 
     */
    public int gibAlter(){
        return this.alter;
    }

    /** setzt Alter 
     */
    public void erhoeheAlter(){
        this.alter = this.alter+1;
    }

    /** @return liefert Gencode 
     */
    public Gene gibGencode(){
        return this.gencode;
    }
    
    /**  */
    public Finken paare(Gene  fremdgene){      
        int dicker=0;
        int duenner=0;
        for(int i=0; i<gencode.gibLaenge();i++){
            if(gencode.gibGencode(i)=="MBF4"){
             dicker++;   
            }
            else if(gencode.gibGencode(i)=="CAS1"){
             duenner++;   
            }
        }
        for(int i=0; i<fremdgene.gibLaenge();i++){
            if(fremdgene.gibGencode(i)=="MBF4"){
             dicker++;   
            }
            else if(fremdgene.gibGencode(i)=="CAS1"){
             duenner++;   
            }
        }
        dicker=dicker/2-5;
        duenner=duenner/2-5;
        Random rg=new Random();
        int a=rg.nextInt(11-1);
        int b=10-a;
        String[] t=new String[dicker+duenner+10];
        int ii=0;
        while(a<0){
            t[ii]="MBF4";
            ii++;
        }
        while(b<0){
            t[ii]="CAS1";
            ii++;
        }               
        for(int i=0;i<dicker;i++){
            t[ii]="MBF4";
            ii++;
        }
        for(int i=0;i<duenner;i++){
            t[ii]="CAS1";
            ii++;
        }
        Finken finken=new Finken(t);
        return finken;
    }

    public void berechneSchnabel(){
        int dicker=0;
        int duenner=0;
        for(int i=0; i<gencode.gibLaenge();i++){
            if(gencode.gibGencode(i)=="MBF4"){
             dicker++;   
            }
            else if(gencode.gibGencode(i)=="CAS1"){
             duenner++;   
            }
        }
        schnabel=50-dicker+duenner;
    }
    
    public boolean istLebendig(){
        return lebendig;
    }
    
    public int gibSchnabel(){
        return schnabel;
    }
    
    public void toete(){
     lebendig=false;   
    }

}//Ende Klasse: Finken

