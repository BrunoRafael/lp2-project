package music;

import java.io.IOException;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

/**
 * Class that represents a Music object in a playlist.
 * 
 * @author andreluiz
 *
 */
public class PlaylistMusic extends Music {

	/**
	 * Qualification attribute of a music in a playlist.
	 * The default value is 0.
	 */
	private int qualification;
	
	/**
	 * Constructor of a PlaylistMusic object.
	 * @param path Path to the music object.
	 * @throws CannotReadException JAudioTagger related.
	 * @throws IOException 
	 * @throws TagException JAudioTagger related.
	 * @throws ReadOnlyFileException JAudioTagger related.
	 * @throws InvalidAudioFrameException JAudioTagger related.
	 */
	public PlaylistMusic(String path) throws CannotReadException, IOException,
			TagException, ReadOnlyFileException, InvalidAudioFrameException {
		super(path);
		this.setQualification(0);
	}

	/**
	 * 
	 * @return Current qualification score.
	 */
	public int getQualification() {
		return qualification;
	}

	/**
	 * The qualification should be an integer and range from 0 to 5.
	 * @param qualification
	 */
	public void setQualification(int qualification) {
		this.qualification = (qualification > 0 && qualification < 5) ? qualification:
																		0;
	}

	@Override
	public String toString() {
		return "PlaylistMusic [qualification=" + qualification
				+ ", toString()=" + super.toString() + "]";
	}

}
