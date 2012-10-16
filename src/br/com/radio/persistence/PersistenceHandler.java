package br.com.radio.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;

import br.com.radio.user.Email;



public class PersistenceHandler {

	private static PersistenceHandler instance = null;

	private FileOutputStream userFileOut;
	private FileInputStream userFileIn;
	private ObjectOutputStream userDbOut;
	private ObjectInputStream userDbIn;

	private FileOutputStream musicFileOut;
	private FileInputStream musicFileIn;
	private ObjectOutputStream musicDbOut;
	private ObjectInputStream musicDbIn;
	
	private HashMap<Email, UserPersisted> userBuffer;
	private HashMap<String, MusicPersisted> musicBuffer;
	
	public PersistenceHandler() {
		this.setUp();
	}
	
	public static PersistenceHandler getInstance() {
		if(instance == null)
			instance = new PersistenceHandler();
		return instance;
	}
	
	private void setUp() {
		File tmpUser = null;
		File tmpMusic = null;
		try{
			tmpUser = new File("res/users.data");
			tmpMusic = new File("res/musics.data");
			this.setuserFileOut(new FileOutputStream(tmpUser));
			this.setUserFileIn(new FileInputStream(tmpUser));
			this.setMusicFileOut(new FileOutputStream(tmpMusic));
			this.setMusicFileIn(new FileInputStream(tmpMusic));
			
		} catch (FileNotFoundException e) {
			if(!tmpUser.exists())
				try {
					tmpUser.createNewFile();
					this.setuserFileOut(new FileOutputStream(tmpUser));
					this.setUserFileIn(new FileInputStream(tmpUser));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			else if(!tmpMusic.exists())
				try {
					tmpMusic.createNewFile();
					this.setMusicFileOut(new FileOutputStream(tmpMusic));
					this.setMusicFileIn(new FileInputStream(tmpMusic));
				} catch (IOException e2) {
					e.printStackTrace();
				}
		} catch (Exception eof) {
			this.setMusicBuffer(new HashMap<String, MusicPersisted>());
			this.setUserBuffer(new HashMap<Email, UserPersisted>());
		}
		
		try {
			setUserDbOut(new ObjectOutputStream(userFileOut));
			setUserDbIn(new ObjectInputStream(userFileIn));
			
			setMusicDbOut(new ObjectOutputStream(this.getMusicFileOut()));
			setMusicDbIn(new ObjectInputStream(this.getMusicFileIn()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveAll() {
		try {
			this.getuserDbOut().writeObject(this.getUserBuffer());
			this.getMusicDbOut().writeObject(this.getMusicBuffer());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void loadDb() {
		try {
			this.setMusicBuffer((HashMap<String, MusicPersisted>)
								 this.getMusicDbIn().readObject());
			this.setUserBuffer((HashMap<Email, UserPersisted>)
								this.getUserDbIn().readObject());
		} catch (IOException e) {
			this.setMusicBuffer(new HashMap<String, MusicPersisted>());
			this.setUserBuffer(new HashMap<Email, UserPersisted>());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	public void write(UserPersisted pu) {
		this.getUserBuffer().put(pu.getEmail(), pu);
	}
	
	public void write(MusicPersisted pm) {
		this.getMusicBuffer().put(pm.getPath(), pm);
	}
	
	public ObjectOutputStream getuserDbOut() {
		return userDbOut;
	}

	public void setUserDbOut(ObjectOutputStream userDbOut) {
		this.userDbOut = userDbOut;
	}

	public FileOutputStream getuserFileOut() {
		return userFileOut;
	}

	public void setuserFileOut(FileOutputStream userFileOut) {
		this.userFileOut = userFileOut;
	}

	public FileInputStream getUserFileIn() {
		return userFileIn;
	}

	public void setUserFileIn(FileInputStream userFileIn) {
		this.userFileIn = userFileIn;
	}

	public ObjectInputStream getUserDbIn() {
		return userDbIn;
	}

	public void setUserDbIn(ObjectInputStream userDbIn) {
		this.userDbIn = userDbIn;
	}

	public FileOutputStream getMusicFileOut() {
		return musicFileOut;
	}

	public void setMusicFileOut(FileOutputStream musicFileOut) {
		this.musicFileOut = musicFileOut;
	}

	public FileInputStream getMusicFileIn() {
		return musicFileIn;
	}

	public void setMusicFileIn(FileInputStream musicFileIn) {
		this.musicFileIn = musicFileIn;
	}

	public ObjectOutputStream getMusicDbOut() {
		return musicDbOut;
	}

	public void setMusicDbOut(ObjectOutputStream musicDbOut) {
		this.musicDbOut = musicDbOut;
	}

	public ObjectInputStream getMusicDbIn() {
		return musicDbIn;
	}

	public void setMusicDbIn(ObjectInputStream musicDbIn) {
		this.musicDbIn = musicDbIn;
	}

	public HashMap<Email, UserPersisted> getUserBuffer() {
		return userBuffer;
	}

	public void setUserBuffer(HashMap<Email, UserPersisted> userBuffer) {
		this.userBuffer = userBuffer;
	}

	public HashMap<String, MusicPersisted> getMusicBuffer() {
		return musicBuffer;
	}

	public void setMusicBuffer(HashMap<String, MusicPersisted> musicBuffer) {
		this.musicBuffer = musicBuffer;
	}

	public void readMusicBuffer() {
		for(String k: this.getMusicBuffer().keySet())
			System.out.println(k + " " + this.getMusicBuffer().get(k));
	}
	
	public void readUserBuffer() {
		for(Email e: this.getUserBuffer().keySet())
			System.out.println(this.getUserBuffer().get(e));
	}

}

/*
 * public String[] getUnifilarNames() {
		File[] files = new File(getUnifilarsPath())
			   .listFiles(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return !name.startsWith(".");
					}
				});
		String[] unifilarNames = new String[files.length];
		for (int pos = 0; pos < files.length; pos++) {
			// unifilarNames[pos] = getAcronymSubstation(files[pos].getName());
			unifilarNames[pos] = files[pos].getName();
		}
		Arrays.sort(unifilarNames);
		return unifilarNames;

	}
*/
