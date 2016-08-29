package cat.contesencatala.client.resources;

import com.google.gwt.resources.client.ClientBundleWithLookup;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface AppResources extends ClientBundleWithLookup  {
    	
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
        String credits();
		String favorite();
		String homeButton();
        
    }	
   
    @Source("css/style.gss")
    Style style();
    
   
    /**APP IMAGES*/
    @Source("appimg/background.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource background();
    
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
    
    
    /**IMAGES*/
    
    /*IMAGES*/
    @Source("talesimgs/caputxeta.png")
    ImageResource  caputxeta_img();
    
    @Source("talesimgs/home.png")
    ImageResource  home_img();
    
    @Source("talesimgs/aneguetlleig.png")
    ImageResource aneguetlleig_img();
    
    @Source("talesimgs/patufet.png")
    ImageResource patufet_img();
    
    @Source("talesimgs/flautista.png")
    ImageResource flautista_img();
    
    @Source("talesimgs/gatbotes.png")
    ImageResource gatbotes_img();
    
    @Source("talesimgs/princesapesol.png")
    ImageResource princesapesol_img();
    
    @Source("talesimgs/reinaabelles.png")
    ImageResource reinaabelles_img();
    
    @Source("talesimgs/rapunzel.png")
    ImageResource rapunzel_img();
    
    
    @Source("talesimgs/musics.png")
    ImageResource musics_img();
    
    @Source("talesimgs/soldadetplom.png")
    ImageResource soldadetplom_img();
    
    @Source("talesimgs/princepfelic.png")
    ImageResource princepfelic_img();
    
  
  
}