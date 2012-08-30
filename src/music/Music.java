package music;

public class Music {
	
	private static final char SEPARATOR = java.io.File.separatorChar;
	
	private String name;
	private String artist;
	private String cd;
	private String path;
	private int year;
	private float duration;
	
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
	
	public String getCd() {
		return cd;
	}
	
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public float getDuration() {
		return duration;
	}
	
	public void setDuration(float duration) {
		this.duration = duration;
	}
	

}
