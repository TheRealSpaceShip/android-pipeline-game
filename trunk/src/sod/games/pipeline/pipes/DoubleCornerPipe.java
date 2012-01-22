package sod.games.pipeline.pipes;

import java.util.ArrayList;

public class DoubleCornerPipe extends BasePipe {
	public DoubleCornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
		connectors.add(new Pair<Side,Side>(Side.West, Side.South));
	}

}
