package cat.contesencatala.client.services;

import com.google.gwt.core.client.JsArrayString;

public class InAppPurchase {
	
	
	public void test(){
		String[] products = {"pack1"};
		
		JsArrayString productsJs = toJsArray(products);
		getProducts(productsJs);

	}
	
	public static native void getProducts(JsArrayString products) /*-{
	  $wnd.inAppPurchase
      .getProducts(productIds)
      .then(function (products) {
        alert(products);
      });
	}-*/;
	
	
	public static JsArrayString toJsArray(String[] input) {
		JsArrayString jsArrayString = JsArrayString.createArray().cast();
		    for (String s : input) {
		        jsArrayString.push(s);
		    }
		    return jsArrayString; 
		}

}
