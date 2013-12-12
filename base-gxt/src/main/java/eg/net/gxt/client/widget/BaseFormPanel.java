package eg.net.gxt.client.widget;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

import eg.net.gxt.client.BaseBean;

/**
 * The Class BaseFormPanel.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class BaseFormPanel<T extends BaseBean> extends LayoutContainer {

	/** The bean. */
	private final T bean;

	/** The panel. */
	private final FormPanel panel;

	/**
	 * Instantiates a new base form panel.
	 * 
	 * @param bean
	 *            the bean
	 * @param title
	 *            the title
	 */
	public BaseFormPanel(T bean, String title) {
		super();
		this.bean = bean;
		this.panel = new FormPanel();
		if (title != null) {
			this.panel.setHeading(title);
		} else {
			this.panel.setHeaderVisible(false);
		}
		this.panel.setLabelWidth(55);
		this.panel.setPadding(5);
		setLayout(new FitLayout());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.extjs.gxt.ui.client.widget.LayoutContainer#onRender(com.google.gwt
	 * .user.client.Element, int)
	 */
	@Override
	protected void onRender(Element target, int index) {
		super.onRender(target, index);
		init();
	}

	/**
	 * Inits the.
	 */
	private void init() {
		attachFormControls(this.panel);
		FormBinding binding = new FormBinding(panel);
		binding.autoBind();
		binding.bind(this.bean);
		panel.setButtonAlign(HorizontalAlignment.RIGHT);
		attachFormButtons(this.panel);
		add(panel);
	}

	/**
	 * Attach form controls.
	 * 
	 * @param panel
	 *            the panel
	 */
	protected abstract void attachFormControls(FormPanel panel);

	/**
	 * Attach form buttons.
	 * 
	 * @param panel
	 *            the panel
	 */
	protected abstract void attachFormButtons(FormPanel panel);

	/**
	 * Gets the bean.
	 * 
	 * @return the bean
	 */
	public T getBean() {
		return bean;
	}

}
