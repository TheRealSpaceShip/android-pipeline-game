package sod.games.pipeline.pipes;

import java.util.ArrayList;

public class CornerPipe extends BasePipe{
	
	public CornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
	}

}
