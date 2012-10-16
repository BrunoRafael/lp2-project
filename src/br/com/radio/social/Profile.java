package br.com.radio.social;

import java.util.HashSet;
import java.util.LinkedHashSet;

import br.com.radio.music.Playlist;

/**
 * Class representing a social Profile.
 * Every User owns a Profile, it holds the users playlists and relationships.
 * @author andreluiz
 *
 */
public class Profile {

	/**
	 * Playlists that this profile contains.
	 */
	private LinkedHashSet<Playlist> playlists;
	
	/**
	 * Relations of this profile to other profiles.
	 */
	private HashSet<Profile> relationships;
	
	/**
	 * Default constructor. 
	 * It creates a Profile with empty lists of playlists and relationships.
	 */
	public Profile() {
		this(new LinkedHashSet<Playlist>());
	}
	
	/**
	 * Constructor that creates a Profile with the given LinkedHashSet of playlists and empty relationships.
	 * @param pl LinkedHashSet of playlists.
	 */
	public Profile(LinkedHashSet<Playlist> pl) {
		this(pl, new HashSet<Profile>());
	}
	
	/**
	 * Complete constructor of Profile.
	 * @param pl LinkedHashSet of playlists.
	 * @param rel HashSet of relationships.
	 */
	public Profile(LinkedHashSet<Playlist> pl, HashSet<Profile> rel) {
		this.setPlaylists(pl);
		this.setRelationships(rel);
	}

	/**
	 * Adds a profile in the relationships of a Profile.
	 * @param profile Profile to be added as a relationship.
	 */
	public void addRelation(Profile profile) {
		this.getRelationships().add(profile);
	}
	
	/**
	 * Removes a profile from the relationships of a Profile.
	 * @param profile Profile to be removed.
	 */
	public void removeRelation(Profile profile) {
		this.getRelationships().remove(profile);
	}
	
	/**
	 * Adds a Playlist to the profile.
	 * @param pl Playlist to be added.
	 */
	public void addPlaylist(Playlist pl) {
		this.getPlaylists().add(pl);
	}
	
	/**
	 * Removes a Playlist from the profile.
	 * @param pl Playlist to be removed.
	 */
	public void removePlaylist(Playlist pl) {
		this.getPlaylists().remove(pl);
	}
	
	/**
	 * 
	 * @return LinkedHashSet of playlists.
	 */
	public LinkedHashSet<Playlist> getPlaylists() {
		return playlists;
	}

	/**
	 * 
	 * @param playlists LinkedHashSet of playlists to be used.
	 */
	public void setPlaylists(LinkedHashSet<Playlist> playlists) {
		this.playlists = playlists;
	}

	/**
	 * 
	 * @return HashSet of profiles representing the relationships of this Profile.
	 */
	public HashSet<Profile> getRelationships() {
		return relationships;
	}

	/**
	 * 
	 * @param relationships HashSet of profiles to represent this Profile relationships.
	 */
	public void setRelationships(HashSet<Profile> relationships) {
		this.relationships = relationships;
	}

	@Override
	public String toString() {
		return "Profile [playlists=" + this.getPlaylists() + ", relationships="
				+ this.getRelationships() + "]";
	}

}
