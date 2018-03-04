import java.util.*;
/**
 *
 */
public class Simulation 
{
    /* Attribute */
    private Insel[] inseln;
    /* Methoden */
    /**  */
    public Simulation(){
        inseln = new Insel[14];
        generiereInseln();
        berechneObLebt();
    }

    public void simuliere(int dauer){
        for(int i=0;i<dauer;i++){
         bewegeFinkenVonFeld();
         paare();
         berechneObLebt();
        }
    }

    private void generiereInseln()
    {
        inseln[0] = new Insel(1000,459,"Isabela");
        inseln[1] = new Insel(400,246,"Santa Cruz");
        inseln[2] = new Insel(250,257,"Fernandina");
        inseln[3] = new Insel(300,195,"San Salvador");
        inseln[4] = new Insel(500,112,"San Cristóbal");
        inseln[5] = new Insel(125,138,"Floreana");
        inseln[6] = new Insel(110,119,"Marchena");
        inseln[7] = new Insel(95,64,"Española");
        inseln[8] = new Insel(95,63,"Pinta");
        inseln[9] = new Insel(70,37,"Baltra");
        inseln[10] = new Insel(60,40,"Santa Fé");
        inseln[11] = new Insel(40,46,"Pinzón");
        inseln[12] = new Insel(38,38,"Genovesa");
        inseln[13] = new Insel(10,11,"Darwin");
    }

    private void bewegeFinkenVonFeld(){
        for(int i=0;i<inseln.length;i++){

            for(int iii=0;iii<inseln[i].felder.length;iii++){
                for (int iiii=0;iiii<inseln[i].felder[iii].length;iiii++){
                    if(inseln[i].felder[iii][iiii].fink1!=null){
                        if(inseln[i].felder[iii][iiii].fink1.istLebendig()==true){
                            pruefeBewegeFinkVonFeld(inseln[i].felder[iii][iiii].fink1,inseln[i].felder[iii][iiii].gibVegetation(),iii,iiii,inseln[i]);
                        }
                    }
                    if(inseln[i].felder[iii][iiii].fink2!=null){
                        if(inseln[i].felder[iii][iiii].fink2.istLebendig()==true){
                            pruefeBewegeFinkVonFeld(inseln[i].felder[iii][iiii].fink2,inseln[i].felder[iii][iiii].gibVegetation(),iii,iiii,inseln[i]);
                        }
                    }
                    if(inseln[i].felder[iii][iiii].fink3!=null){
                        if(inseln[i].felder[iii][iiii].fink3.istLebendig()==true){
                            pruefeBewegeFinkVonFeld(inseln[i].felder[iii][iiii].fink3,inseln[i].felder[iii][iiii].gibVegetation(),iii,iiii,inseln[i]);
                        }
                    }
                }
            }           

        }
    }

    private void pruefeBewegeFinkVonFeld(Finken pFink, int pVegetation, int id ,int id2, Insel il){
        Random rg=new Random();
        if(pFink.gibSchnabel()<=25){
            if(pVegetation==3){}
            if(pVegetation==0){
                int z=rg.nextInt(2);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==1){
                int z=rg.nextInt(3);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==2){
                bewege(pFink,id,id2,il,0);
            }
        }
        else if(pFink.gibSchnabel()<=50&&pFink.gibSchnabel()>25){
            if(pVegetation==0){}
            if(pVegetation==3){
                int z=rg.nextInt(2);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==1){
                int z=rg.nextInt(3);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==2){
                bewege(pFink,id,id2,il,0);
            }
        }
        else if(pFink.gibSchnabel()<=75&&pFink.gibSchnabel()>50){
            if(pVegetation==1){}
            if(pVegetation==2){
                int z=rg.nextInt(2);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==0){
                int z=rg.nextInt(3);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==3){
                bewege(pFink,id,id2,il,0);
            }
        }
        else if(pFink.gibSchnabel()<=100&&pFink.gibSchnabel()>75){
            if(pVegetation==2){}
            if(pVegetation==1){
                int z=rg.nextInt(2);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==0){
                int z=rg.nextInt(3);
                if(z!=0){
                    bewege(pFink,id,id2,il,0);
                }
            }
            if(pVegetation==3){
                bewege(pFink,id,id2,il,0);
            }
        }
    }

