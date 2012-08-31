package persistency;

import java.io.IOException;
import java.io.Serializable;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import music.Music;

/**
 * Class that makes Music serializable.
 * @author andreluiz
 *
 */
public class PersistentMusic extends Music implements Serializable {

	/**
	 * Serializable class version number.
	 * Value: 2.
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Constructor of PersistentMusic
	 * @param path Path to the audio file.
	 * @throws CannotReadException
	 * @throws IOException
	 * @throws TagException
	 * @throws ReadOnlyFileException
	 * @throws InvalidAudioFrameException
	 */
	
	public PersistentMusic(String path) throws CannotReadException,
			IOException, TagException, ReadOnlyFileException,
			InvalidAudioFrameException {
		super(path);
	}

}
