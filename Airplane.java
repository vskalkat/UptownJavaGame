package com.website.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Airplane {
	
	Texture playerTexture;
	Vector2 position;
	TextureRegion frames[];
	TextureRegion currentFrame;
	
	final int col=5;
	final int row=1;
	
	Animation animation;
	float statetime;
	
	Rectangle AirplaneBounds;
	
	
public Airplane(String TextureLoc){
		
		playerTexture = new Texture(Gdx.files.internal(TextureLoc));
		
		TextureRegion[][] tmp=TextureRegion.split(playerTexture, playerTexture.getWidth()/col, playerTexture.getHeight()/row);
		frames=new TextureRegion[row*col];
		
		int index=0;
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				frames[index++]=tmp[i][j];
			}
		}
		
		animation=new Animation(1,frames);
		currentFrame=animation.getKeyFrame(2, true);
		statetime=0;
		
		position=new Vector2((Gdx.graphics.getWidth()/2)-50, (Gdx.graphics.getHeight()/2)-70);
		
		AirplaneBounds=new Rectangle(position.x, position.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
		
	}


public void update(){
	
	

	currentFrame=animation.getKeyFrame(2);
	
	if(Gdx.input.isKeyPressed(Keys.A)){
		position.x-=7;
		currentFrame=animation.getKeyFrame(0);
	}
	else if(Gdx.input.isKeyPressed(Keys.D)){
		position.x+=7;
		currentFrame=animation.getKeyFrame(4);
	}
	else if(Gdx.input.isKeyPressed(Keys.W)){
		position.y+=7;
	}else if(Gdx.input.isKeyPressed(Keys.S)){
		position.y-=7;
	}

	AirplaneBounds.set(position.x, position.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
	
	
}
	
	
	

}
