package com.website.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.website.game.PlayScreen;

public class MainScreen implements Screen{
	
	Game game;
	
	private SpriteBatch batch;
	private Texture background;
	private Stage stage;
	
	BitmapFont Menufont;
	LabelStyle style;
	Label label;
	
	
	public MainScreen(Game game){
		this.game=game;
	}

	 
	
	
	@Override
	public void render(float delta) {
		 Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	     
	     batch.begin();
	     batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	     batch.end();
	     
	     stage.draw();
		
	}

	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void show() {
		
		batch = new SpriteBatch();
		background=new Texture(Gdx.files.internal("UpTownBg2.png"));
		
		stage = new Stage();
	        
	     Menufont=new BitmapFont(Gdx.files.internal("data/fonts/arial-15.fnt"), Gdx.files.internal("data/fonts/arial-15.png"), false, true);
	     style=new LabelStyle(Menufont, Color.ORANGE);
	     label=new Label("Click to Play!", style);
	     label.setFontScale((float) 2.4);
	     label.setPosition((Gdx.graphics.getWidth()/2)-100, Gdx.graphics.getHeight()/2+50);
	     stage.addActor(label);

	     
	     Gdx.input.setInputProcessor(stage);
	  
	     label.addListener(new InputListener(){
	    	 public boolean touchDown(InputEvent event, float x, float y, int pointer, int label){
	    		game.setScreen(new PlayScreen(game));
	    	 	System.out.println("Clicked");
	    	 	return true;
	    	 }
	    });
	     
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		batch.dispose();
		
	}

}
