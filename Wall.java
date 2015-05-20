package com.website.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall {
	
	Texture wallTexture;
	Vector2 position;
	
	float statetime;
	
	public int score=0;
	
	float width;
	
	Rectangle WallBounds;
	
	
	public Wall(String textureLoc){
		wallTexture = new Texture(Gdx.files.internal(textureLoc));
		position = new Vector2(0, Gdx.graphics.getHeight());
		
		width = (float) (Math.random()*Gdx.graphics.getWidth()-200);
		if(width<50){
			width = (float) (Math.random()*200);
		}
		
		statetime = 0;
		
		WallBounds=new Rectangle(position.x, position.y, width, wallTexture.getHeight());
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
			position.y=Gdx.graphics.getHeight();
			
			score++;
			
			width = (float) (Math.random()*Gdx.graphics.getWidth()-200);
			if(width<50){
				width = (float) (Math.random()*200);
			}
			
			
		}
		
		WallBounds.set(position.x, position.y, width, wallTexture.getHeight());
	
	}
	
	

}
