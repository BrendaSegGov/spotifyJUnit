package test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class buscarCancion extends BaseTest {

	@Test
	@FileParameters("./data/searchsongparameters.csv")
	public void testSearchSong(String url, String usuario, String password, String songName) {
		navegarPagina(url);
		loginSpotifyConFacebook(usuario,password);
		validarHomePage();
		buscarCancion(songName);
		validarCancionTopResult(songName);
		cerrarBrowser();	
		
	}
	@Test
	@FileParameters("./data/searchartistparameters.csv")
	public void testPlaySong(String url, String usuario, String password, String artistName) {
		navegarPagina(url);
		loginSpotifyConFacebook(usuario,password);
		validarHomePage();
		buscarArtista(artistName);
		validarArtistaTopResult(artistName);
		cerrarBrowser();	
	}

	
	
}
