package com.website.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall2 {
	
	
	Texture wallTexture;
	Vector2 position;
	public int score2=0;
	float statetime;
	float width;
	
	Rectangle Wall2Bounds;
	
	public Wall2(String textureLoc){
		wallTexture = new Texture(Gdx.files.internal(textureLoc));
		position = new Vector2(0, (float) (Gdx.graphics.getHeight()*1.5));
		
		width = (float) (Math.random()*Gdx.graphics.getWidth()-200);
		if(width<50){
			width = (float) (Math.random()*200);
		}
		
		Wall2Bounds=new Rectangle(position.x, position.y, width, wallTexture.getHeight());
		
	}
	
	public void update(){
		position.y-=1;
		
		statetime+=Gdx.graphics.getDeltaTime();
		if(statetime>20){
			position.y-=1.5;
		}
		
		if(statetime>50){
			position.y-=2;
		}
		
		if (position.y<-40){
			position.y=(float) (Gdx.graphics.getHeight());
			
			score2++;
			width = (float) (Math.random()*Gdx.graphics.getWidth()-200);
			if(width<50){
				width = (float) (Math.random()*200);
			}
		
			
		}
		
		Wall2Bounds.set(position.x, position.y, width, wallTexture.getHeight());
		
	}
	
	

}
