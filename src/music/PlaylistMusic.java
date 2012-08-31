package music;

import java.io.IOException;

import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

public class PlaylistMusic extends Music {

	private int qualification;
	
	public PlaylistMusic(String path) throws CannotReadException, IOException,
			TagException, ReadOnlyFileException, InvalidAudioFrameException {
		super(path);
		this.setQualification(0);
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = (qualification > 0 && qualification < 5) ? qualification:
																		0;
	}

}
