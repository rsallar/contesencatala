package cat.contesencatala.client.application.talelist;

import java.util.List;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.view.client.SelectionModel;

import cat.contesencatala.client.application.widgets.loader.WidgetWrapper;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;

public class CustomCellList<T> extends CellList<T>{
	
	private WidgetWrapper containerAsWidget;
	
	public CustomCellList(Cell<T> cell) {
		super(cell);
		this.cell = cell;
		this.style = getDefaultResources().cellListStyle();
	    this.style.ensureInjected();
	    
	    this.getChildContainer().setId("taleListContainer");
	    containerAsWidget = new  WidgetWrapper(getChildContainer());
	}
	
	interface Template extends SafeHtmlTemplates {
	    @Template("<div id=\"{3}\" onclick=\"\" __idx=\"{0}\" class=\"{1}\" style=\"outline:none;\" >{2}</div>")
	    SafeHtml div(int idx, String classes, SafeHtml cellContents, String id);
	  }
	
	private static Resources DEFAULT_RESOURCES;
	private final Style style;
	private final Cell<T> cell;
	private String parentClassName;
	private static final Template TEMPLATE = GWT.create(Template.class);
	
	@Override
	  protected void renderRowValues(SafeHtmlBuilder sb, List<T> values, int start,
	      SelectionModel<? super T> selectionModel) {

	    int length = values.size();
	    int end = start + length;
	    for (int i = start; i < end; i++) {
	      T value = values.get(i - start);

	      StringBuilder classesBuilder = new StringBuilder();
	      
	      classesBuilder.append(" "+parentClassName);

	      SafeHtmlBuilder cellBuilder = new SafeHtmlBuilder();
	      Context context = new Context(i, 0, getValueKey(value));
	      cell.render(context, value, cellBuilder);
	      sb.append(TEMPLATE.div(i, parentClassName, cellBuilder.toSafeHtml(),"talecard"));
	    }
	  }
	
	@Override
	  protected void setKeyboardSelected(int index, boolean selected, boolean stealFocus) {
		/*
	    if (!isRowWithinBounds(index)) {
	      return;
	    }

	    Element elem = getRowElement(index);
	    if (!selected || isFocused || stealFocus) {
	      setStyleName(elem, style.cellListKeyboardSelectedItem(), selected);
	    }
	    setFocusable(elem, selected);
	    if (selected && stealFocus && !cellIsEditing) {
	      elem.focus();
	      onFocus();
	    }*/
		
		
	  }
	
	private static Resources getDefaultResources() {
	    if (DEFAULT_RESOURCES == null) {
	      DEFAULT_RESOURCES = GWT.create(Resources.class);
	    }
	    return DEFAULT_RESOURCES;
	  }
	
	public void addCellParentClassName(String parentClassName){
		this.parentClassName = parentClassName;
	}
	
}
