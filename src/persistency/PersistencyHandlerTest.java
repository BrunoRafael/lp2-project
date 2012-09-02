package persistency;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.junit.Test;

public class PersistencyHandlerTest {

	@Test
	public void testPersistencyHandler() {
		PersistencyHandler ph = PersistencyHandler.getInstance();
		ph.loadDb();
		try {
			ph.write(new PersistentMusic("/home/andreluiz/a.mp3"));
			ph.write(new PersistentMusic("/home/andreluiz/b.mp3"));
			ph.write(new PersistentUser("andrelgsl@gmail.com",
										"1234", 24, 8, 1989));				
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
		ph.readMusicBuffer();
		ph.readUserBuffer();
		ph.saveAll();
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadDb() {
		fail("Not yet implemented");
	}

	@Test
	public void testWritePersistentUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testWritePersistentMusic() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetuserDbOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserDbOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetuserFileOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetuserFileOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserFileIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserFileIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserDbIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserDbIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMusicFileOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMusicFileOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMusicFileIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMusicFileIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMusicDbOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMusicDbOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMusicDbIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMusicDbIn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserBuffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserBuffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMusicBuffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMusicBuffer() {
		fail("Not yet implemented");
	}

}
