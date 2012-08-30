package music;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class Music {

	//	private static final char SEPARATOR = java.io.File.separatorChar;

	private String name;
	private String artist;
	private String album;
	private String path;
	private String genre;
	private int year;
	private Number duration;

	public Music(String path) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		this.setPath(path);
		File f = new File(path);
		
		AudioFile srcSet = AudioFileIO.read(f);
		Tag tags = srcSet.getTag();


		this.setArtist(tags.getFirst(FieldKey.ARTIST));
		this.setAlbum(tags.getFirst(FieldKey.ALBUM));
		this.setName(tags.getFirst(FieldKey.TITLE));
		this.setYear(tags.getFirst(FieldKey.YEAR));
		this.setGenre(tags.getFirst(FieldKey.GENRE));
		this.setDuration(srcSet.getAudioHeader().getTrackLength());
	}



	
	private void setYear(String year) {
		this.year = new Integer(year);

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Number getDuration() {
		return duration;
	}
	
	public void setDuration(Number number) {
		this.duration = number;
	}
	

}
