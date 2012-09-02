package music;

import java.util.LinkedList;

/**
 * Class representing a Playlist. It can be populated with PlaylistMusic objects, thus forming a playlist.
 * @author andreluiz
 *
 */
public class Playlist {

	/**
	 * Linked list of PlaylistMusic objects.
	 */
	private LinkedList<PlaylistMusic> musics;
	
	/**
	 * Name of the playlist.
	 */
	private String name;
	
	/**
	 * This will create a Playlist object with an empty LinkedList of PlaylistMusic objects.
	 * @param name name of the playlist.
	 */
	public Playlist(String name) {
		this(name, new LinkedList<PlaylistMusic>());
	}

	/**
	 * Useful this constructor to clone playlists's content and change the name.
	 * @param name Name of the new Playlist.
	 * @param pl LinkedList of PlaylistMusic objects.
	 */
	public Playlist(String name, LinkedList<PlaylistMusic> pl) {
		this.setName(name);
		this.setMusics(pl);
	}

	/**
	 * Adds a PlaylistMusic object to the Playlist.
	 * @param pl PlaylistMusic to add.
	 */
	public void addPlaylistMusic(PlaylistMusic pl) {
		this.getMusics().add(pl);
	}
	
	/**
	 * Removes the given PlaylistMusic of a Playlist.
	 * @param pl PlaylistMusic to be removed.
	 */
	public void removePlaylistMusic(PlaylistMusic pl) {
		this.getMusics().remove(pl);
	}
	
	/**
	 * 
	 * @return LinkedList with PlaylistMusic objects.
	 */
	public LinkedList<PlaylistMusic> getMusics() {
		return musics;
	}

	/**
	 * 
	 * @param musics LinkedList of PlaylistMusic objects to be used.
	 */
	public void setMusics(LinkedList<PlaylistMusic> musics) {
		this.musics = musics;
	}

	/**
	 * 
	 * @return Name of the playlist.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name Name to be used on the playlist.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Playlist [musics=" + this.getMusics().size() + ", name=" + name + "]";
	}

}
