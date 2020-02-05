package com.example.thedragonslair.AssetsCode;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class AssetsDescriptors {

    public static final AssetDescriptor<BitmapFont> FONT_COMIC_DES = new AssetDescriptor<BitmapFont>(AssetsPaths.FONT_COMIC_PATH, BitmapFont.class);
    public static final AssetDescriptor<Texture> ENEMY_WEAK0_DES = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_WEAK0_PATH, Texture.class);
    public static final AssetDescriptor<TiledMap> MAP_PB_DES = new AssetDescriptor<TiledMap>(AssetsPaths.MAP_PB_PATH, TiledMap.class);

    private AssetsDescriptors() { //no queremos que se instancie
    }
}
