package persistency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import user.Email;


public class PersistencyHandler {

	private static PersistencyHandler instance = null;

	private FileOutputStream userFileOut;
	private FileInputStream userFileIn;
	private ObjectOutputStream userDbOut;
	private ObjectInputStream userDbIn;

	private FileOutputStream musicFileOut;
	private FileInputStream musicFileIn;
	private ObjectOutputStream musicDbOut;
	private ObjectInputStream musicDbIn;
	
	private HashMap<Email, PersistentUser> userBuffer;
	private HashMap<String, PersistentMusic> musicBuffer;
	
	protected PersistencyHandler() {
		this.setUp();
	}
	
	public PersistencyHandler getInstance() {
		if(instance == null)
			instance = new PersistencyHandler();
		return instance;
	}
	
	private void setUp() {
		File tmpUser = null;
		File tmpMusic = null;
		try{
			tmpUser = new File("../res/users.data");
			tmpMusic = new File("../res/musics.data");
			
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
		}
		
		try {
			setUserDbOut(new ObjectOutputStream(userFileOut));
			setUserDbIn(new ObjectInputStream(userFileIn));
			
			setMusicDbOut(new ObjectOutputStream(this.getMusicFileOut()));
			setMusicDbIn(new ObjectInputStream(this.getMusicFileIn()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveAll() {
		try {
			this.getuserDbOut().writeObject(this.getUserBuffer());
			this.getMusicDbOut().writeObject(this.getMusicBuffer());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void write(PersistentUser pu) {
		this.getUserBuffer().put(pu.getEmail(), pu);
	}
	
	public void write(PersistentMusic pm) {
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

	public HashMap<Email, PersistentUser> getUserBuffer() {
		return userBuffer;
	}

	public void setUserBuffer(HashMap<Email, PersistentUser> userBuffer) {
		this.userBuffer = userBuffer;
	}

	public HashMap<String, PersistentMusic> getMusicBuffer() {
		return musicBuffer;
	}

	public void setMusicBuffer(HashMap<String, PersistentMusic> musicBuffer) {
		this.musicBuffer = musicBuffer;
	}



}
