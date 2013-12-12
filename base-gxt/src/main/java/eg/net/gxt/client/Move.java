package eg.net.gxt.client;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.fx.BaseEffect;

public class Move extends BaseEffect {

	private final int fromX, toX;
	private final int fromY, toY;
	private float accelerator;

	public Move(El el, int x, int y) {
		super(el);
		el.makePositionable();
		fromX = el.getX();
		fromY = el.getY();

		toX = x;
		toY = y;
		accelerator = 0.0001f;
	}

	@Override
	public void onUpdate(double progress) {
		int x = (int) getValue(fromX, toX, progress + accelerator);
		int y = (int) getValue(fromY, toY, progress + accelerator);

		el.setXY(x, y);
		accelerator += 0.0005f;
	}

	@Override
	public void onComplete() {
		super.onComplete();
		el.setXY(toX, toY);
	}
}
