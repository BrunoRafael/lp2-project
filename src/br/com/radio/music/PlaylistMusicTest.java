package br.com.radio.music;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.junit.Test;

public class PlaylistMusicTest {

	@Test
	public void testPlaylistMusic() {
		try {
			PlaylistMusic pl = new PlaylistMusic("/home/andreluiz/a.mp3");
		} catch (CannotReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetQualification() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQualification() {
		fail("Not yet implemented");
	}

}
