package com.website.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class WallCut2 {
	
	Texture wallCutTexture;
	Vector2 position;
	
	float width;
	
	Rectangle WallCut2Bounds;
	
	public WallCut2(String textureLoc){
		wallCutTexture = new Texture(Gdx.files.internal(textureLoc));
		position = new Vector2(0, Gdx.graphics.getHeight());
		
		width = (float) (Math.random()*200);
		if(width<50){
			width = (float) (Math.random()*200);
		}
		
		WallCut2Bounds=new Rectangle(position.x, position.y, wallCutTexture.getWidth(), wallCutTexture.getHeight());
		
	}
	
	public void update(){
		position.y-=3;
		
		if (position.y<-40){
			position.y=Gdx.graphics.getHeight();
		}
		
		WallCut2Bounds.set(position.x, position.y, wallCutTexture.getWidth(), wallCutTexture.getHeight());
		
	}

}
