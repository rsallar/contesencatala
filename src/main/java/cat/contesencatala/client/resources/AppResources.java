package cat.contesencatala.client.resources;

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
    
    @Source("tales/aneguetlleig.txt")
    TextResource  aneguetlleig();
    
    @Source("tales/caputxeta.txt" )
    TextResource  caputxeta();
    
    
    
    @Source("tales/flautista.txt")
    TextResource  flautista();
    
    @Source("tales/gatbotes.txt")
    TextResource  gatbotes();
    
    @Source("tales/musics.txt")
    TextResource  musics();
    
    @Source("tales/patufet.txt")
    TextResource  patufet();
    
    @Source("tales/princepfelic.txt")
    TextResource  princepfelic();
    
    @Source("tales/princesapesol.txt")
    TextResource  princesapesol();
    
    @Source("tales/rapunzel.txt")
    TextResource rapunzel();
    
    @Source("tales/reinaabelles.txt")
    TextResource reinaabelles();
    
    @Source("tales/soldadetplom.txt")
    TextResource soldadetplom();
    

    
  
}