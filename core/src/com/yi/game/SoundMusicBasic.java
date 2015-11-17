package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SoundMusicBasic extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	// Sound for short sound affect
	Sound sound;
	// Music for long music
	Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		// define Sound and Music
		sound = Gdx.audio.newSound(Gdx.files.internal("lose.wav"));
		music = Gdx.audio.newMusic(Gdx.files.internal("birds_sing_in_woods.wav"));

		music.play();
		// OnCompletionListener Then set it so music plays when music ends, so music loop forever
		music.setOnCompletionListener(new Music.OnCompletionListener() {
			@Override
			public void onCompletion(Music music) {
				music.play();
			}
		});
	}

	@Override
	public void dispose() {
		batch.dispose();
		// dispose sound and music
		sound.dispose();
		music.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.end();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// play sound when press on the screen
		sound.play();
		// play sound when press on the screen
//		music.play();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// pause the music when release finger from screen
//		music.pause();
		// stop the music when release finger from screen
//		music.stop();
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {return false;}
	@Override
	public boolean keyDown(int keycode) {return false;}
	@Override
	public boolean keyUp(int keycode) {return false;}
	@Override
	public boolean keyTyped(char character) {return false;}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {return false;}
	@Override
	public boolean scrolled(int amount) {return false;}
}
