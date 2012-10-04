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

/**
 * Class representing a music object.
 * This will be used on PersistentMusic class.
 * @author andreluiz
 *
 */

//sdgfdggggggggggggggggggggggggggggggggggggggggggggggggggggggg
public class Music {

	/**
	 * Song's name.
	 */
	private String name;
	
	/**
	 * Artist's name.
	 */
	private String artist;
	
	/**
	 * Song's album.
	 */
	private String album;
	
	/**
	 * Path to the audio file.
	 */
	private String path;
	
	/**
	 * Song's genre.
	 */
	private String genre;
	
	/**
	 * Song's release year.
	 */
	private int year;
	
	/**
	 * Song's duration in seconds.
	 */
	private Number duration;

	/**
	 * Constructor of a Music object.
	 * @param path Path to the audio file.
	 * @throws CannotReadException
	 * @throws IOException
	 * @throws TagException
	 * @throws ReadOnlyFileException
	 * @throws InvalidAudioFrameException
	 */
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

	/**
	 * 
	 * @param year Year of the song.
	 */
	public void setYear(String year) {
		this.year = new Integer(year);
	}
	
	/**
	 * 
	 * @return Song's year.
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * 
	 * @return Song's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name Name of the song.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return Artist.
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * 
	 * @param artist Artist.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * 
	 * @return Song's album.
	 */
	public String getAlbum() {
		return album;
	}
	
	/**
	 * 
	 * @param album Album to be set.
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
	/**
	 * 
	 * @return Path of the audio file.
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * 
	 * @param path Path of the audio file.
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * 
	 * @return Song's genre.
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * 
	 * @param genre Genre of the song.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * 
	 * @return Song's duration in seconds.
	 */
	public Number getDuration() {
		return duration;
	}
	
	/**
	 * 
	 * @param number Song's duration in seconds.
	 */
	public void setDuration(Number number) {
		this.duration = number;
	}
	
	public void play(){
		
	}
}