    private void bewege(Finken pFink, int feldnummer, int fn, Insel pInsel,int pdurchlauf){
        Random rg=new Random();
        int z =rg.nextInt(4);
        int durchlauf=pdurchlauf;
        if(durchlauf>3){
            bewegeAufAndereInsel( pFink,feldnummer,fn,pInsel) ; 
        }
        else if(z==0){
            if(fn-1>=0){
                if(pInsel.felder[feldnummer][fn-1].fink1==null) {
                    pInsel.felder[feldnummer][fn-1].fink1=pFink;
                }
                else if(pInsel.felder[feldnummer][fn-1].fink2==null) {
                    pInsel.felder[feldnummer][fn-1].fink2=pFink;
                }
                else if(pInsel.felder[feldnummer][fn-1].fink3==null) {
                    pInsel.felder[feldnummer][fn-1].fink3=pFink;
                }
            }
            else{
                bewege(pFink,feldnummer,fn,pInsel,durchlauf);
            }
        }
        else if(z==1){
            if(pInsel.gibHoehe()>fn+1){
                if(pInsel.felder[feldnummer][fn+1].fink1==null) {
                    pInsel.felder[feldnummer][fn+1].fink1=pFink;
                }
                else if(pInsel.felder[feldnummer][fn+1].fink2==null) {
                    pInsel.felder[feldnummer][fn+1].fink2=pFink;
                }
                else if(pInsel.felder[feldnummer][fn+1].fink3==null) {
                    pInsel.felder[feldnummer][fn+1].fink3=pFink;
                }
            }
            else{
                bewege(pFink,feldnummer,fn,pInsel,durchlauf);
            }
        }
        else if(z==2){
            if(feldnummer-1>=0){
                if(pInsel.felder[feldnummer-1][fn].fink1==null) {
                    pInsel.felder[feldnummer-1][fn].fink1=pFink;
                }
                else if(pInsel.felder[feldnummer-1][fn].fink2==null) {
                    pInsel.felder[feldnummer-1][fn].fink2=pFink;
                }
                else if(pInsel.felder[feldnummer-1][fn].fink3==null) {
                    pInsel.felder[feldnummer-1][fn].fink3=pFink;
                }
            }
            else{
                bewege(pFink,feldnummer,fn,pInsel,durchlauf);
            }
        }
        else if(z==2){
            if(pInsel.gibHoehe()>feldnummer+1){
                if(pInsel.felder[feldnummer+1][fn].fink1==null) {
                    pInsel.felder[feldnummer+1][fn].fink1=pFink;
                }
                else if(pInsel.felder[feldnummer+1][fn].fink2==null) {
                    pInsel.felder[feldnummer+1][fn].fink2=pFink;
                }
                else if(pInsel.felder[feldnummer+1][fn].fink3==null) {
                    pInsel.felder[feldnummer+1][fn].fink3=pFink;
                }
            }
            else{
                bewege(pFink,feldnummer,fn,pInsel,durchlauf);
            }
        }
    }

    private void bewegeAufAndereInsel(Finken pFink, int feldnummer, int fn, Insel pInsel){
        int aFeldnummer=feldnummer;
        int aFn=fn;
        Insel aInsel=pInsel;
        if(pInsel.felder[feldnummer][fn].fink1==null) {
            pInsel.felder[feldnummer][fn].fink1=pFink;
        }
        else if(pInsel.felder[feldnummer][fn].fink2==null) {
            pInsel.felder[feldnummer][fn].fink2=pFink;
        }
        else if(pInsel.felder[feldnummer][fn].fink3==null) {
            pInsel.felder[feldnummer][fn].fink3=pFink;
        }
        else {
            bewegeAufAndereInsel(pFink, feldnummer+1, fn, aInsel);
        }
    }

    /**  */
    private void paare(){
        for(int i=0;i<inseln.length;i++){
            for(int ii=0;ii<inseln[i].felder.length;ii++){
                for (int iii=0;iii<inseln[i].felder[ii].length;iii++){
                    inseln[i].felder[ii][iii].pruefePaaren();
                }
            }
        }
    }

    /**  */
    private void berechneObLebt(){
        for(int i=0;i<inseln.length;i++){
            for(int ii=0;ii<inseln[i].felder.length;ii++){
                for (int iii=0;iii<inseln[i].felder[ii].length;iii++){
                    inseln[i].felder[ii][iii].pruefePaaren();
                }
            }
        }
    }

}//Ende Klasse: Simulation

