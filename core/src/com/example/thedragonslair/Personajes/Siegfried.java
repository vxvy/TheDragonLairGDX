package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.actions.*;

import static com.example.thedragonslair.AssetsCode.AssetsPaths.*;

public class Siegfried extends BaseActor {
    public enum eSiegState{
        ANDANDO(SIEGFRIED_WALKING_PATH),
        SALTANDO(SIEGFRIED_JUMPING_PATH),
        MURIENDO(SIEGFRIED_DYING_PATH),
        PARADO(SIEGFRIED_STANDING_PATH),
        LOGRO(SIEGFRIED_ACHIVEMENT_PATH),
        GOLPEANDO(SIEGFRIED_HITTING_PATH),
        HERIDO(SIEGFRIED_HURT_PATH);

        private String spritesPath;
        private eSiegState(String spritesPath){
            this.spritesPath = spritesPath;
        }
        public String getSpritesPath() {
            return spritesPath;
        }
    }


    private eSiegState state;
    public void setState(eSiegState state) {
        this.state = state;
        this.setTexture(assetManager.get(state.spritesPath,Texture.class));

        switch (state){
            default:
            case ANDANDO:
                this.setTextureRegions( 64,64,7, 5);
                break;
            case GOLPEANDO:
                this.setTextureRegions( 64,64,5, 5);
                break;
            case HERIDO:
                this.setTextureRegions( 64,64,3, 1);
                break;
            case LOGRO:
                this.setTextureRegions( 64,64,2, 1);
                break;
            case MURIENDO:
                this.setTextureRegions( 64,64,5, 1);
                break;
            case PARADO:
                this.setTextureRegions(64,64,1, 5);
                break;
            case SALTANDO:
                this.setTextureRegions( 64,64,1, 5);
                break;
        }
    }
    public eSiegState getState() {
        return state;
    }

    private AssetManager assetManager;
    public AssetManager getAssetManager() {
        return assetManager;
    }
    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    /**
     * *********************************************
     *  CONSTRUCTOR
     * *********************************************
     *
     * Vacío, hay que indicarle el estado por defecto del personaje a machete
     *
     * */

    public Siegfried(){
        boundsRect = new Rectangle(posXIni, posYIni, posXFin, posYFin); //el listener funciona sólo después de asignar los bounds
        setState(eSiegState.PARADO);

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.clearActions();


        //hay que gestionar el tiempo en que se ejecuta esto para que no vaya demasiado rápido
        this.addAction(Actions.moveTo(screenX,screenY));
        return true;
    }
}