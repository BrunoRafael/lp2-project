package persistency;

import java.io.IOException;
import java.io.Serializable;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import music.Music;

public class PersistentMusic extends Music implements Serializable {

	/**
	 * Serializable class version number.
	 * Value: 2.
	 */
	private static final long serialVersionUID = 2L;

	public PersistentMusic(String path) throws CannotReadException,
			IOException, TagException, ReadOnlyFileException,
			InvalidAudioFrameException {
		super(path);
	}

}
