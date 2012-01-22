package sod.games.pipeline.pipes;

import java.util.ArrayList;

public class LinePipe extends BasePipe {
	public LinePipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
}
