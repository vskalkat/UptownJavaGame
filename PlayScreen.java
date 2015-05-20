package com.website.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.website.game.Airplane;
import com.website.game.MainScreen;
import com.website.game.Wall;
import com.website.game.Wall2;
import com.website.game.WallCut;
import com.website.game.WallCut2;

public class PlayScreen implements Screen {
	
	private SpriteBatch batch;
	private Texture background;
	Airplane airplane;
	
	Wall wall;
	WallCut wallCut;
	
	Wall2 wall2;
	WallCut2 wallCut2;
	Rectangle WidthBounds;
	Rectangle Width2Bounds;
	
	BitmapFont Scorefont;
	int score;
	
	Texture buttonright;
	Texture buttonleft;
	
	Game game;
	
	
	public PlayScreen(Game game){
		this.game=game;
	}
	
	

	@Override
	public void show() {
		batch = new SpriteBatch();
		background=new Texture(Gdx.files.internal("UpTownBg.png"));
	
		airplane = new Airplane("airplaneSpritesheet.png");
		wall = new Wall("blackwall.png");
		wallCut = new WallCut("blackwall.png");
		wall2 = new Wall2("blackwall.png");
		wallCut2 = new WallCut2("blackwall.png");
		
		WidthBounds=new Rectangle(wallCut.position.x, wallCut.position.y, 50, 40);
		Width2Bounds=new Rectangle(wallCut2.position.x, wallCut2.position.y, 50, 40);
		
		Scorefont=new BitmapFont(Gdx.files.internal("data/fonts/arial-15.fnt"), Gdx.files.internal("data/fonts/arial-15.png"), false, true);
		Scorefont.setColor(Color.ORANGE);
		
		
		score=0;
		
		
	}
	
	

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		airplane.update();
		wall.update();
		wallCut.update();
		wall2.update();
		wallCut2.update();
		
		
		float x2 = wall.width+200;
		float width = Gdx.graphics.getWidth()-x2;
		
		float x4 = wall2.width+200;
		float width2 = Gdx.graphics.getWidth()-x4;

		WidthBounds.set(x2, wall.position.y, width, 40);
		Width2Bounds.set(x4, wall2.position.y, width2, 40);
		
		batch.begin();
		
		batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(airplane.currentFrame, airplane.position.x, airplane.position.y);
		
		batch.draw(wall.wallTexture, wall.position.x, wall.position.y, wall.width, 40);
		batch.draw(wallCut.wallCutTexture, x2, wall.position.y, width, 40);
		
		batch.draw(wall2.wallTexture, wall2.position.x, wall2.position.y, wall2.width, 40);
		batch.draw(wallCut2.wallCutTexture, x4, wall2.position.y, width2, 40);
		
		Scorefont.draw(batch, "Score: "+(wall.score+wall2.score2), Gdx.graphics.getWidth()-150, Gdx.graphics.getHeight()-20);
		
		
		
		batch.end();
		
		
		
		
		if(airplane.AirplaneBounds.overlaps(wall.WallBounds) || airplane.AirplaneBounds.overlaps(wall2.Wall2Bounds) || airplane.AirplaneBounds.overlaps(WidthBounds) || airplane.AirplaneBounds.overlaps(Width2Bounds)){
			System.out.println("HIT!");
			wall.score=0;
			wall2.score2=0;
			game.setScreen(new MainScreen(game));
			
		}
		
	}
	
	

	@Override
	public void resize(int width, int height) {
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
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		Scorefont.dispose();
	}

}
