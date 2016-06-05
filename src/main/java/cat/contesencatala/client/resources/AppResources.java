package cat.contesencatala.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.resources.client.ClientBundleWithLookup;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.cellview.client.CellList;

public interface AppResources extends ClientBundleWithLookup, CellList.Resources  {
    
	interface MyOverride extends CssResource {
		
		 
    }
	
	

    interface Style extends CssResource{
    	String closeIcon();
    	String hideTale();
    	String taleList();
        String taleStar();
        String taleButton();
        String floatLeft();
        String floatRight();
        String readerCard();
        String main();
        String cardTitle();
        String content();
        String search();
        String about();
		String favorite();
		String homeButton();
        
    }	
   
    @Source("css/style.gss")
    Style style();
    
        
    
    /**APP IMAGES*/
    @Source("appimg/background.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource background();
    /*@NotStrict
    @Source("css/myoverride.gss")
    MyOverride override();*/
    
    /**TALES**/
    
    @Source("texts/aneguetlleig.txt")
    TextResource  aneguetlleig();
    
    @Source("texts/caputxeta.txt" )
    TextResource  caputxeta();
    
    
    
    @Source("texts/flautista.txt")
    TextResource  flautista();
    
    @Source("texts/gatbotes.txt")
    TextResource  gatbotes();
    
    @Source("texts/musics.txt")
    TextResource  musics();
    
    @Source("texts/patufet.txt")
    TextResource  patufet();
    
    @Source("texts/princepfelic.txt")
    TextResource  princepfelic();
    
    @Source("texts/princesapesol.txt")
    TextResource  princesapesol();
    
    @Source("texts/rapunzel.txt")
    TextResource rapunzel();
    
    @Source("texts/reinaabelles.txt")
    TextResource reinaabelles();
    
    @Source("texts/soldadetplom.txt")
    TextResource soldadetplom();
    
    @Source("texts/applicationtexts.txt")
    TextResource appTexts();
    

    
  
}