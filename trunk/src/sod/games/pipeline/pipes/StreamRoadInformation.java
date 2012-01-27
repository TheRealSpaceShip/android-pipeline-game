package sod.games.pipeline.pipes;

import sod.games.pipeline.Direction;

public class StreamRoadInformation {
	public BasePipe pipe;
	public Direction comeFrom;
	public int[] position;

	public StreamRoadInformation(BasePipe pipe, Direction comeFrom,
			int[] position) {
		this.pipe = pipe;
		this.comeFrom = comeFrom;
		this.position = new int[]{position[0], position[1]};
	}
}
