package br.com.radio.facade;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import br.com.radio.authentication.Authentication;
import br.com.radio.exception.AuthenticationFailedException;

public class Facade {
	
	private static Facade facade;
	
	private Authentication authentication;
	
	
	public Facade(){
		authentication = new Authentication();
	}
	
	public static Facade getInstance(){
		if(facade == null){
			facade = new Facade();
		}
		return facade;
	}
	
	public void login(final String login, final String password, AsyncHandler<Boolean> callback )throws AuthenticationFailedException{
		callback.handleResponse(new Response<Boolean>() {
			
			@Override
			public boolean isDone() {
				return false;
			}
			
			@Override
			public boolean isCancelled() {
				return false;
			}
			
			@Override
			public Boolean get(long arg0, TimeUnit arg1) throws InterruptedException,
					ExecutionException, TimeoutException {
				return null;
			}
			
			@Override
			public Boolean get() throws InterruptedException, ExecutionException {
				try {
					return authentication.authenticate(login, password);
				} catch (AuthenticationFailedException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			@Override
			public boolean cancel(boolean arg0) {
				return false;
			}
			
			@Override
			public Map<String, Object> getContext() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
	}
		
//		List<PlaylistMusic> musics = new LinkedList<PlaylistMusic>();
//		Playlist musicsList = new Playlist("Lista 1");
//				
//		String path = "/home/bruno/Documentos/Felipão e Banda - 2011/";
//		try {
//			PlaylistMusic music1 = new PlaylistMusic(path + "01. Aumenta o Som.mp3");
//			PlaylistMusic music2 = new PlaylistMusic(path + "02. Meu Paredão é de Jesus.mp3");
//			PlaylistMusic music3 = new PlaylistMusic(path + "03. Gosto de Jeová.mp3");
//			PlaylistMusic music4 = new PlaylistMusic(path + "04. Eu Sou Vencedor.mp3");
//			PlaylistMusic music5 = new PlaylistMusic(path + "05. Andava Sozinho.mp3");
//			PlaylistMusic music6 = new PlaylistMusic(path + "06. Faz Chover.mp3");
//			PlaylistMusic music7 = new PlaylistMusic(path + "07. Viver Pra Mim é Cristo.mp3");
//			PlaylistMusic music8 = new PlaylistMusic(path + "08. Sou Humano.mp3");
//			PlaylistMusic music9 = new PlaylistMusic(path + "09. É Desse Jeito (Achei Razão Para Viver).mp3");
//			
//			musics.add(music1);
//			musics.add(music2);
//			musics.add(music3);
//			musics.add(music4);
//			musics.add(music5);
//			musics.add(music6);
//			musics.add(music7);
//			musics.add(music8);
//			musics.add(music9);
//			musicsList.addPlayListMusic(musics);
//						
//			musicsList.playList(1);			
//			musicsList.playList(5);
//			
//			
//			
//		} catch (CannotReadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TagException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ReadOnlyFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidAudioFrameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
}


