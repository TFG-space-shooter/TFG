package com.solarsystem.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.solarsystem.game.Solarsystem;

/**
 * Created by Douglas on 28/07/2015.
 */
public class Preferencias {

    private static Preferences prefs;

    public static int getMayorPuntuacion(){
        return getPrefs().getInteger("mayor_puntuacion");
    }

    public static void setMayorPuntuacion(int puntuacion){
        getPrefs().putInteger("mayor_puntuacion", puntuacion);
        getPrefs().flush();
    }

    private static Preferences getPrefs() {
        if (prefs == null) {
            prefs = Gdx.app.getPreferences("Solarsystem");
        }
        return prefs;
    }
}


////Creo Atributo Preferences
//private static Preferences prefes;
////Tambi�n creo una instancia de game, por si necesito acceder a alguna variable general del juego.
//Solarsystem game;
//
//
//
////Metodo Constructor
//  public Preferencias(Solarsystem game){
//  this.game = game;
//  }
//  
////Aqui instancio mi atributo preferences, basta con acceder a Gdx.app.getPreferences("nombre")
////El nombre puede ser cualquiera, aunque es recomendable usar el mismo nombre de tu aplicacion.
//
//    public void GetPreferences(){
//        prefes = Gdx.app.getPreferences("Solarsystem");        
//  }
//
////Aqui se a�aden los m�todos de Guardar o Traerse datos.
// 
//  public static int getMayorPuntuacion(){
//      if (prefes != null) {
//  return prefes.getInteger("mayorPuntuacion");
//      }else{
//    	  return 0;
//      }
//}
//
//  public static void setMayorPuntuacion(int puntuacion){
//	prefes.putInteger("mayorPuntuacion", puntuacion);
//    prefes.flush();
//}
//}
