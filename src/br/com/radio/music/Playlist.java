package br.com.radio.music;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a Playlist. It can be populated with PlaylistMusic objects, thus forming a playlist.
 * @author andreluiz
 *
 */
public class Playlist {

	/**
	 * Linked list of PlaylistMusic objects.
	 */
	private List<PlaylistMusic> musics;
	/**
	 * 
	 */
	private boolean isRamdom;
	
	/**
	 * 
	 */
	private boolean repeatReproduction;
	
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
		this.musics.add(pl);
	}
	
	/**
	 * 
	 * @param pl
	 */
	public void addPlayListMusic(List<PlaylistMusic> playList){
		this.musics.addAll(playList);
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
	 * @param pl
	 */
	public void removePlaylistMusic(List<PlaylistMusic> pl){
		this.musics.retainAll(pl);
	}
		
		
	/**
	 * 
	 * @return LinkedList with PlaylistMusic objects.
	 */
	public List<PlaylistMusic> getMusics() {
		return musics;
	}

	/**
	 * 
	 * @param musics LinkedList of PlaylistMusic objects to be used.
	 */
	public void setMusics(List<PlaylistMusic> musics) {
		this.musics = musics;
	}
	
	/* 
	 * This method is implemented differently in the future,
	 * as well as the method of the class play music
	 */
	
	/**
	 * @param indexMusic index of song's played
	 * @param isRamdom indicated if the reproduction is so randomly
	 */

	public void playList(int indexMusic){
		
		// this treatment will be done differently future
		if(getMusics().isEmpty()){
			System.out.println("Não há musicas na lista para reproduzir!");
		}else{				
			 do{
					
				System.out.println("Tocando musica....");
				if(isRamdom)
					indexMusic = executeRandomMusics();
				
				executeNotRandomMusics(indexMusic);
										
				indexMusic = 0; //restart list of songs
			}while(repeatReproduction);
		}
	}

	private boolean executeNotRandomMusics(int indexMusic) {
		for(int i = indexMusic; i < getMusics().size(); i++){
			getMusics().get(i).play();
			if(isRamdom) return true;
		}
		return false;
		
	}

	private int executeRandomMusics() {
		int countMusics = 0;
		int index = 0;
		while(countMusics != getMusics().size()){
			
			index = getAleatoryNumber(index);
			getMusics().get(index).play();
			
			if(!isRamdom) break;
		}
		return index;
		
	}
	
	private int getAleatoryNumber(int beforeIndex){
		int afterIndex;
		do{
			afterIndex = (int)(Math.random() * getMusics().size());
		}while(afterIndex == beforeIndex);
		
		return afterIndex;
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
	
	public boolean isRamdom() {
		return isRamdom;
	}

	public void setRamdom(boolean isRamdom) {
		this.isRamdom = isRamdom;
	}

	public boolean isRepeatReproduction() {
		return repeatReproduction;
	}

	public void setRepeatReproduction(boolean repeatReproduction) {
		this.repeatReproduction = repeatReproduction;
	}

	@Override
	public String toString() {
		return "Playlist [musics=" + this.getMusics().size() + ", name=" + name + "]";
	}

}
