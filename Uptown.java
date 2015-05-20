package com.website.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.website.game.MainScreen;

public class Uptown extends Game {
	
	Game game;
	
	@Override
	public void create() {		
		
		game=this;
		setScreen(new MainScreen(game));
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
