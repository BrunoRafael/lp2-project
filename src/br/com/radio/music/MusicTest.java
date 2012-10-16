package br.com.radio.music;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.junit.Test;

public class MusicTest {

	@Test
	public void testMusic() throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		Music m = new Music("/home/bruno/music.mp3");
		System.out.println(m.getArtist());
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArtist() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetArtist() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAlbum() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAlbum() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGenre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGenre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDuration() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDuration() {
		fail("Not yet implemented");
	}

}
