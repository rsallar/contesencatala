package cat.contesencatala.client.resources;

import com.google.gwt.resources.client.ClientBundleWithLookup;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
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
        String center();
        String main();
        String cardTitle();
        String content();
        String search();
    }	
   
    @Source("css/style.gss")
    Style style();
   
    @NotStrict
    @Source("css/myoverride.gss")
    MyOverride override();
    
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
    
    /*IMAGES*/
    @Source("talesimg/caputxeta.jpg")
    ImageResource  caputxeta_img();
    
    @Source("talesimg/aneguetlleig.png")
    ImageResource aneguetlleig_img();
    
    @Source("talesimg/patufet.png")
    ImageResource patufet_img();
    
    @Source("talesimg/flautista.jpg")
    ImageResource flautista_img();
    
    @Source("talesimg/gatbotes.jpg")
    ImageResource gatbotes_img();
    
    @Source("talesimg/princesapesol.jpg")
    ImageResource princesapesol_img();
    
    @Source("talesimg/reinaabelles.jpg")
    ImageResource reinaabelles_img();
    
    @Source("talesimg/rapunzel.jpg")
    ImageResource rapunzel_img();
    
    
    @Source("talesimg/musics.jpg")
    ImageResource musics_img();
    
    @Source("talesimg/soldadetplom.jpg")
    ImageResource soldadetplom_img();
    
    @Source("talesimg/princepfelic.png")
    ImageResource princepfelic_img();
    
  
}